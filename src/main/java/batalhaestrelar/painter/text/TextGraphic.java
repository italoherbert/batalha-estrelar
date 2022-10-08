package batalhaestrelar.painter.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public interface TextGraphic {

	public void setFont( Font font );
	
	public void setColor( Color color );
	
	public void drawString( String str, int x, int y );
	
	public FontMetrics getFontMetrics( Font font );
	
}
