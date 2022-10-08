package batalhaestrelar.gui.mainpanel;

import java.awt.GridLayout;

import javax.swing.JPanel;

import batalhaestrelar.gui.gpanel.GPanel;

public class MainPanelGUI extends JPanel implements MainPanelUI { 

	private static final long serialVersionUID = 1L;

	private GPanel gpanel = new GPanel();
	private MainPanelTO to = new MainPaneVO( this );
	
	public MainPanelGUI() {
		super.setLayout( new GridLayout() );
		super.add( gpanel );		
	}
	
	public GPanel getGPanel() {
		return gpanel;
	}

	public MainPanelTO getTO() {
		return to;
	}
	
}
