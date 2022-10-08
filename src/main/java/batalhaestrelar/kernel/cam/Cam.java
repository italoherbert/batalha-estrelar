package batalhaestrelar.kernel.cam;

import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.game.Game;

public interface Cam extends ShapeGC {

	public Game getGame();
	
	public CamScreen getScreen();
	
	public float getPositionIncrement();
	
}
