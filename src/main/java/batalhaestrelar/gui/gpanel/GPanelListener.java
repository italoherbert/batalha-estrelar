package batalhaestrelar.gui.gpanel;

import java.awt.event.KeyEvent;


public interface GPanelListener {

	public void keyPressed( GPanel gpanel, KeyEvent event );
	
	public void keyReleased( GPanel gpanel, KeyEvent event );
	
}
