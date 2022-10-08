package batalhaestrelar.kernel.cam;

import italo.control.ControlTO;
import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameConfig;

public interface CamControlTO extends ControlTO {

	public GameConfig getGameConfig();

	public Cam getCam();

	public Game getGame();

	public CamScreen getScreen();
	
}
