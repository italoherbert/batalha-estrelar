package batalhaestrelar.kernel;

import batalhaestrelar.kernel.adapter.ScoreAdapter;
import batalhaestrelar.kernel.cam.CamKernel;
import batalhaestrelar.kernel.cam.CamManager;
import batalhaestrelar.kernel.fase.FaseKernel;
import batalhaestrelar.kernel.fase.FaseManager;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.kernel.game.GameInitializer;
import batalhaestrelar.kernel.game.GameKernel;
import batalhaestrelar.kernel.game.GameManager;
import batalhaestrelar.kernel.game.GameMediator;
import batalhaestrelar.kernel.game.GameState;
import batalhaestrelar.kernel.gun.GunKernel;
import batalhaestrelar.kernel.gun.GunManager;
import batalhaestrelar.kernel.gun.GunMediator;
import batalhaestrelar.kernel.nave.NaveKernel;
import batalhaestrelar.kernel.nave.NaveManager;
import batalhaestrelar.kernel.nave.NaveMediator;
import batalhaestrelar.kernel.shape.GCShapeKernel;
import batalhaestrelar.kernel.shape.GCShapeManager;
import batalhaestrelar.kernel.shape.GCShapeMediator;
import batalhaestrelar.math.Math2D;

public class KernelImpl implements Kernel, Math2DSourceDriver {
			
	private GCShapeMediator shapeMT = new GCShapeMediator();
	
	private GameMediator gameMT = new GameMediator();
	private NaveMediator naveMT = new NaveMediator();	
	private GunMediator gunMT = new GunMediator( this );		
	
	private GameKernel gameKernel = new GameManager( gameMT );
	private CamKernel camKernel = new CamManager( shapeMT );
	private FaseKernel faseKernel = new FaseManager( gunMT, naveMT, shapeMT );
	private NaveKernel naveKernel = new NaveManager( naveMT, gunMT, shapeMT );
	private GunKernel gunKernel = new GunManager( gunMT );
	private GCShapeKernel gcShapeKernel = new GCShapeManager( shapeMT );
	
	private GameInitializer gameInitializer = new GameInitializer();
	
	private boolean blockFaseRunFlag = false;
	private boolean finalizeFlag = false;
	
	private KernelDriver driver; 
	
	public KernelImpl( KernelDriver driver ) {
		this.driver = driver;
	}

	public void initialize() {		
		driver.getShapeKernel().initialize();

		GameConfig config = driver.getGameConfig();		
		ShapeFactory factory = driver.getShapeKernel();
		CamScreen screen = driver.getShapeKernel().getCamScreen();
		gameInitializer.initialize( factory, config, screen );
		
		Game game = gameInitializer.getGame();
		driver.getGraphicKernel().initialize( new ScoreAdapter( game ) );
	}
	
	public void exit() {
		finalizeFlag = true;
	}
	
	public boolean isGameExit() {
		return finalizeFlag || gameInitializer.getGame().getSession().getState() == GameState.FINALIZED;
	}

	public Game getGame() {
		return gameInitializer.getGame();
	}
	
	public GameKernel getGameKernel() {
		return gameKernel;
	}

	public CamKernel getCamKernel() {
		return camKernel;
	}

	public FaseKernel getFaseKernel() {
		return faseKernel;
	}

	public NaveKernel getNaveKernel() {
		return naveKernel;
	}

	public GunKernel getGunKernel() {
		return gunKernel;
	}

	public GCShapeKernel getGCShapeKernel() {
		return gcShapeKernel;
	}

	public ShapeKernel getShapeKernel() {
		return driver.getShapeKernel();
	}

	public PainterKernel getPainterKernel() {
		return driver.getGraphicKernel();
	}

	public TimeKernel getTimeKernel() {
		return driver.getTimeKernel();
	}

	public ModuleManager getModuleManager() {
		return driver.getModuleManager();
	}

	public Math2D getMath() {
		return driver.getMath();
	}

	public boolean isBlockFaseRunFlag() {
		return blockFaseRunFlag;
	}

	public void setBlockFaseRunFlag(boolean blockFaseRun) {
		this.blockFaseRunFlag = blockFaseRun;
	}

	public boolean isFinalizeFlag() {
		return finalizeFlag;
	}

	public void setFinalizeFlag(boolean finalizeFlag) {
		this.finalizeFlag = finalizeFlag;
	}		
		
}
