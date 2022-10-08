package batalhaestrelar.painter.text.process.font;

import java.awt.Color;

public class TextFormat {

	private String fontName;
	private int fontStyle;
	private int fontSize;
	private int tx;
	private int ty;
	private Color color;
	private Color backgroundColor;

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getTX() {
		return tx;
	}

	public void setTX(int tx) {
		this.tx = tx;
	}

	public int getTY() {
		return ty;
	}

	public void setTY(int ty) {
		this.ty = ty;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

}
