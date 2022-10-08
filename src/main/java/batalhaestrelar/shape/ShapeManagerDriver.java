package batalhaestrelar.shape;

import italo.g2dlib.g2d.shape.PainterShape2DListener;
import italo.g2dlib.g2d.shape.Screen;
import batalhaestrelar.kernel.game.GameConfig;

public interface ShapeManagerDriver {

	public GameConfig getGameConfig();
	
	public PainterShape2DListener getGunshotsS2DListener();

	public PainterShape2DListener getVUPainterS2DListener();
		
	public Screen getScreen();
	
}
