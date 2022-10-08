package batalhaestrelar.kernel.bonus;

import italo.control.ControlManagerInitializer;
import batalhaestrelar.kernel.ShapeFactory;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.GameConfig;


public class BonusInitializer {
	
	private ControlManagerInitializer<BonusControlTO> cmInitializer = new ControlManagerInitializer<BonusControlTO>();	
	
	public void initialize( ShapeFactory sfactory, GameConfig config, BonusGroup group, Fase fase, int faseIndex, int typeIndex ) {
		BonusImpl bonus = new BonusImpl();
				
		BonusConfig bonusConfig = config.getFaseConfigs()[ faseIndex ].getBonusConfigs()[ typeIndex ];
		
		int type = bonusConfig.getType();		
		BonusShape shape = sfactory.createAndAddBonusShape( faseIndex, type ); 
		
		BonusControlVO vo = new BonusControlVO();
		vo.setGameConfig( config );
		vo.setBonusConfig( bonusConfig );
		vo.setBonus( bonus );
		vo.setFase( fase );
		vo.setGroup( group );
		vo.setShape( shape );
						
		BonusControl control = new BonusControl();
		cmInitializer.initialize( fase, bonus, control, vo );
		
		shape.initialize( config, bonus );
	}

}
