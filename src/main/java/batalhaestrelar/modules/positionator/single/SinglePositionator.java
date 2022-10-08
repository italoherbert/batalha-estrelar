package batalhaestrelar.modules.positionator.single;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;

public interface SinglePositionator {

	public final static int NONE = 0;
	public final static int RANDOM = 1;
	public final static int CELL_Y2 = 2;	
	public final static int CENTER = 3;
	
	public void positionate( Fase fase, ShapeGC sgc, SinglePositionatorTO to );

}
