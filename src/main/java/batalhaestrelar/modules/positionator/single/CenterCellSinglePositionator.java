package batalhaestrelar.modules.positionator.single;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;

public class CenterCellSinglePositionator implements SinglePositionator {
	
	public void positionate( Fase fase, ShapeGC sgc, SinglePositionatorTO to ) {
		float cellH = fase.getShape().getCellHeight();
		
		sgc.setX( 0 );
		sgc.setY( fase.getY1() + ( cellH * to.getCellNumber() ) - cellH*.5f );
	}

}
