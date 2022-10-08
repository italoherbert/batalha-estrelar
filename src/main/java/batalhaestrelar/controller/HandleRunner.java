package batalhaestrelar.controller;

import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.run.Runner;
import batalhaestrelar.run.RunnerListener;

public class HandleRunner implements RunnerListener {

	private ControllerDriver controller;
	
	public HandleRunner(ControllerDriver controller) {
		this.controller = controller;
	}

	public void beforeRun() {
		
	}
	
	public void beforeRunGame() {	
		Kernel kernel = controller.getKernel();
		kernel.setBlockFaseRunFlag( true );		
	}
	
	public void beforeInitFaseExecution( Fase fase ) {
		Kernel kernel = controller.getKernel();
		Runner runner = controller.getRunner();

		if( kernel.isBlockFaseRunFlag() ) {
			kernel.getPainterKernel().setPaintInitialScreen( false );
			if( !runner.getFaseControl().isPause() )
				runner.getFaseControl().pauseExecution();			
		}		
	}
		
	public void afterRun() {}
	public void afterRunGame() {}
	public void beforeFaseRun() {}
	public void afterFaseRun() {}	

}
