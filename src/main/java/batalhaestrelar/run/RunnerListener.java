package batalhaestrelar.run;

import batalhaestrelar.kernel.fase.Fase;

public interface RunnerListener {

	public void beforeRun();
	
	public void afterRun();
	
	public void beforeRunGame();
	
	public void afterRunGame();
	
	public void beforeFaseRun();
	
	public void afterFaseRun();
	
	public void beforeInitFaseExecution( Fase fase );
	
}
