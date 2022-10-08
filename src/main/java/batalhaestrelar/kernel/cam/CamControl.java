package batalhaestrelar.kernel.cam;

import batalhaestrelar.kernel.AbstractShapeControl;
import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.game.GameImpl;

public class CamControl extends AbstractShapeControl<CamControlTO> {

	private CamImpl cam;
	
	public void buildSCtrl( CamControlTO to ) {
		cam = (CamImpl)to.getCam();
		cam.setGame( to.getGame() );
		cam.setScreen( to.getScreen() );
		
		((GameImpl)to.getGame()).setCam( cam );		
	}
	
	public void initSCtrl( CamControlTO to ) {
		cam.setPositionIncrement( to.getGameConfig().getCamPositionIncrement() );
	}

	public ShapeGC getShapeGC() {
		return cam;
	}

}
