package italo.g2dlib.graph;

import italo.swingx.Graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;


public class Graph2DImpl implements Graph2D {

	public Color getColor( Graph graph ) {
		return graph.getGraphics().getColor();
	}
	
	public void setColor( Graph graph, Color color ) {
		graph.getGraphics().setColor( color );
	}
	
	public void putPixel( Graph graph, int x, int y, Color color ) {
		graph.putPixel( x, y, color );
	}
	
	public void drawLine( Graph graph, int x1, int y1, int x2, int y2 ) {
		graph.getGraphics().drawLine( x1, y1, x2, y2 );
	}
	
	public void drawRect( Graph graph, int x, int y, int w, int h ) {
		graph.getGraphics().drawRect( x, y, w, h );
	}
	
	public void drawPolygon( Graph graph, int[] vx, int[] vy, int len ) {
		graph.getGraphics().drawPolygon( vx, vy, len );
	}
	
	public void drawArc( Graph graph, int x, int y, int w, int h, int startAngle, int arcAngle ) {
		graph.getGraphics().drawArc( x, y, w, h, startAngle, arcAngle );
	}
	
	public void drawOval( Graph graph, int x, int y, int w, int h ) {
		graph.getGraphics().drawOval( x, y, w, h );
	}	
	
	public void fillRect( Graph graph, int x, int y, int w, int h ) {
		graph.getGraphics().fillRect( x, y, w, h );
	}
	
	public void fillPolygon( Graph graph, int[] vx, int[] vy, int len ) {
		graph.getGraphics().fillPolygon( vx, vy, len );		
	}
	
	public void fillArc( Graph graph, int x, int y, int w, int h, int startAngle, int arcAngle ) {
		graph.getGraphics().fillArc( x, y, w, h, startAngle, arcAngle );
	}
	
	public void fillOval( Graph graph, int x, int y, int w, int h ) {
		graph.getGraphics().fillOval( x, y, w, h );
	}

	public void drawString( Graph graph, String str, int x, int y ) {
		graph.getGraphics().drawString( str, x, y );
	}
	
	public Font getFont( Graph graph ) {
		return graph.getGraphics().getFont();
	}
	
	public void setFont( Graph graph, Font font ) {
		graph.getGraphics().setFont( font );
	}

	public FontMetrics getFontMetrics(Graph graph, Font font) {
		return graph.getGraphics().getFontMetrics( font ); 
	}	
	
}
