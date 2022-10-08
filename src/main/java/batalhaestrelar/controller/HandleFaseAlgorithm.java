package batalhaestrelar.controller;

import italo.algorithm.AlgorithmListener;
import italo.algorithm.PauseListener;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.fase.FaseSession;
import batalhaestrelar.kernel.fase.FaseState;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.nave.player.Player;
import batalhaestrelar.painter.PainterConstants;

public class HandleFaseAlgorithm implements AlgorithmListener, PauseListener {

	private ControllerDriver controller;
	
	public HandleFaseAlgorithm( ControllerDriver controller ) {
		this.controller = controller;
	}

	public void paused() {
		
	}

	public void pauseStarted() {
		String msg;
		if( controller.getKernel().isBlockFaseRunFlag() )
			msg = PainterConstants.BLOCK_INIT_FASE_RUM;
		else msg = PainterConstants.PAUSE;
		
		controller.getKernel().getPainterKernel().showCenterMessage( msg );		
	}

	public void executionStarted() {
		Game game = controller.getKernel().getGame();
		Fase fase = controller.getKernel().getGameKernel().getCurrentFase( game );
		
		Player player = fase.getPlayer();
		player.setUpMoveOn( false );
		player.setDownMoveOn( false );
		player.setLeftMoveOn( false );
		player.setRightMoveOn( false );
		controller.getKernel().getPainterKernel().hideCenterMessage();
	}

	public void beforeExec() {
		
	}

	public void afterExec() {		
		if( controller.getKernel().isGameExit() )
			return;
		
		Game game = controller.getKernel().getGame();
		Fase fase = controller.getKernel().getGameKernel().getCurrentFase( game );
					
		FaseSession session = fase.getSession();
		if( session.getState() == FaseState.WIN_FINISH ) {
			controller.getKernel().getPainterKernel().showCenterMessage( PainterConstants.FASE_WINED );
		} else {
			controller.getKernel().getPainterKernel().showCenterMessage( PainterConstants.LOSE );
		}				
		
		controller.getKernel().getTimeKernel().sleep( 1000 );		
		controller.getKernel().getPainterKernel().hideCenterMessage();
	}

}

