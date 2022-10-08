package batalhaestrelar.painter.shape.vu;

import italo.g2dlib.g2d.shape.Screen;
import batalhaestrelar.kernel.score.ScoreDriver;

public interface VUS2DPainterDriver {

	public String getCenterMessage();
	
	public boolean isCenterMessageFlag();

	public ScoreDriver getScore();
	
	public Screen getScreen();	
	
	public void centerMSGPainted();
	
}
