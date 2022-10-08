package batalhaestrelar.kernel.nave.computer;

import italo.control.ControlManagerInitializer;
import batalhaestrelar.kernel.ShapeFactory;
import batalhaestrelar.kernel.adapter.ComputerGunshotBuffer;
import batalhaestrelar.kernel.adapter.NaveShapeAdapter;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.kernel.gun.GunConfig;
import batalhaestrelar.kernel.gun.GunInitializer;
import batalhaestrelar.kernel.nave.NaveShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;

public class ComputerInitializer { 
	
	private ControlManagerInitializer<ComputerControlTO> cmInitializer = new ControlManagerInitializer<ComputerControlTO>();	
	private GunInitializer gunInitializer = new GunInitializer();

	public void initialize( ShapeFactory sfactory, GameConfig gameConfig, ComputerGroup group, Fase fase, int faseIndex, int groupIndex ) {				
		ComputerImpl nave = new ComputerImpl();
		
		ComputerConfig compConfig = gameConfig.getFaseConfigs()[ faseIndex ].getComputerConfigs()[ groupIndex ];
		GunConfig gunConfig = compConfig.getGunConfig();

		int type = compConfig.getType();
		int style = compConfig.getStyle();
		NaveShape shape = sfactory.createAndAddNaveShape( faseIndex, type, style ); 
		
		int gunQuantity = shape.getGunQuantity();
		NaveShapeDriver shapeDrv = new NaveShapeAdapter( nave, gunQuantity );
		
		ComputerControlVO vo = new ComputerControlVO();
		vo.setNaveConfig( compConfig );
		vo.setNave( nave );
		vo.setFase( fase );
		vo.setGroup( group );
		vo.setShape( shape );
		vo.setGunshotBuffer( new ComputerGunshotBuffer( fase ) );
		
		ComputerControl control = new ComputerControl();
		cmInitializer.initialize( fase, nave, control, vo );
				
		for( int i = 0; i < gunQuantity; i++ )
			gunInitializer.initialize( gunConfig, i, nave, shapeDrv );		
						
		shape.initialize( compConfig, shapeDrv );
	}
	
}
