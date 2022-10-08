package batalhaestrelar.run.algorithm;

import italo.algorithm.AlgorithmControl;
import italo.algorithm.SimpleAlgorithm;
import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.fase.FaseState;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameKernel;
import batalhaestrelar.kernel.game.GameSession;
import batalhaestrelar.kernel.game.GameState;
import batalhaestrelar.run.RunnerControl;

public class GameAlgorithm implements SimpleAlgorithm {
		
	private AlgorithmControl faseAlgCtrl;
	private Kernel kernel;
	
	public GameAlgorithm( RunnerControl driver ) {
		this.kernel = driver.getKernel();
		this.faseAlgCtrl = driver.getFaseControl();
		this.faseAlgCtrl.setAlgorithm( new FaseAlgorithm( driver ) );
	}

	public void exec() {
		GameKernel gameKernel = kernel.getGameKernel();

		Game game = kernel.getGame();
		GameSession session = game.getSession();

		game.getControl().init( false );
		
		session.setState( GameState.EXECUTING );
		while( session.getState() == GameState.EXECUTING && !kernel.isGameExit() ) {
			faseAlgCtrl.run();
						
			Fase fase = gameKernel.getCurrentFase( game );
			FaseState faseState = fase.getSession().getState();
			if( faseState == FaseState.WIN_FINISH ) {
				if( gameKernel.isLastFase( game ) ) {
					session.setState( GameState.ENDGAME );
				} else {
					gameKernel.nextFase( game );
				}
			} else if( faseState == FaseState.LOSE_FINISH ) {
				game.setLifeQuantity( game.getLifeQuantity() - 1 );
				if( game.getLifeQuantity() == 0 )
					session.setState( GameState.GAMEOVER );				
			}
		}		
	}
	
}
