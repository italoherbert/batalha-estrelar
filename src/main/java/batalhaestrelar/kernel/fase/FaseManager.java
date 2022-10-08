package batalhaestrelar.kernel.fase;

import java.util.ArrayList;
import java.util.List;

import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusConstants;
import batalhaestrelar.kernel.bonus.BonusImpl;
import batalhaestrelar.kernel.cam.Cam;
import batalhaestrelar.kernel.gun.GunMediator;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.NaveMediator;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.ComputerImpl;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.kernel.nave.player.Player;
import batalhaestrelar.kernel.shape.GCShapeMediator;


public class FaseManager implements FaseKernel {

	private GunMediator gunMT;
	private NaveMediator naveMT;
	private GCShapeMediator shapeMT;
					
	public FaseManager( GunMediator gunMT, NaveMediator naveMT, GCShapeMediator shapeMT ) {
		this.gunMT = gunMT;
		this.naveMT = naveMT;
		this.shapeMT = shapeMT;
	}
	
	public void upMoveCam( Fase fase ) {
		List<Computer> computers = fase.getMotherNaves();
		float mnaveY = Float.MAX_VALUE;
		for( Computer c : computers ) {
			if( naveMT.isDead( c ) )
				continue;
			if( c.getAbsY() < mnaveY )
				mnaveY = c.getAbsY();			
		}
		Cam cam = fase.getGame().getCam();
		float camY = cam.getAbsY();
				
		float cellH = fase.getShape().getCellHeight();
		float faseY1 = fase.getY1();
				
		float mnaveFY = ( (int)( ( mnaveY - faseY1 ) / cellH ) ) * cellH;
		
		if( camY < mnaveFY )
			shapeMT.upMove( fase, cam, cam.getPositionIncrement() );
	}
			
	public void translateComputersByGroup( Fase fase ) {
		List<ComputerGroup> groups = fase.getComputerGroups();
		for( ComputerGroup g : groups ) {
			int[] indexes = g.getTranslationIndexes();
			if( indexes == null )
				continue;
			for( int i = 0; i < indexes.length; i++ ) {
				int index = indexes[ i ];
				float[] p = g.getTranslationValues()[ i ];
				Computer c = g.getComputers().get( index ); 
				c.setX( c.getX() + p[0] );
				c.setY( c.getY() + p[1] );
			}
		}
	}
	
	public void updateComputerInScreenList( Fase fase ) {
		float sw = fase.getGame().getCam().getScreen().getScreenWidth();
		float sh = fase.getGame().getCam().getScreen().getScreenHeight();
		int count = 0;
		for( Computer c : fase.getComputerNaves() ) {
			((ComputerImpl)c).setInScreen( shapeMT.inScreen( c.getCamX(), c.getCamY(), sw, sh ) );
			if( c.isInScreen() ) {
				fase.getSession().getInScreenComputers()[ count ] = c;
				count++;
			}
		}
		fase.getSession().setInScreenNaveQuantity( count );
	}
	
	public void updateBonusListInScreen( Fase fase ) {
		float sw = fase.getGame().getCam().getScreen().getScreenWidth();
		float sh = fase.getGame().getCam().getScreen().getScreenHeight();
		List<Bonus> bonusList = fase.getBonusList();
		for( Bonus b : bonusList )
			((BonusImpl)b).setInScreen( shapeMT.inScreen( b.getCamX(), b.getCamY(), sw, sh ) );			
	}
	
	public void updateRandomNaveForShot( Fase fase ) {
		FaseSession session = fase.getSession();
		int quantity = session.getInScreenNaveQuantity();
		if( quantity <= 0 ) {
			session.setNaveForShot( null );
			return;
		}
			
		int count = 0;
		List<Computer> naves = new ArrayList<Computer>();
		for( int i = 0; i < session.getInScreenNaveQuantity(); i++ ) {
			if( session.getInScreenComputers()[ i ].isShotOnlyIfSelected() ) {
				naves.add( session.getInScreenComputers()[ i ] );
				count++;
			}
		}
		if( count > 0 ) {
			int index = (int)Math.ceil( Math.random() * ( count - 1 ) );		
			session.setNaveForShot( naves.get( index ) );
		}
	}
	
	public void processMovePlayer( Fase fase ) {
		float sw = fase.getGame().getCam().getScreen().getScreenWidth();
		float sh = fase.getGame().getCam().getScreen().getScreenHeight();
		
		Player player = fase.getPlayer();
		if( player.isUpMoveOn() )
			naveMT.upMoveInScreen( player, sh, player.getPositionIncInCam() );
		if( player.isDownMoveOn() )
			naveMT.downMoveInScreen( player, sh, player.getPositionIncInCam() );
		if( player.isLeftMoveOn() )
			naveMT.leftMoveInScreen( player, sw, player.getPositionIncInCam() );
		if( player.isRightMoveOn() )
			naveMT.rightMoveInScreen( player, sw, player.getPositionIncInCam() );
	}
	
