package batalhaestrelar.run;

import italo.algorithm.AlgorithmControl;
import italo.algorithm.SimpleAlgorithm;
import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.game.GameState;
import batalhaestrelar.run.algorithm.GameAlgorithm;


public class RunnerImpl implements Runner, RunnerControl {
		
	private AlgorithmControl gameAlgCtrl = new AlgorithmControl();
	private AlgorithmControl faseAlgCtrl = new AlgorithmControl();
	
	private Kernel kernel;
	private RunnerListener listener = new RunnerAdapter();
	 
	public RunnerImpl( Kernel kernel ) {	
		this.kernel = kernel;
	}
	
	public void buildGame() {
		kernel.getGame().getControl().build( true );
		kernel.getGame().getSession().setState( GameState.EXECUTING );
	}

	public void executeGame() {			
		final RunnerControl runner = this;
		Thread thread = new Thread( new Runnable() {			
			public void run() {
				SimpleAlgorithm algorithm = new GameAlgorithm( runner );
				
				listener.beforeRun();
				while( !kernel.isFinalizeFlag() ) {										
					gameAlgCtrl.setSimpleAlgorithm( algorithm );
					
					listener.beforeRunGame();
					gameAlgCtrl.run();
					listener.afterRunGame();
				}
				listener.afterRun();
			}
		} );		
		thread.start();		
	}

	public void setRunnerListener(RunnerListener listener) {
		this.listener = listener;
	}

	public Kernel getKernel() {
		return kernel;
	}

	public RunnerListener getRunnerListener() {
		return listener;
	}

	public AlgorithmControl getGameControl() {
		return gameAlgCtrl;
	}

	public AlgorithmControl getFaseControl() {
		return faseAlgCtrl;
	}
		
}
