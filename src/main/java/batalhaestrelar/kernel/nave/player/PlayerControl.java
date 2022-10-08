package batalhaestrelar.kernel.nave.player;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.FaseImpl;
import batalhaestrelar.kernel.nave.NaveControl;

public class PlayerControl extends NaveControl<PlayerControlTO> {
		
	private PlayerImpl player;
	
	public void buildNave( PlayerControlTO to ) {		
		player = (PlayerImpl)to.getNave();
		
		((FaseImpl)to.getFase()).setPlayer( player );		
	}

	public void initNave( PlayerControlTO to ) {
		PlayerConfig playerConfig = (PlayerConfig)to.getNaveConfig();
		
		player.setCamX( to.getGameConfig().getPlayerX() );		
		player.setCamY( to.getGameConfig().getPlayerY() );
		player.setPositionIncInCam( to.getGameConfig().getPlayerCamPositionIncrement() );
		
		player.setBonusDistributeAngle( playerConfig.getBonusDistributeAngle() );
		player.setBonusEnergyIncrement( playerConfig.getBonusEnergyIncrement() );
		player.setDistributeAngleInterval( playerConfig.getDistributeAngleInterval() );
		player.setEnergyIncInterval( playerConfig.getEnergyIncInterval() );
		player.setExpandShotInterval( playerConfig.getExpandShotInterval() );
		
		player.setInScreen( true );
		
		player.setGunOn( false );
		player.setLeftMoveOn( false );
		player.setRightMoveOn( false );
		player.setUpMoveOn( false );
		player.setDownMoveOn( false );
		player.setNormalState( Player.INITIAL_NORMAL_STATE );
	}

	public ShapeGC getShapeGC() {
		return player;
	}

}

