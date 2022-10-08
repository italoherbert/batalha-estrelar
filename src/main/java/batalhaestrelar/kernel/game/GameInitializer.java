package batalhaestrelar.kernel.game;

import italo.control.ControlManagerInitializer;
import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.ShapeFactory;
import batalhaestrelar.kernel.cam.CamInitializer;
import batalhaestrelar.kernel.fase.FaseInitializer;

public class GameInitializer {

	private ControlManagerInitializer<GameControlTO> cmInitializer = new ControlManagerInitializer<GameControlTO>();
	private CamInitializer camInitializer = new CamInitializer();
	private FaseInitializer faseInitializer = new FaseInitializer();
	private Game game;		
	
	public void initialize( ShapeFactory sfactory, GameConfig config, CamScreen screen ) {
		game = new GameImpl();
		
		GameControlVO vo = new GameControlVO();
		vo.setGameConfig( config );
		vo.setGame( game );
		
		GameControl control = new GameControl();
		cmInitializer.initialize( game, control, vo );
		
		camInitializer.initialize( config, screen, game );
		
		int faseQuantity = config.getFaseConfigs().length;
		for( int i = 0; i < faseQuantity; i++ )
			faseInitializer.initialize( sfactory, config, i, game );
	}

	public Game getGame() {
		return game;
	}

}
