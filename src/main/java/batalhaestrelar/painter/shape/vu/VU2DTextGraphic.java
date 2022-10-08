package batalhaestrelar.painter.shape.vu;

import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import batalhaestrelar.painter.text.TextGraphic;

public class VU2DTextGraphic implements TextGraphic {

	private Graph2D g2D;
	private Graph g;
	
	public void configure( Graph2D g2D, Graph g ) {
		this.g2D = g2D;
		this.g = g;
	}
	
	public void setFont( Font font ) {
		g2D.setFont( g, font );
	}

	public void setColor(Color color) {
		g2D.setColor( g, color );
	}

	public void drawString( String str, int x, int y ) {
		g2D.drawString( g, str, x, y );
	}

	public FontMetrics getFontMetrics(Font font) {
		return g2D.getFontMetrics( g, font ); 
	}

}
