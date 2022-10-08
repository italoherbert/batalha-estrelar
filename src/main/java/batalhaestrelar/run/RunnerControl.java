package batalhaestrelar.run;

import italo.algorithm.AlgorithmControl;
import batalhaestrelar.kernel.Kernel;

public interface RunnerControl {
	
	public Kernel getKernel();
	
	public AlgorithmControl getGameControl();
	
	public AlgorithmControl getFaseControl();
	
	public RunnerListener getRunnerListener();
	
}
