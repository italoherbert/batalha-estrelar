package batalhaestrelar.painter.text.process;

import java.awt.Color;

public class ColorProcessor {

	private final String[] textColors = {
		"black", "white", "blue", "red", "green", "yellow", "orange", "gray", "lightgray", "darkgray", "cyan", "pink"	
	};
	private final Color[] colors = {
		Color.BLACK, Color.WHITE, Color.BLUE, Color.RED, Color.GREEN, 
		Color.YELLOW, Color.ORANGE,
		Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY,
		Color.CYAN, Color.PINK
	};
	
	public Color color( String ctext ) {
		for( int i = 0; i < textColors.length; i++ )
			if( ctext.equalsIgnoreCase( textColors[ i ] ) )
				return colors[ i ];
		return null;
	}
	
}
