package batalhaestrelar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;

public class MainJApplet extends JApplet implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	private BatalhaEstrelar be = new BatalhaEstrelar();
		
	public void init() {		
		super.addMouseListener( this );
		super.setSize( 480, 540 );
		
		be.appletExecute( this );
	}
	
	public void start() {
		be.getGUI().getMainPanel().getGPanel().transferFocus();
	}

	public void mousePressed(MouseEvent e) {
		be.getGUI().getMainPanel().getGPanel().transferFocus();
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}	
	
}
