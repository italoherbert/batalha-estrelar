package batalhaestrelar.kernel.game;

import batalhaestrelar.kernel.fase.FaseConfig;

public interface GameConfig {
		
	public int getLifeQuantity();
		
	public int getPontuationForDestroyedChildNave();

	public int getPontuationForDestroyedMotherNave();

	public int getPontuationForLifeIncrement();

	public float getCamPositionIncrement();
	
	public float getPlayerCamPositionIncrement();	
	
	public float getPlayerX();

	public float getPlayerY();	
		
	public float getBonusWidth();

	public float getBonusHeight();
	
	public FaseConfig[] getFaseConfigs();
	
}
