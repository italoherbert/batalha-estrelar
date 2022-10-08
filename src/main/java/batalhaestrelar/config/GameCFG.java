package batalhaestrelar.config;

import batalhaestrelar.config.fase1.Fase1CFG;
import batalhaestrelar.config.fase2.Fase2CFG;
import batalhaestrelar.kernel.fase.FaseConfig;
import batalhaestrelar.kernel.game.GameConfig;

public class GameCFG implements GameConfig {

	private int lifeQuantity = 3;

	private float camPositionIncrement = 0.01f;	
	private float playerCamPositionIncrement = 0.1f;
	
	private float playerX = 0.0f;
	private float playerY = -0.7f;	
	
	private int pontuationForDestroyedChildNave = 10;
	private int pontuationForDestroyedMotherNave = 50;
	private int pontuationForLifeIncrement = 500;
	
	private float bonusWidth = 0.1f;
	private float bonusHeight = 0.1f;
		
	private FaseConfig[] fases = {
		new Fase1CFG(),
		new Fase2CFG()
	};
		
	public int getLifeQuantity() {
		return lifeQuantity;
	}

	public int getPontuationForDestroyedChildNave() {
		return pontuationForDestroyedChildNave;
	}

	public int getPontuationForDestroyedMotherNave() {
		return pontuationForDestroyedMotherNave;
	}

	public int getPontuationForLifeIncrement() {
		return pontuationForLifeIncrement;
	}

	public float getCamPositionIncrement() {
		return camPositionIncrement;
	}
	
	public float getPlayerCamPositionIncrement() {
		return playerCamPositionIncrement;
	}
	
	public float getPlayerX() {
		return playerX;
	}

	public float getPlayerY() {
		return playerY;
	}

	public float getBonusWidth() {
		return bonusWidth;
	}

	public float getBonusHeight() {
		return bonusHeight;
	}
	
	public FaseConfig[] getFaseConfigs() {
		return fases;
	}

}
