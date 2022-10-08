package batalhaestrelar.kernel;

import batalhaestrelar.kernel.cam.CamKernel;
import batalhaestrelar.kernel.fase.FaseKernel;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameKernel;
import batalhaestrelar.kernel.gun.GunKernel;
import batalhaestrelar.kernel.nave.NaveKernel;
import batalhaestrelar.kernel.shape.GCShapeKernel;

public interface Kernel {
	
	public void initialize();

	public void exit();

	public boolean isGameExit();

	public Game getGame();
	
	public GameKernel getGameKernel();
	
	public CamKernel getCamKernel();

	public FaseKernel getFaseKernel();

	public NaveKernel getNaveKernel();

	public GunKernel getGunKernel();
	
	public GCShapeKernel getGCShapeKernel();
	
	public ShapeKernel getShapeKernel();
	
	public PainterKernel getPainterKernel();
	
	public TimeKernel getTimeKernel();
	
	public ModuleManager getModuleManager();
	
	public boolean isBlockFaseRunFlag();

	public void setBlockFaseRunFlag( boolean blockFaseRun );

	public boolean isFinalizeFlag();

	public void setFinalizeFlag(boolean finalizeFlag);
	
}
