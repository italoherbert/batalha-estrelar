package batalhaestrelar.gui;

import javax.swing.JApplet;
import javax.swing.JFrame;

import batalhaestrelar.gui.mainpanel.MainPanelGUI;
import batalhaestrelar.gui.mainpanel.MainPanelUI;


public class GUIFacade implements GUI {
	
	private MainPanelGUI mainPanel = new MainPanelGUI();
	
	public void setContentPane( JFrame jframe ) {
		jframe.setContentPane( mainPanel );
	}

	public void setContentPane( JApplet japplet ) {
		japplet.setContentPane( mainPanel );
	}

	public MainPanelUI getMainPanel() {
		return mainPanel;
	}
}
