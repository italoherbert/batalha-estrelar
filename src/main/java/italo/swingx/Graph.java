package italo.swingx;

import java.awt.Color;
import java.awt.Graphics;

public interface Graph {

	public Color getPixel( int x, int y );
			
	public void putPixel( int x, int y );
	
	public void putPixel( int x, int y, Color c );
	
	public Color getColor();

	public void setColor(Color color);
	
	public GraphUI getComponent();
	
	public Graphics getGraphics();
	
}
