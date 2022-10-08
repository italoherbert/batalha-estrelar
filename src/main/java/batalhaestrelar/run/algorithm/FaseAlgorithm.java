package batalhaestrelar.run.algorithm;

import italo.algorithm.Algorithm;

import java.util.List;

import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.ModuleManager;
import batalhaestrelar.kernel.PainterKernel;
import batalhaestrelar.kernel.ShapeKernel;
import batalhaestrelar.kernel.TimeKernel;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.fase.FaseKernel;
import batalhaestrelar.kernel.fase.FaseSession;
import batalhaestrelar.kernel.fase.FaseState;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameKernel;
import batalhaestrelar.kernel.nave.NaveKernel;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.modules.positionator.single.SinglePositionatorTO;
import batalhaestrelar.run.RunnerControl;
import batalhaestrelar.run.RunnerListener;

public class FaseAlgorithm implements Algorithm {
	
	private GameKernel gameKernel;
	private FaseKernel faseKernel;
	private NaveKernel naveKernel;
	private ShapeKernel shapeKernel;
	private PainterKernel graphicKernel;
	private ModuleManager moduleManager;
	private FaseSession session;
	private TimeKernel timeKernel;
	
	private PlayerAlgorithm playerAlgorithm;
	private ComputerAlgorithm computerAlgorithm;
	private Game game;
	private Fase fase;
	
	private Kernel kernel;
	private RunnerListener runnerListener;
	
	public FaseAlgorithm( RunnerControl driver ) {
		this.kernel = driver.getKernel();
		this.runnerListener = driver.getRunnerListener();
	}

	public void beforeExec() {		
		playerAlgorithm = new PlayerAlgorithm( kernel );
		computerAlgorithm = new ComputerAlgorithm( kernel );
		gameKernel = kernel.getGameKernel();
		faseKernel = kernel.getFaseKernel();
		naveKernel = kernel.getNaveKernel();
		shapeKernel = kernel.getShapeKernel();
		graphicKernel = kernel.getPainterKernel();
		moduleManager = kernel.getModuleManager();
		timeKernel = kernel.getTimeKernel();
		game = kernel.getGame();
		
		fase = gameKernel.getCurrentFase( game );
		session = fase.getSession();
		
		fase.getControl().init( true );
		shapeKernel.configureAfterInit( fase );
	
		List<ComputerGroup> compGroups = fase.getComputerGroups();
		for( ComputerGroup group : compGroups ) {
			int type = group.getGroupPositionatorType();
			List<Computer> list = group.getComputers();						
			moduleManager.getGroupPositionator( type ).positionate( fase, list );
		}
				
		List<BonusGroup> bonusGroup = fase.getBonusGroups();
		for( BonusGroup group : bonusGroup ) {
			int type = group.getGroupPositionatorType();
			List<Bonus> bonus = group.getBonusList();
			moduleManager.getGroupPositionator( type ).positionate( fase, bonus );
		}
		
		List<Computer> naves = fase.getComputerNaves();
		for( Computer c : naves ) {
			int type = c.getSinglePositionatorType();
			SinglePositionatorTO to = c.getSinglePositionatorTO();
			moduleManager.getSinglePositionator( type ).positionate( fase, c, to );
		}
		
		List<Bonus> bonusList = fase.getBonusList();
		for( Bonus b : bonusList ) {
			int type = b.getSinglePositionatorType();
			SinglePositionatorTO to = b.getSinglePositionatorTO();
			moduleManager.getSinglePositionator( type ).positionate( fase, b, to );
		}
		
		faseKernel.translateComputersByGroup( fase );
		
		naveKernel.addGunshotToAll( fase.getPlayer() );
		
		shapeKernel.configureBeforeRepaint( fase );
		session.setState( FaseState.EXECUTING );

		runnerListener.beforeInitFaseExecution( fase );
	}

	public boolean execCondition() {
		return session.getState() == FaseState.EXECUTING && !kernel.isGameExit();
	}
	
	public void execIT() {
		gameKernel.processScore( game );
		faseKernel.updateComputerInScreenList( fase );
		faseKernel.updateBonusListInScreen( fase );
		faseKernel.updateRandomNaveForShot( fase );
		faseKernel.processShotedPlayer( fase );
		faseKernel.processShotedComputerNaves( fase );
		faseKernel.processEnemiesInColision( fase );
		faseKernel.processBonusColision( fase );
		faseKernel.processMovePlayer( fase );
		
		playerAlgorithm.exec( fase.getPlayer() );
		
		List<Computer> naves = fase.getComputerNaves();
		for( Computer c : naves )
			computerAlgorithm.exec( c );
				
		List<Bonus> bonusList = fase.getBonusList();
		for( Bonus b : bonusList )
			moduleManager.getMover( b.getMoverType() ).move( fase, b, b.getMoverTO() ); 
		
		faseKernel.upMoveCam( fase );

		faseKernel.removeOutScreenComputerGunshots( fase );		
		faseKernel.moveComputerGunshots( fase );
				
		shapeKernel.configureBeforeRepaint( fase );
		graphicKernel.repaint();			
		
		timeKernel.faseExecutionSleep();
		
		session.setState( faseKernel.state( fase ) );
		session.getCounter().inc();
	}
	
	public void afterExec() {
		
	}
	
}
