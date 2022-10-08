package batalhaestrelar.painter.initial;

import italo.swingx.Graph;
import italo.swingx.Painter;
import batalhaestrelar.painter.PainterConstants;
import batalhaestrelar.painter.text.TextPainter;

public class InitialPainter implements Painter {

	private String message = PainterConstants.INITIAL_MESSAGE;
	
	private TextPainter textPainter = new TextPainter();
	private PainterTextGraphic textGraphic = new PainterTextGraphic();
	
	private InitialPainterDriver driver;
	
	public InitialPainter(InitialPainterDriver driver) {
		this.driver = driver;
	}

	public void paint( Graph g ) {		
		int screenW = driver.getScreen().getWidth();
		int screenH = driver.getScreen().getHeight();		
				
		textGraphic.configure( g.getGraphics() );		
		textPainter.paintCenterMessage( textGraphic, message, screenW, screenH );		
	}

}
