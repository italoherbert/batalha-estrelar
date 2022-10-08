package batalhaestrelar.config.fase2;

import batalhaestrelar.config.fase2.comps.ChildNaveCFGF2T1;
import batalhaestrelar.config.fase2.comps.ChildNaveCFGF2T2;
import batalhaestrelar.config.fase2.comps.MotherNaveCFGF2T1;
import batalhaestrelar.config.fase2.comps.MotherNaveCFGF2T2;
import batalhaestrelar.config.fase2.comps.MotherNaveCFGF2T3;
import batalhaestrelar.config.fase2.comps.MotherNaveCFGF2T4;
import batalhaestrelar.config.impl.bonus.EnergyIncBonusCFG;
import batalhaestrelar.config.impl.bonus.ExpandShotBonusCFG;
import batalhaestrelar.config.impl.nave.PlayerCFG;
import batalhaestrelar.kernel.bonus.BonusConfig;
import batalhaestrelar.kernel.fase.FaseConfig;
import batalhaestrelar.kernel.nave.computer.ComputerConfig;
import batalhaestrelar.kernel.nave.player.PlayerConfig;

public class Fase2CFG implements FaseConfig {

	private int cellQuantity = 7;
				
	private PlayerConfig playerConfig = new PlayerCFG();
	
	private ComputerConfig[] computerConfigs = {
		new ChildNaveCFGF2T1(), 
		new ChildNaveCFGF2T2(), 
		new MotherNaveCFGF2T1(), 
		new MotherNaveCFGF2T2(), 
		new MotherNaveCFGF2T3(), 
		new MotherNaveCFGF2T4()
	};
	
	private BonusConfig[] bonusConfigs = {
		new EnergyIncBonusCFG( 1, 1 ),
		new EnergyIncBonusCFG( 2, 2 ),
		new EnergyIncBonusCFG( 3, 1 ),
		new EnergyIncBonusCFG( 4, 2 ),
		new EnergyIncBonusCFG( 5, 1 ),
		new EnergyIncBonusCFG( 6, 3 ),
		new EnergyIncBonusCFG( 7, 1 ),
		new ExpandShotBonusCFG( 3, 2 ),
		new ExpandShotBonusCFG( 5, 1 ),
		new ExpandShotBonusCFG( 7, 3 )
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
