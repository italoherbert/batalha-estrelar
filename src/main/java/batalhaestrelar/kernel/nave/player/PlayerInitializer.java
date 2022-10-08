package batalhaestrelar.kernel.nave.player;

import italo.control.ControlManagerInitializer;
import batalhaestrelar.kernel.ShapeFactory;
import batalhaestrelar.kernel.adapter.NaveShapeAdapter;
import batalhaestrelar.kernel.adapter.PlayerGunshotBuffer;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.kernel.gun.GunConfig;
import batalhaestrelar.kernel.gun.GunInitializer;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.NaveConfig;
import batalhaestrelar.kernel.nave.NaveShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;

public class PlayerInitializer {

	private ControlManagerInitializer<PlayerControlTO> cmInitializer = new ControlManagerInitializer<PlayerControlTO>();
	private GunInitializer gunInitializer = new GunInitializer();
	
	public void initialize( ShapeFactory sfactory, GameConfig gameConfig, Fase fase, int faseIndex ) {				
		PlayerImpl player = new PlayerImpl();
		
		NaveConfig naveConfig = gameConfig.getFaseConfigs()[ faseIndex ].getPlayerConfig();
		GunConfig gunConfig = naveConfig.getGunConfig();
		
		int style = naveConfig.getStyle();
		NaveShape shape = sfactory.createAndAddNaveShape( faseIndex, Nave.PLAYER, style ); 
		
		int gunQuantity = shape.getGunQuantity();
		NaveShapeDriver shapeDrv = new NaveShapeAdapter( player, gunQuantity );
		
		PlayerControlVO vo = new PlayerControlVO();
		vo.setGameConfig( gameConfig );
		vo.setNaveConfig( naveConfig );
		vo.setNave( player );
		vo.setFase( fase );
		vo.setShape( shape );
		vo.setGunshotBuffer( new PlayerGunshotBuffer( fase ) ); 
		
		PlayerControl control = new PlayerControl();
		cmInitializer.initialize( fase, player, control, vo );
		
		for( int i = 0; i < gunQuantity; i++ )
			gunInitializer.initialize( gunConfig, i, player, shapeDrv );
		
		shape.initialize( naveConfig, shapeDrv );
	}

}
