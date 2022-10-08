package batalhaestrelar.kernel.game;

public class GameControlVO implements GameControlTO {

	private GameConfig gameConfig;
	private Game game;

	public GameConfig getGameConfig() {
		return gameConfig;
	}

	public void setGameConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
