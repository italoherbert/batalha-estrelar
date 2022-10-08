package batalhaestrelar.modules.positionator.group;

import java.util.List;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;


public interface GroupPositionator {

	public final static int NONE = 0;
	public final static int RANDOM_BY_CELL = 1;	
	
	public void positionate( Fase fase, List<? extends ShapeGC> sgc );
		
}
