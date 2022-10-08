package italo.swingx;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GraphicComponentGUI extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private GraphUISource source;
	
	public GraphicComponentGUI( GraphUISource source ) {
		this.source = source;
	}

	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
				
		GraphUIImpl graphUI = (GraphUIImpl)source.getGraphUI();		
						
		if( graphUI.isResized() ) {			
			graphUI.setPainterGraphics( graphUI.getImage().getGraphics() );
			graphUI.getPainter().paint( graphUI.getGraph() );
			
			g.drawImage( graphUI.getImage(), 0, 0, this );	
                        g.clipRect( 0, 0, super.getWidth(), super.getHeight() );
		}
	}			
	
}
