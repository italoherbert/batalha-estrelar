package batalhaestrelar.controller;

import italo.algorithm.AlgorithmControl;

import java.awt.event.KeyEvent;

import batalhaestrelar.gui.gpanel.GPanel;
import batalhaestrelar.gui.gpanel.GPanelListener;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameState;
import batalhaestrelar.kernel.nave.player.Player;

public class HandleGPanel implements GPanelListener {

	private ControllerDriver controller;
	
	public HandleGPanel( ControllerDriver controller ) {
		this.controller = controller;
	}

	public void keyPressed( GPanel gpanel, KeyEvent event ) {
		if( controller.getKernel().isBlockFaseRunFlag() ) {
			if( controller.getRunner().getFaseControl().isPause() )
				controller.getRunner().getFaseControl().continueExecution();
			
			controller.getKernel().setBlockFaseRunFlag( false );
			controller.getKernel().getPainterKernel().hideCenterMessage();
			return;
		}
		
		AlgorithmControl control = controller.getRunner().getFaseControl();
		if( !control.isExecuting() )
			return;
		
		Game game = controller.getKernel().getGame();
		Fase fase = controller.getKernel().getGameKernel().getCurrentFase( game );
		Player player = fase.getPlayer();
		if( event.getKeyCode() == KeyEvent.VK_ESCAPE ) {
			if( control.isPause() )
				control.continueExecution();
			game.getSession().setState( GameState.FINALIZED );
		} else if( event.getKeyCode() == KeyEvent.VK_ENTER ) {
			control.pauseOrContinueExecution();
		} else {
			if( control.isPause() )
				return;

			if( event.getKeyCode() == KeyEvent.VK_BACK_SPACE ) {
				controller.getKernel().exit();
			} else if( event.getKeyCode() == KeyEvent.VK_RIGHT ) {
				player.setRightMoveOn( true );
			} else if( event.getKeyCode() == KeyEvent.VK_LEFT ) {
				player.setLeftMoveOn( true );
			} else if( event.getKeyCode() == KeyEvent.VK_DOWN ) {
				player.setDownMoveOn( true );
			} else if( event.getKeyCode() == KeyEvent.VK_UP ) {
				player.setUpMoveOn( true );
			} else if( event.getKeyCode() == KeyEvent.VK_SPACE ) {
				controller.getKernel().getNaveKernel().playerShotOn( player ); 
			}
		}
	}
	
	public void keyReleased( GPanel gpanel, KeyEvent event ) {
		AlgorithmControl control = controller.getRunner().getFaseControl();
		if( !control.isExecuting() || control.isPause() )
			return;		
		
		Game game = controller.getKernel().getGame();
		Player player = controller.getKernel().getGameKernel().getCurrentFase( game ).getPlayer();
		if( event.getKeyCode() == KeyEvent.VK_SPACE ) {
			controller.getKernel().getNaveKernel().playerShotOff( player );
		} else if( event.getKeyCode() == KeyEvent.VK_RIGHT ) {
			player.setRightMoveOn( false );
		} else if( event.getKeyCode() == KeyEvent.VK_LEFT ) {
			player.setLeftMoveOn( false );
		} else if( event.getKeyCode() == KeyEvent.VK_DOWN ) {
			player.setDownMoveOn( false );
		} else if( event.getKeyCode() == KeyEvent.VK_UP ) {
			player.setUpMoveOn( false );
		}
	}

}
