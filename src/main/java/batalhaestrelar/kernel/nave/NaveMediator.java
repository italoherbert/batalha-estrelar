package batalhaestrelar.kernel.nave;

import java.util.List;

import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.player.Player;
import batalhaestrelar.kernel.nave.player.PlayerImpl;

public class NaveMediator {	
		
	public boolean isDead( Nave nave ) {
		switch( nave.getState() ) {
			case Nave.DESTROYED_NAVE_STATE: return true;
			case Nave.INACTIVE_NAVE_STATE: return true;
		}
		return false;
	}
	
	public void changeState( Nave nave, int state ) {
		if( nave.getState() != Nave.NORMAL_NAVE_STATE )
			nave.getSession().getStateCounter().setCount( 0 );
		((NaveImpl)nave).setState( state );			
	}
	
	public void changeNormalState( Player player, int state ) {
		if( player.getState() == Nave.NORMAL_NAVE_STATE ) {
			if( player.getNormalState() != Nave.INITIAL_NORMAL_STATE )
				player.getSession().getStateCounter().setCount( 0 );
			player.setNormalState( state );
		}
	}
		
	public void updateNormalState( Player player ) {
		if( player.getState() == Nave.NORMAL_NAVE_STATE ) {
			if( player.getNormalState() == Nave.ENERGY_INC_NORMAL_STATE ) {
				NaveSession session = player.getSession();
				int count = session.getStateCounter().getCount();
				if( count < player.getEnergyIncInterval() ) {
					session.getStateCounter().inc();
				} else {
					player.setNormalState( Nave.INITIAL_NORMAL_STATE );
					session.getStateCounter().setCount( 0 );
				}					
			} else if( player.getNormalState() == Nave.EXPAND_SHOT_NORMAL_STATE ) {
				NaveSession session = player.getSession();
				int count = session.getStateCounter().getCount();
				if( count < player.getExpandShotInterval() ) {
					session.getStateCounter().inc();
				} else {
					player.setNormalState( Nave.INITIAL_NORMAL_STATE );
					session.getStateCounter().setCount( 0 );
				}
			}
		}
	}
	
	public void updateState( Nave nave ) {
		NaveSession session = nave.getSession();
		int state = nave.getState();
		if( state == Nave.SHOTED_NAVE_STATE ) {
			int count = session.getStateCounter().getCount();
			if( count < nave.getShotedInterval() ) {
				session.getStateCounter().inc();
			} else {
				if( nave.getEnergy() == 0 ) {
					if( nave instanceof Computer ) {
						Computer c = (Computer)nave;
						Game game = nave.getFase().getGame();
						int scoreValue = game.getSession().getScoreValue();
						int value = 0;
						if( c.getGroup().getType() == Computer.CHILD ) {
							value = game.getPontuationForDestroyedChildNave();
						} else if( c.getGroup().getType() == Computer.MOTHER ) {
							value = game.getPontuationForDestroyedMotherNave();
						}
						game.getSession().setScoreValue( scoreValue + value );
					}
					((NaveImpl)nave).setState( Nave.DESTROYED_NAVE_STATE );
				} else {
					((NaveImpl)nave).setState( Nave.NORMAL_NAVE_STATE );
				}
				session.getStateCounter().setCount( 0 );
			}					
		} else if( state == Nave.DESTROYED_NAVE_STATE ) {
			int count = session.getStateCounter().getCount();
			if( count < nave.getDestroyedInterval() ) {
				session.getStateCounter().inc();
			} else {
				((NaveImpl)nave).setState( Nave.INACTIVE_NAVE_STATE );
				session.getStateCounter().setCount( 0 );
			}
		}		
	}	
	
	public void distributeAngle( Nave nave, float angle ) {
		int size = nave.getGuns().size();
		
		for( int i = 0; i < size; i++ ) {
			GunRotation gun = nave.getGuns().get( i );
			gun.setRotationAngle( angle - ( i * ( ( 2.0f * angle ) / ( (float)(size-1) ) ) ) );			
		}
	}
	
	public Gun randomGun( Nave nave ) {
		List<Gun> guns = nave.getGuns();
		if( !guns.isEmpty() ) {
			int size = guns.size();
			int index = (int)Math.round( Math.random() * (size-1) );
			return guns.get( index );
		}
		return null;
	}
		
	public void horizontalMoveInScreen( Player player, float sw, float inc ) {
		if( inc < 0 ) 
			this.leftMoveInScreen( player, sw, -inc );
		else this.rightMoveInScreen( player, sw, inc );
	}

	public void verticalMoveInScreen( Player player, float sh, float inc ) {
		if( inc < 0 ) 
			this.downMoveInScreen( player, sh, -inc );
		else this.upMoveInScreen( player, sh, inc );
	}		

	public void upMoveInScreen( Player player, float sh, float inc ) {
		float y = player.getCamY();
		float h = player.getShape().getHeight();		
		if( ( y + h*.5f + inc ) < sh*.5f )
			((PlayerImpl)player).setCamY( y + inc );
		else ((PlayerImpl)player).setCamY( ( sh - h ) *.5f );
	}
	
	public void downMoveInScreen( Player player, float sh, float inc ) {
		float y = player.getCamY();
		float h = player.getShape().getHeight();
		if( ( y - h*.5f - inc ) >= -sh*.5f )
			((PlayerImpl)player).setCamY( y - inc );
		else ((PlayerImpl)player).setCamY( ( h - sh ) *.5f );
	}
	
	public void leftMoveInScreen( Player player, float sw, float inc ) {
		float x = player.getCamX();
		float w = player.getShape().getWidth();
		if( ( x - w*.5f - inc ) >= -sw*.5f )
			((PlayerImpl)player).setCamX( x - inc );
		else ((PlayerImpl)player).setCamX( ( w - sw ) *.5f );
	}
	
	public void rightMoveInScreen( Player player, float sw, float inc ) {
		float x = player.getCamX();
		float w = player.getShape().getWidth();
		if( ( x + w*.5f + inc ) < sw*.5f )
			((PlayerImpl)player).setCamX( x + inc );
		else ((PlayerImpl)player).setCamX( ( sw - w ) *.5f );
	}	
	
	
}
