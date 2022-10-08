package batalhaestrelar.modules.move;

import batalhaestrelar.kernel.InScreenGC;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.shape.GCShapeKernel;
import batalhaestrelar.modules.ModuleDriver;

public class HorizontalMover implements Mover {

	private ModuleDriver driver;
	
	public HorizontalMover( ModuleDriver driver ) {
		this.driver = driver;
	}

	public void move( Fase fase, InScreenGC sgc, MoverTO to ) {
		GCShapeKernel shapeKernel = driver.getKernel().getGCShapeKernel();
		
		if( fase.getSession().getCounter().getCount() % to.getInterval() == 0 ) {
			if( sgc.isInScreen() ) {
				boolean moved = shapeKernel.horizontalMove( fase, sgc, to.getInc() );
				if( !moved )
					to.setIncrement( -to.getInc() );
			}
		}				
	}

}
