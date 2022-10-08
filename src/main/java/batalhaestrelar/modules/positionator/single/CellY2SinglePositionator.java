package batalhaestrelar.modules.positionator.single;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;

public class CellY2SinglePositionator implements SinglePositionator {
	
	public void positionate( Fase fase, ShapeGC sgc, SinglePositionatorTO to ) {
		float faseY2 = fase.getY1() + ( fase.getShape().getCellHeight() * to.getCellNumber() );
		float naveH = sgc.getShape().getHeight();
		
		sgc.setX( 0 );
		sgc.setY( faseY2 - (naveH*.5f) );		
	}

}