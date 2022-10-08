package batalhaestrelar.run;

import italo.algorithm.AlgorithmControl;


public interface Runner {

	public void buildGame();
	
	public void executeGame();
	
	public AlgorithmControl getGameControl();
	
	public AlgorithmControl getFaseControl();
	
	public void setRunnerListener( RunnerListener listener );
	
}
