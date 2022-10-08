package italo.swingx;


import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;

public class GraphicGUI extends JComponent implements ComponentListener, GraphUISource {

	private static final long serialVersionUID = 1L;
	
	private GraphUIImpl graphUI = new GraphUIImpl( this ); 
			
	private boolean autoHeightImageResize = true;
	
	private GraphicComponentGUI gc = new GraphicComponentGUI( this ); 
	
	public GraphicGUI() {
		graphUI.newGraph();
		this.initComponents();
	}
	
	public GraphicGUI( Graph graph ) {
		graphUI.setGraph( graph );
		this.initComponents();
	}
	
	private void initComponents() {		
		super.setLayout( null );
		super.add( gc );
		
		super.addComponentListener( this );
	}
				
	public void componentResized(ComponentEvent e) {					
		int w;
		int h;
		if( autoHeightImageResize ) {
			double f = (double)super.getHeight() / (double)graphUI.getHeight();
			w = (int)Math.ceil( graphUI.getWidth() * f );
		} else {
			w = super.getWidth();
		}
		h = super.getHeight();
		int x = ( super.getWidth()  - w ) / 2;
		int y = ( super.getHeight() - h ) / 2;
		
		gc.setBounds( x, y, w, h );
		graphUI.newImage( w, h );
		
		graphUI.screenForImage();
		super.repaint();
		
		graphUI.setResized( true );
		graphUI.getGraphUIListener().resized( graphUI ); 
	}

	public void componentShown(ComponentEvent e) {
		
	}
	
	public void componentHidden(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}

	public GraphUI getGraphUI() {
		return graphUI;
	}

	GraphicComponentGUI getGraphicComponentGUI() {
		return gc;
	}

	public boolean isAutoHeightImageResize() {
		return autoHeightImageResize;
	}

	public void setAutoHeightImageResize(boolean autoHeightImageResize) {
		this.autoHeightImageResize = autoHeightImageResize;
	}
	
}
