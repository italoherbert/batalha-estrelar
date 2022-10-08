package batalhaestrelar.kernel.nave.player;

import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.kernel.nave.NaveControlVO;


public class PlayerControlVO extends NaveControlVO implements PlayerControlTO {

	private GameConfig gameConfig;
	
	public GameConfig getGameConfig() {
		return gameConfig;
	}

	public void setGameConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
	}

}
