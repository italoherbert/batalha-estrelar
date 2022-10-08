package batalhaestrelar;

import italo.g2dlib.g2d.shape.PainterShape2DListener;
import italo.g2dlib.g2d.shape.Screen;
import italo.swingx.GraphUI;
import italo.swingx.GraphUIListener;

import javax.swing.JApplet;
import javax.swing.JFrame;

import batalhaestrelar.config.GameCFG;
import batalhaestrelar.controller.ControllerDriver;
import batalhaestrelar.controller.HandleFaseAlgorithm;
import batalhaestrelar.controller.HandleGPanel;
import batalhaestrelar.controller.HandleGameAlgorithm;
import batalhaestrelar.controller.HandleRunner;
import batalhaestrelar.gui.GUI;
import batalhaestrelar.gui.GUIFacade;
import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.KernelDriver;
import batalhaestrelar.kernel.KernelImpl;
import batalhaestrelar.kernel.ModuleManager;
import batalhaestrelar.kernel.PainterKernel;
import batalhaestrelar.kernel.ShapeKernel;
import batalhaestrelar.kernel.TimeKernel;
import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.math.Math2D;
import batalhaestrelar.modules.KModManager;
import batalhaestrelar.modules.ModuleDriver;
import batalhaestrelar.painter.PainterManager;
import batalhaestrelar.painter.PainterManagerDriver;
import batalhaestrelar.run.Runner;
import batalhaestrelar.run.RunnerImpl;
import batalhaestrelar.shape.ShapeManager;
import batalhaestrelar.shape.ShapeManagerDriver;
import batalhaestrelar.timer.TimeManager;
import batalhaestrelar.timer.TimeManagerDriver;

public class BatalhaEstrelar implements ControllerDriver, KernelDriver, PainterManagerDriver, ShapeManagerDriver, TimeManagerDriver, ModuleDriver {

	private GUI gui = new GUIFacade();
	
	private Kernel kernel = new KernelImpl( this );
	private ModuleManager moduleManager = new KModManager( this );
	private PainterManager graphicKernel = new PainterManager( this );
	private ShapeKernel shapeKernel = new ShapeManager( this );	
	private TimeManager timeManager = new TimeManager();
	
	private Runner runner = new RunnerImpl( kernel );		
	private Math2D math = new Math2D();
	private GameConfig gameConfig = new GameCFG();	

	private HandleGPanel handleGPanel = new HandleGPanel( this );
	
	private HandleGameAlgorithm handleGameAlgorithm = new HandleGameAlgorithm( this );
	private HandleFaseAlgorithm handleFaseAlgorithm = new HandleFaseAlgorithm( this );
	private HandleRunner handleRunner = new HandleRunner( this );

	public void desktopExecute( JFrame jframe ) {
		gui.setContentPane( jframe );

		gui.getMainPanel().getGPanel().getGraphUI().setPainter( graphicKernel );
		gui.getMainPanel().getGPanel().setGPanelListener( handleGPanel );
				
		runner.setRunnerListener( handleRunner );
		runner.getGameControl().setAlgorithmListener( handleGameAlgorithm );
		runner.getFaseControl().setAlgorithmListener( handleFaseAlgorithm );
		runner.getFaseControl().setPauseListener( handleFaseAlgorithm );
		
		jframe.setVisible( true );
		
		kernel.initialize();		
		runner.buildGame();
		runner.executeGame();
	}
	
	public void appletExecute( JApplet japplet ) {
		gui.setContentPane( japplet );

		gui.getMainPanel().getGPanel().getGraphUI().setPainter( graphicKernel );
		gui.getMainPanel().getGPanel().setGPanelListener( handleGPanel );
				
		runner.setRunnerListener( handleRunner );
		runner.getGameControl().setAlgorithmListener( handleGameAlgorithm );
		runner.getFaseControl().setAlgorithmListener( handleFaseAlgorithm );
		runner.getFaseControl().setPauseListener( handleFaseAlgorithm );
		
		gui.getMainPanel().getGPanel().getGraphUI().setGraphUIListener( new GraphUIListener() {			
			public void resized(GraphUI graphUI) {
				kernel.initialize();		
				runner.buildGame();
				runner.executeGame();
			}
		} );
				
	}
	
	public GraphUI getGraphUI() {
		return gui.getMainPanel().getGPanel().getGraphUI();
	}
	
	public GUI getGUI() {
		return gui;
	}

	public Kernel getKernel() {
		return kernel;
	}

	public GameConfig getGameConfig() {
		return gameConfig;
	}

	public ShapeKernel getShapeKernel() {
		return shapeKernel;
	}
	
	public PainterKernel getGraphicKernel() {
		return graphicKernel;
	}

	public TimeKernel getTimeKernel() {
		return timeManager;
	}

	public PainterShape2DListener getGunshotsS2DListener() {
		return graphicKernel.getGunshotsS2DListener();
	}

	public PainterShape2DListener getVUPainterS2DListener() {
		return graphicKernel.getVUPainterS2DListener();
	}

	public Screen getScreen() {
		return graphicKernel.getScreen();
	}

	public Math2D getMath() {
		return math;
	}

	public Runner getRunner() {
		return runner;
	}

	public ModuleManager getModuleManager() {
		return moduleManager;
	}

}
