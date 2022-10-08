package italo.swingx.adapter;

import italo.swingx.GCScreen;

public class ImageScreen implements GCScreen {

	private ImageSource source;

	public ImageScreen(ImageSource source) {
		this.source = source;
	}

	public int getWidth() {
		return source.getImage().getWidth();
	}

	public int getHeight() {
		return source.getImage().getHeight();
	}
	
}
