package batalhaestrelar.kernel.cam;

import italo.control.ControlManagerInitializer;
import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.game.GameConfig;

public class CamInitializer {

	private ControlManagerInitializer<CamControlTO> cmInitializer = new ControlManagerInitializer<CamControlTO>();	

	public void initialize( GameConfig config, CamScreen screen, Game game ) {
		CamImpl cam = new CamImpl();
		
		CamControlVO vo = new CamControlVO();
		vo.setGameConfig( config );
		vo.setCam( cam );
		vo.setScreen( screen );
		vo.setGame( game );
		
		CamControl control = new CamControl();
		cmInitializer.initialize( game, cam, control, vo );
	}
	
}
