package italo.swingx;

import java.awt.Color;
import java.awt.Graphics;


public class GraphImpl implements Graph {

	private GraphUI gcomp;
	private Color color = Color.BLACK;

	public GraphImpl( GraphUI gcomp ) {
		super();
		this.gcomp = gcomp;
	}
	
	public void putAllPixels() {
		this.putAllPixels( this.color );
	}
	
	public void putAllPixels( Color c ) {
		int w = gcomp.getImage().getWidth();
		int h = gcomp.getImage().getHeight();
		for( int y = 0; y < h; y++ )
			for( int x = 0; x < w; x++ )
				this.putPixel( x, y, c );
	}
	
	public Color getPixel( int x, int y ) {
		int rgb = gcomp.getImage().getRGB( x, y );		
		return new Color(
			rgb >> 16,
			( rgb >> 8 ) & 0x0000FF,
			rgb & 0x0000FF
		);
	}
			
	public void putPixel( int x, int y ) {
		this.putPixel( x, y, this.color );
	}
	
	public void putPixel( int x, int y, Color c ) {
		gcomp.getImage().setRGB( x, y, c.getRGB() );
	}

	public GraphUI getComponent() {
		return gcomp;
	}
	
	public Graphics getGraphics() {
		return gcomp.getPainterGraphics();
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
