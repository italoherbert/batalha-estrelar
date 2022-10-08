package batalhaestrelar.kernel.game;

import batalhaestrelar.kernel.fase.Fase;

public class GameManager implements GameKernel {

	private GameMediator gameMT;
	
	public void processScore( Game game ) {
		gameMT.processScore( game );
	}

	public GameManager( GameMediator gameMT ) {
		this.gameMT = gameMT;
	}

	public boolean nextFase( Game game ) {
		return gameMT.nextFase( game );
	}
			
	public boolean backFase( Game game ) {
		return gameMT.backFase( game );
	}

	public boolean isLastFase( Game game ) {
		return gameMT.isLastFase( game );
	}
	
	public Fase getCurrentFase( Game game ) {
		return gameMT.getCurrentFase( game );
	}
	
}
