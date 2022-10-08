package batalhaestrelar.painter;

import italo.g2dlib.g2d.shape.PainterShape2DListener;
import italo.g2dlib.g2d.shape.Screen;
import italo.swingx.Graph;
import italo.swingx.Painter;
import batalhaestrelar.kernel.PainterKernel;
import batalhaestrelar.kernel.score.ScoreDriver;
import batalhaestrelar.painter.initial.InitialPainter;
import batalhaestrelar.painter.initial.InitialPainterDriver;
import batalhaestrelar.painter.shape.gunshots.GSPainter;
import batalhaestrelar.painter.shape.vu.VUS2DPainter;
import batalhaestrelar.painter.shape.vu.VUS2DPainterDriver;

public class PainterManager implements PainterKernel, VUS2DPainterDriver, InitialPainterDriver, Screen, Painter {
	
	private String centerMessage = "";
	private boolean centerMessageFlag = false;
	private boolean paintInitialScreen = true;
	
	private PainterShape2DListener gunshotS2DPainter;
	private PainterShape2DListener vuS2DPainter;
	private Painter inicialPainter = new InitialPainter( this );
		
	private PainterManagerDriver driver;
	private ScoreDriver score;
		
	public PainterManager( PainterManagerDriver driver ) {
		this.driver = driver;
		gunshotS2DPainter = new GSPainter( driver );
		vuS2DPainter = new VUS2DPainter( this );		
	}

	public void initialize( ScoreDriver score ) {
		this.score = score;		
	}
		
	public void paint( Graph g ) {		
		if( paintInitialScreen )
			inicialPainter.paint( g );			
		else driver.getKernel().getShapeKernel().paint( g );
	}

	public void repaint() {
		driver.getGraphUI().repaint();
	}

	public void showCenterMessage( String message ) {
		centerMessage = message;
		centerMessageFlag = true;
		
		driver.getGraphUI().repaint();
	}
	
	public void hideCenterMessage() {
		centerMessageFlag = false;
	}	
	
	public void centerMSGPainted() {
		
	}

	public PainterShape2DListener getGunshotsS2DListener() {
		return gunshotS2DPainter;
	}

	public PainterShape2DListener getVUPainterS2DListener() {
		return vuS2DPainter;
	}

	public Screen getScreen() {
		return this;
	}

	public int getWidth() {
		return driver.getGraphUI().getWidth();
	}

	public int getHeight() {
		return driver.getGraphUI().getHeight();
	}
		
	public String getCenterMessage() {
		return centerMessage;
	}

	public boolean isCenterMessageFlag() {
		return centerMessageFlag;
	}

	public ScoreDriver getScore() {
		return score;
	}

	public boolean isPaintInitialScreen() {
		return paintInitialScreen;
	}

	public void setPaintInitialScreen(boolean paintInitialScreen) {
		this.paintInitialScreen = paintInitialScreen;
	}
	
}
