package batalhaestrelar.config.fase1;

import batalhaestrelar.config.fase1.comps.ChildNaveCFGF1T1;
import batalhaestrelar.config.fase1.comps.ChildNaveCFGF1T2;
import batalhaestrelar.config.fase1.comps.MotherNaveCFGF1T1;
import batalhaestrelar.config.fase1.comps.MotherNaveCFGF1T2;
import batalhaestrelar.config.impl.bonus.EnergyIncBonusCFG;
import batalhaestrelar.config.impl.bonus.ExpandShotBonusCFG;
import batalhaestrelar.config.impl.nave.PlayerCFG;
import batalhaestrelar.kernel.bonus.BonusConfig;
import batalhaestrelar.kernel.fase.FaseConfig;
import batalhaestrelar.kernel.nave.computer.ComputerConfig;
import batalhaestrelar.kernel.nave.player.PlayerConfig;

public class Fase1CFG implements FaseConfig {

	private int cellQuantity = 5;
				
	private PlayerConfig playerConfig = new PlayerCFG();
	
	private ComputerConfig[] computerConfigs = {
		new ChildNaveCFGF1T1(), 
		new ChildNaveCFGF1T2(), 
		new MotherNaveCFGF1T1(), 
		new MotherNaveCFGF1T2()
	};
	
	private BonusConfig[] bonusConfigs = {
		new EnergyIncBonusCFG( 2, 1 ),
		new EnergyIncBonusCFG( 3, 2 ),
		new EnergyIncBonusCFG( 4, 1 ),
		new EnergyIncBonusCFG( 5, 2 ),
		new ExpandShotBonusCFG( 2, 1 ),
		new ExpandShotBonusCFG( 4, 1 ),
		new ExpandShotBonusCFG( 5, 1 )
	};
		
	private int starQuantity = 100;

	private float starWidth = 0.01f;
	private float starHeight = 0.01f;
		
	private int playerGunshotBufferLength = 20;
	private int computerGunshotBufferLength = 20;
		
	public int getCellQuantity() {
		return cellQuantity;
	}

	public int getStarQuantity() {
		return starQuantity;
	}

	public int getPlayerGunshotBufferLength() {
		return playerGunshotBufferLength;
	}

	public int getComputerGunshotBufferLength() {
		return computerGunshotBufferLength;
	}

	public float getStarWidth() {
		return starWidth;
	}

	public float getStarHeight() {
		return starHeight;
	}

	public PlayerConfig getPlayerConfig() {
		return playerConfig;
	}

	public ComputerConfig[] getComputerConfigs() {
		return computerConfigs;
	}

	public BonusConfig[] getBonusConfigs() {
		return bonusConfigs;
	}
		
}
