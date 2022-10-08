package batalhaestrelar.kernel.cam;

import batalhaestrelar.kernel.AbstractShapeGC;
import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.GCShape;
import batalhaestrelar.kernel.game.Game;

public class CamImpl extends AbstractShapeGC implements Cam {

	private Game game;
	private CamScreen screen;
	private float positionIncrement;
	
	private GCShape shape = new GCShape() {			
		public float getWidth() { 
			return screen.getScreenWidth();
		}			
		public float getHeight() {
			return screen.getScreenHeight();
		}
	};
	
	public GCShape getShape() {
		return shape;
	}

	public float getAbsX() {
		return super.getX();
	}

	public float getAbsY() {
		return super.getY();
	}
	
	public float getCamX() {
		return 0;
	}

	public float getCamY() {
		return 0;
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

	public float getPositionIncrement() {
		return positionIncrement;
	}

	public void setPositionIncrement(float positionIncrement) {
		this.positionIncrement = positionIncrement;
	}
	
}
