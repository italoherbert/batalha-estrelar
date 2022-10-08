package batalhaestrelar.kernel.nave;

import java.util.List;

import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.gun.GunMediator;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.nave.player.Player;
import batalhaestrelar.kernel.nave.player.PlayerImpl;
import batalhaestrelar.kernel.shape.GCShapeMediator;

public class NaveManager implements NaveKernel {
	
	private NaveMediator naveMT;
	private GunMediator gunMT;
	private GCShapeMediator shapeMT;
	
	public NaveManager( NaveMediator naveMT, GunMediator gunMT, GCShapeMediator shapeMT ) {
		this.naveMT = naveMT;
		this.gunMT = gunMT;
		this.shapeMT = shapeMT;
	}
		
	public Gun randomGun( Nave nave ) {
		return naveMT.randomGun( nave );
	}
	
	public void addGunshotToAll( Nave nave ) {
		List<Gun> guns = nave.getGuns();
		for( Gun gun : guns )
			this.addGunshot( nave, gun );
	}
	
	public Gunshot addGunshot( Nave nave, Gun gun ) {
		return gunMT.addGunshot( nave.getGunshotBuffer().getOwnBuffer(), gun );
	}
	
	public void updateDistributeGunsAngle( Player player ) {
		int interval = player.getDistributeAngleInterval();
		if( interval == 0 )
			return;
		
		int count = player.getSession().getDistributeGunsAngleCounter().getCount();
		if( count > 0  || count == -1 ) {
			float a;		
			if( count == -1 ) {
				a = 0;
			} else {
				a = ( (float)count / (float)interval ) * player.getBonusDistributeAngle();
			}
			naveMT.distributeAngle( player, a );
			Gunshot[] gunshots = player.getGunshotBuffer().getOwnBuffer();
			for( Gunshot gs : gunshots )
				if( gs.isActive() )
					if( gs.getGun().isRepeat() )
						gunMT.initGunshot( gs );
						
			if( count == 1 )
				player.getSession().getDistributeGunsAngleCounter().setCount( -1 );
			if( count == -1 )
				player.getSession().getDistributeGunsAngleCounter().setCount( 0 );
			else player.getSession().getDistributeGunsAngleCounter().dec();
		}
	}
	
	public void playerShotOn( Player player ) {
		((PlayerImpl)player).setGunOn( true );
	}
	
	public void playerShotOff( Player player ) {
		((PlayerImpl)player).setGunOn( false );
	}
	
	public boolean isKilled( Nave nave ) {
		return naveMT.isDead( nave );
	}
		
	public void updateState( Nave nave ) {
		naveMT.updateState( nave );
	}
				
	public void changeState( Nave nave, int state ) {
		naveMT.changeState( nave, state );
	}

	public void changeNormalState( Player player, int state ) {
		naveMT.changeNormalState( player, state );
	}

	public void updateNormalState( Player player ) {
		naveMT.updateNormalState( player );
	}

	public void horizontalMoveInScreen( Player player ) {
		float sw = player.getFase().getGame().getCam().getScreen().getScreenWidth();
		float inc = player.getPositionIncInCam();
		naveMT.horizontalMoveInScreen( player, sw, inc );
	}

	public void verticalMoveInScreen( Player player ) {
		float sh = player.getFase().getGame().getCam().getScreen().getScreenHeight();
		float inc = player.getPositionIncInCam();
		naveMT.verticalMoveInScreen( player, sh, inc );
	}
	
	public void leftMoveInScreen( Player player ) {
		float sw = player.getFase().getGame().getCam().getScreen().getScreenWidth();
		float inc = player.getPositionIncInCam();
		naveMT.leftMoveInScreen( player, sw, inc );	
	}
	
	public void rightMoveInScreen( Player player ) {		
		float sw = player.getFase().getGame().getCam().getScreen().getScreenWidth();
		float inc = player.getPositionIncInCam();
		naveMT.rightMoveInScreen( player, sw, inc );
	}
	
	public void upMoveInScreen( Player player ) {
		float sh = player.getFase().getGame().getCam().getScreen().getScreenHeight();
		float inc = player.getPositionIncInCam();
		naveMT.upMoveInScreen( player, sh, inc );		
	}
	
	public void downMoveInScreen( Player player ) {
		float sh = player.getFase().getGame().getCam().getScreen().getScreenHeight();
		float inc = player.getPositionIncInCam();
		naveMT.downMoveInScreen( player, sh, inc );
	}
	
	public boolean horizontalMoveInFase( Nave nave, float inc ) {
		return shapeMT.horizontalMove( nave.getFase(), nave, inc );
	}

	public boolean verticalMoveInFase( Nave nave, float inc ) {
		return shapeMT.verticalMove( nave.getFase(), nave, inc );
	}
	
	public boolean upMoveInFase( Nave nave, float inc ) {
		return shapeMT.upMove( nave.getFase(), nave, inc );
	}
	
	public boolean downMoveInFase( Nave nave, float inc ) {
		return shapeMT.downMove( nave.getFase(), nave, inc );
	}
	
	public boolean leftMoveInFase( Nave nave, float inc ) {
		return shapeMT.leftMove( nave.getFase(), nave, inc );
	}
	
	public boolean rightMoveInFase( Nave nave, float inc ) {
		return shapeMT.rightMove( nave.getFase(), nave, inc );
	}
			
}
