package batalhaestrelar.kernel;

import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.math.Math2D;

public interface KernelDriver {
	
	public Math2D getMath();
	
	public ShapeKernel getShapeKernel();
	
	public PainterKernel getGraphicKernel();
	
	public ModuleManager getModuleManager();
	
	public TimeKernel getTimeKernel();
	
	public GameConfig getGameConfig();
				
}
