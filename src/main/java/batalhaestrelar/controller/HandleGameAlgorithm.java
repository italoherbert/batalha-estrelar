package batalhaestrelar.controller;

import italo.algorithm.AlgorithmListener;
import batalhaestrelar.kernel.game.GameSession;
import batalhaestrelar.kernel.game.GameState;
import batalhaestrelar.painter.PainterConstants;

public class HandleGameAlgorithm implements AlgorithmListener {

	private ControllerDriver controller;
	
	public HandleGameAlgorithm( ControllerDriver controller ) {
		this.controller = controller;
	}

	public void beforeExec() {
		
	}

	public void afterExec() {
		if( controller.getKernel().isGameExit() )
			return;
		
		GameSession session = controller.getKernel().getGame().getSession();		
		if( session.getState() == GameState.ENDGAME ) {
			controller.getKernel().getPainterKernel().showCenterMessage( PainterConstants.ENDGAME );
		} else if( session.getState() == GameState.GAMEOVER ) {
			controller.getKernel().getPainterKernel().showCenterMessage( PainterConstants.GAMEOVER );
		}
		
		controller.getKernel().getTimeKernel().sleep( 10000 );		
		controller.getKernel().getPainterKernel().hideCenterMessage();		
	}

}
