package batalhaestrelar.painter.initial;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import batalhaestrelar.painter.text.TextGraphic;

public class PainterTextGraphic implements TextGraphic {

	private Graphics g;
	
	public void configure( Graphics g ) {
		this.g = g;
	}
	
	public void setFont(Font font) {
		g.setFont( font );
	}

	public void setColor(Color color) {
		g.setColor( color );
	}

	public void drawString(String str, int x, int y) {
		g.drawString( str, x, y );
	}

	public FontMetrics getFontMetrics(Font font) {
		return g.getFontMetrics( font ); 
	}

}
