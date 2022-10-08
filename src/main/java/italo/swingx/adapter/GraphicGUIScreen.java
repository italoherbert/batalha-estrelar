package italo.swingx.adapter;

import italo.swingx.GCScreen;
import italo.swingx.GraphicGUI;

public class GraphicGUIScreen implements GCScreen {

	private GraphicGUI gui;

	public GraphicGUIScreen( GraphicGUI gui ) {
		this.gui = gui;
	}

	public int getWidth() {
		return gui.getWidth();
	}

	public int getHeight() {
		return gui.getHeight();
	}
	
}
