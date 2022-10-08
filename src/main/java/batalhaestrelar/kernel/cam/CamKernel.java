package batalhaestrelar.kernel.cam;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;

public interface CamKernel {

	public void upMoveCamInFase( Fase fase );
			
	public boolean inScreen( Cam cam, ShapeGC shape );		

}
