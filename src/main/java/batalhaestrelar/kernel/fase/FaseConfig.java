package batalhaestrelar.kernel.fase;

import batalhaestrelar.kernel.bonus.BonusConfig;
import batalhaestrelar.kernel.nave.computer.ComputerConfig;
import batalhaestrelar.kernel.nave.player.PlayerConfig;

public interface FaseConfig {

	public int getCellQuantity();
	
	public int getStarQuantity();
	
	public float getStarWidth();
	
	public float getStarHeight();
	
	public int getComputerGunshotBufferLength();
	
	public int getPlayerGunshotBufferLength();
							
	public PlayerConfig getPlayerConfig();
		
	public ComputerConfig[] getComputerConfigs();
	
	public BonusConfig[] getBonusConfigs();
			
}
