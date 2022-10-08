package batalhaestrelar.gui.mainpanel;

import batalhaestrelar.gui.gpanel.GPanel;

public class MainPaneVO implements MainPanelTO {

	private MainPanelGUI gui;

	public MainPaneVO(MainPanelGUI gui) {
		super();
		this.gui = gui;
	}

	@Override
	public GPanel getGPanel() {
		return gui.getGPanel();
	}
	
}
