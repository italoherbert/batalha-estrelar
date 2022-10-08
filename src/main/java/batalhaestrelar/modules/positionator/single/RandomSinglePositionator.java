package batalhaestrelar.modules.positionator.single;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;

public class RandomSinglePositionator implements SinglePositionator {

	public void positionate( Fase fase, ShapeGC sgc ) {
		float w = sgc.getShape().getWidth();
		float h = sgc.getShape().getHeight();
		
		float x1 = fase.getShape().getX1();
		float y1 = fase.getShape().getY1();
		float x2 = fase.getShape().getX2();
		float y2 = fase.getShape().getY2();
				
		sgc.setX( x1 + w*.5f + (float)( Math.random() * ( (x2-x1) - w ) ) );
		sgc.setY( y1 + h*.5f + (float)( Math.random() * ( (y2-y1) - h ) ) );
	}

	public void positionate( Fase fase, ShapeGC sgc, SinglePositionatorTO to ) {
		float cellWidth = fase.getShape().getCellWidth();
		float cellHeight = fase.getShape().getCellHeight();
		float faseX1 = fase.getShape().getX1();
		float faseY1 = fase.getShape().getY1();
		
		float w = sgc.getShape().getWidth();
		float h = sgc.getShape().getHeight();
		
		float randomX = (float)( Math.random() * ( cellWidth  - w ) );
		float randomY = (float)( Math.random() * ( cellHeight - h ) );
		float cellY = ( cellHeight * ( to.getCellNumber() -1 ) );
		
		sgc.setX( faseX1 + randomX + w*.5f );
		sgc.setY( faseY1 + randomY + h*.5f + cellY );				
	}

}
