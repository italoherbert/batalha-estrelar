package batalhaestrelar.kernel.cam;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.shape.GCShapeMediator;

public class CamManager implements CamKernel {

	private GCShapeMediator shapeMT;
	
	public CamManager(GCShapeMediator shapeMT) {
		this.shapeMT = shapeMT;
	}

	public void upMoveCamInFase( Fase fase ) {
		Cam cam = fase.getGame().getCam();		
		shapeMT.upMove( fase, cam, cam.getPositionIncrement() );
	}
	
	public boolean inScreen( Cam cam, ShapeGC shape ) {		
		float sw = cam.getScreen().getScreenWidth();		
		float sh = cam.getScreen().getScreenHeight();		
		return shapeMT.inScreen( shape, sw, sh );
	}
			
}
