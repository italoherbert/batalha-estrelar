package batalhaestrelar;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainJFrame {	
			
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable() {			
			public void run() {				
				JFrame jframe = new JFrame();
				jframe.setTitle( "Batalha Estrelar" );
				jframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				jframe.setSize( 600, 700 );
				jframe.setLocationRelativeTo( jframe );
				
				BatalhaEstrelar be = new BatalhaEstrelar();
				be.desktopExecute( jframe );
			}
		} );
	}

}
