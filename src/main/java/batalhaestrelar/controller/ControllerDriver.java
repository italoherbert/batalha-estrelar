package batalhaestrelar.controller;

import batalhaestrelar.gui.GUI;
import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.run.Runner;

public interface ControllerDriver {

	public GUI getGUI();
	
	public Kernel getKernel();
					
	public Runner getRunner();
	
}
