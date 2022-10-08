package batalhaestrelar.gui;

import javax.swing.JApplet;
import javax.swing.JFrame;

import batalhaestrelar.gui.mainpanel.MainPanelUI;

public interface GUI {

	public void setContentPane( JFrame jframe );

	public void setContentPane( JApplet japplet );
	
	public MainPanelUI getMainPanel();
	
}
