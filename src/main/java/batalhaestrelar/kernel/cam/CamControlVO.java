package batalhaestrelar.kernel.cam;

import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameConfig;

public class CamControlVO  implements CamControlTO {

	private GameConfig gameConfig;

	private Cam cam;
	private Game game;
	private CamScreen screen;

	public GameConfig getGameConfig() {
		return gameConfig;
	}

	public void setGameConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
	}

	public Cam getCam() {
		return cam;
	}

	public void setCam(Cam cam) {
		this.cam = cam;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public CamScreen getScreen() {
		return screen;
	}

	public void setScreen(CamScreen screen) {
		this.screen = screen;
	}

}
