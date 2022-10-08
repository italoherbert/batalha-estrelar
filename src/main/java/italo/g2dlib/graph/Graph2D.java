package italo.g2dlib.graph;

import italo.swingx.Graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public interface Graph2D {

	public Color getColor( Graph graph );
	
	public void setColor( Graph graph, Color color );
	
	public void putPixel( Graph graph, int x, int y, Color color );
	
	public void drawLine( Graph graph, int x1, int y1, int x2, int y2 );
	
	public void drawRect( Graph graph, int x, int y, int w, int h );
	
	public void drawPolygon( Graph graph, int[] vx, int[] vy, int len );
	
	public void drawArc( Graph graph, int x, int y, int w, int h, int startAngle, int arcAngle );
	
	public void drawOval( Graph graph, int x, int y, int w, int h );
	
	public void fillRect( Graph graph, int x, int y, int w, int h );
	
	public void fillPolygon( Graph graph, int[] vx, int[] vy, int len );
	
	public void fillArc( Graph graph, int x, int y, int w, int h, int startAngle, int arcAngle );
	
	public void fillOval( Graph graph, int x, int y, int w, int h );
	
	public Font getFont( Graph graph );
	
	public void setFont( Graph graph, Font font );
	
	public void drawString( Graph graph, String str, int x, int y );
	
	public FontMetrics getFontMetrics( Graph graph, Font font );
	
}
