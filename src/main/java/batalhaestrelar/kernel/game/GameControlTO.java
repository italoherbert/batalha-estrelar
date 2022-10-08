package batalhaestrelar.kernel.game;

import italo.control.ControlTO;

public interface GameControlTO extends ControlTO {

	public GameConfig getGameConfig();
	
	public Game getGame();
	
}
