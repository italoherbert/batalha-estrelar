package batalhaestrelar.gui.gpanel;

import italo.swingx.GraphicGUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GPanel extends GraphicGUI implements KeyListener {

	private static final long serialVersionUID = 1L;

	private GPanelListener listener;
	
	public GPanel() {
		super();
		super.setFocusable( true );
		super.addKeyListener( this );
	}		

	@Override
	public void keyPressed( KeyEvent e ) {
		if( listener == null )
			return;
		listener.keyPressed( this, e );
	}

	public void keyReleased(KeyEvent e) {
		if( listener == null )
			return;
		listener.keyReleased( this, e );
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void setGPanelListener( GPanelListener listener ) {
		this.listener = listener;
	}
	
}
