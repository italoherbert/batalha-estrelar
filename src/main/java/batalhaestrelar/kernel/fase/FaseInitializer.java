package batalhaestrelar.kernel.fase;

import italo.control.ControlManagerInitializer;

import java.util.ArrayList;
import java.util.List;

import batalhaestrelar.kernel.ShapeFactory;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusConfig;
import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.bonus.BonusGroupImpl;
import batalhaestrelar.kernel.bonus.BonusInitializer;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.ComputerConfig;
import batalhaestrelar.kernel.nave.computer.ComputerInitializer;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroupImpl;
import batalhaestrelar.kernel.nave.player.PlayerInitializer;

public class FaseInitializer {
	
	private ControlManagerInitializer<FaseControlTO> cmInitializer = new ControlManagerInitializer<FaseControlTO>();	

	private PlayerInitializer playerInitializer = new PlayerInitializer();	
	private ComputerInitializer computerInitializer = new ComputerInitializer();
	private BonusInitializer bonusInitializer = new BonusInitializer();
	
	public void initialize( ShapeFactory sfactory, GameConfig gameConfig, int faseIndex, Game game ) {
		FaseImpl fase = new FaseImpl();
		List<ComputerGroup> computerGroups = new ArrayList<ComputerGroup>();
		List<BonusGroup> bonusGroups = new ArrayList<BonusGroup>();
	
		FaseShape shape = sfactory.createAndAddFaseShape( faseIndex );
				
		FaseControlVO vo = new FaseControlVO();
		vo.setFaseConfig( gameConfig.getFaseConfigs()[ faseIndex ] );
		vo.setFase( fase );
		vo.setGame( game );		
		vo.setIndex( faseIndex );
		vo.setComputerGroups( computerGroups );
		vo.setBonusGroups( bonusGroups );
		vo.setShape( shape );
		
		FaseControl control = new FaseControl();
		cmInitializer.initialize( game, fase, control, vo );
		
		FaseConfig faseConfig = gameConfig.getFaseConfigs()[ faseIndex ];
		ComputerConfig[] computerConfigs = faseConfig.getComputerConfigs();
				
		playerInitializer.initialize( sfactory, gameConfig, fase, faseIndex ); 
		for( int i = 0; i < computerConfigs.length; i++ ) {
			ComputerConfig cconf = computerConfigs[ i ];
			
			ComputerGroupImpl group = new ComputerGroupImpl();
			group.setType( cconf.getType() );
			group.setTranslationIndexes( cconf.getTranslationIndexes() );
			group.setTranslationValues( cconf.getTranslationValues() );
			group.setGroupPositionatorType( cconf.getGroupPositionatorType() );			
			group.setComputers( new ArrayList<Computer>() );
			
			int quant = computerConfigs[ i ].getQuantity();
			for( int j = 0; j < quant; j++ )
				computerInitializer.initialize( sfactory, gameConfig, group, fase, faseIndex, i );
			
			computerGroups.add( group );
		}

		BonusConfig[] bonusConfigs = faseConfig.getBonusConfigs();
		for( int i = 0; i < bonusConfigs.length; i++ ) {
			BonusGroupImpl group = new BonusGroupImpl();
			group.setType( bonusConfigs[ i ].getType() );
			group.setGroupPositionatorType( bonusConfigs[ i ].getGroupPositionatorType() ); 
			group.setBonusList( new ArrayList<Bonus>() );
			
			int quant = bonusConfigs[ i ].getQuantity();
			for( int j = 0; j < quant; j++ )
				bonusInitializer.initialize( sfactory, gameConfig, group, fase, faseIndex, i );
			
			bonusGroups.add( group );
		}
		
		shape.initialize( faseConfig );
	}
 
}