	public void processEnemiesInColision( Fase fase ) {
		Player player = fase.getPlayer();
		
		FaseSession session = fase.getSession();
		for( int i = 0; i < session.getInScreenNaveQuantity(); i++ ) {
			Computer n1 = session.getInScreenComputers()[ i ];
			if( !naveMT.isDead( n1 ) ) {
				if( shapeMT.colision( n1, player ) ) {
					if( n1.getState() == Nave.NORMAL_NAVE_STATE ) {
						n1.setEnergy( n1.getEnergy() - 1 );
						naveMT.changeState( n1, Nave.SHOTED_NAVE_STATE );
					}
					if( player.getState() == Nave.NORMAL_NAVE_STATE ) {
						player.setEnergy( player.getEnergy() - 1 );
						naveMT.changeState( player, Nave.SHOTED_NAVE_STATE );
					}
				}
			}
		}
	}
	
	public void processShotedComputerNaves( Fase fase ) {
		List<Computer> naves = fase.getComputerNaves();
		for( Computer c : naves ) {
			if( !c.getFase().getPlayer().isGunOn() )
					continue;		
			
			if( c.getState() == Nave.NORMAL_NAVE_STATE ) {
				if( c.isInScreen() ) {
					Gunshot gs = gunMT.shotedNaveVerify( c );
					if( gs != null ) {
						c.setEnergy( c.getEnergy() - 1 );
						naveMT.changeState( c, Nave.SHOTED_NAVE_STATE );					
					}
				}
			}
		}
	}
	
	public void processShotedPlayer( Fase fase ) {
		Player player = fase.getPlayer();
		if( player.getState() == Nave.NORMAL_NAVE_STATE ) {
			if( player.isInScreen() ) {
				Gunshot gs = gunMT.shotedNaveVerify( player );
				if( gs != null ) {
					player.setEnergy( player.getEnergy() - 1 );
					naveMT.changeState( player, Nave.SHOTED_NAVE_STATE );				
					gs.setActive( false );
				}
			}
		}
	}
	
	public void processBonusColision( Fase fase ) {
		Player player = fase.getPlayer();
		
		List<Bonus> bonusList = fase.getBonusList();
		for( Bonus b : bonusList ) {
			if( !b.isActive() )
				continue;
			
			if( shapeMT.colision( player, b ) ) {				
				switch( b.getGroup().getType() ) {
					case BonusConstants.ENERGY_INCREMENT:
						player.setEnergy( player.getEnergy() + player.getBonusEnergyIncrement() );
						naveMT.changeNormalState( player, Player.ENERGY_INC_NORMAL_STATE );
						break;
					case BonusConstants.EXPAND_SHOT:
						player.getSession().getDistributeGunsAngleCounter().setCount( player.getDistributeAngleInterval() );
						naveMT.changeNormalState( player, Player.EXPAND_SHOT_NORMAL_STATE );
						break;
				}
				((BonusImpl)b).setActive( false );
			}
		}
	}
	
	public void moveComputerGunshots( Fase fase ) {
		Gunshot[] gunshots = fase.getComputerGunshots();
		for( Gunshot gs : gunshots ) {
			if( gs.isActive() ) {
				float radial = gunMT.getGunshotPosIncRadial( gs.getGun() );
				float angle = gunMT.getGunshotAngle( gs );
				gunMT.move( gs, radial, angle );
			}
		}
	}
	
	public void removeOutScreenComputerGunshots( Fase fase ) {
		float sw = fase.getGame().getCam().getScreen().getScreenWidth();
		float sh = fase.getGame().getCam().getScreen().getScreenHeight();
		for( Gunshot gs : fase.getComputerGunshots() )
			if( gs.isActive() )
				if( !shapeMT.inScreen( gs.getCamX(), gs.getCamY(), sw, sh ) )
					gs.setActive( false );									
	}	
		
	public FaseState state( Fase fase ) {
		if( fase.getPlayer().getEnergy() == 0 ) {
			return FaseState.LOSE_FINISH;
		} else if( this.isWin( fase ) ) { 
			return FaseState.WIN_FINISH;				
		}
		return FaseState.EXECUTING;		
	}
	
	public boolean isWin( Fase fase ) {
		List<Computer> motherNaves = fase.getMotherNaves();
		for( Computer c : motherNaves )
			if( c.getState() != Nave.INACTIVE_NAVE_STATE )
				return false;
		return true;
	}	
		
	public boolean isLastFaseCell( Fase fase ) {
		Player player = fase.getPlayer();
		float faseY2 = fase.getShape().getY2();
		float faseC2 = fase.getShape().getCellHeight();
		
		return player.getY() >= ( faseY2 - ( faseC2*.5f ) );
	}
			
}
