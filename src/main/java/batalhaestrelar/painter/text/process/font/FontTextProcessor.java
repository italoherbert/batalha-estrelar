package batalhaestrelar.painter.text.process.font;

import java.awt.Font;
import java.util.Map;

import batalhaestrelar.painter.text.process.ColorProcessor;
import batalhaestrelar.painter.text.process.TextProcessor;

public class FontTextProcessor {
	
	private String defaultName = Font.SANS_SERIF;
	private int defaultStyle = 20;
	private int defaultSize = Font.PLAIN;
	private int defaultTX = -1;
	private int defaultTY = -1;
	private String defaultColor = "black";
	private String defaultBGColor = "white";
	
	private String globalInitMark = "@";
	private String initMark = "$";
	
	private TextProcessor tproc = new TextProcessor();
	private ColorProcessor cproc = new ColorProcessor();
			
	public Font createFont( TextFormat tf ) {		
		return new Font( tf.getFontName(), tf.getFontStyle(), tf.getFontSize() );
	}
	
	public TextFormat createTextFormat( Map<String, String> globalAttrs, String text ) {
		Map<String, String> attrs = tproc.attrs( initMark, text );
		String name = tproc.getStrValue( attrs.get( "name" ), globalAttrs.get( "name" ) );
		String style = tproc.getStrValue( attrs.get( "style" ), globalAttrs.get( "style" ) );
		String size = tproc.getStrValue( attrs.get( "size" ), globalAttrs.get( "size" ) );
		String tx = tproc.getStrValue( attrs.get( "tx" ), globalAttrs.get( "tx" ) );
		String ty = tproc.getStrValue( attrs.get( "ty" ), globalAttrs.get( "ty" ) );
		String color = tproc.getStrValue( attrs.get( "color" ), globalAttrs.get( "color" ) );
		String bgcolor = tproc.getStrValue( attrs.get( "bgcolor" ), globalAttrs.get( "bgcolor" ) );
		
		TextFormat tf = new TextFormat();
		tf.setFontName( tproc.getStrValue( name, defaultName ) );		
		tf.setFontStyle( tproc.getIntValue( style, defaultStyle ) );		
		tf.setFontSize( tproc.getIntValue( size, defaultSize ) );
		tf.setTX( tproc.getIntValue( tx, defaultTX ) );
		tf.setTY( tproc.getIntValue( ty, defaultTY ) );		
		tf.setColor( cproc.color( tproc.getStrValue( color, defaultColor ) ) );
		tf.setBackgroundColor( cproc.color( tproc.getStrValue( bgcolor, defaultBGColor ) ) );
		return tf;
	}
		
	public Map<String, String> globalAttrs( String text ) {
		return tproc.attrs( globalInitMark, text );
	}
	
	public Map<String, String> attrs( String text ) {
		return tproc.attrs( initMark, text );
	}
		
	public String globalTextContent( String text ) {
		return tproc.textContent( globalInitMark, text );
	}
	
	public String textContent( String text ) {
		return tproc.textContent( initMark, text );
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public int getDefaultStyle() {
		return defaultStyle;
	}

	public void setDefaultStyle(int defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

	public int getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(int defaultSize) {
		this.defaultSize = defaultSize;
	}

	public int getDefaultTX() {
		return defaultTX;
	}

	public void setDefaultTX(int defaultTX) {
		this.defaultTX = defaultTX;
	}

	public int getDefaultTY() {
		return defaultTY;
	}

	public void setDefaultTY(int defaultTY) {
		this.defaultTY = defaultTY;
	}

	public String getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(String defaultColor) {
		this.defaultColor = defaultColor;
	}

	public String getDefaultBGColor() {
		return defaultBGColor;
	}

	public void setDefaultBGColor(String defaultBGColor) {
		this.defaultBGColor = defaultBGColor;
	}
	
}
