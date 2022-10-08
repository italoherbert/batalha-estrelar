package batalhaestrelar.modules.positionator.group;

import java.util.List;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.fase.Fase;

public class RandomByCellGroupPositionator implements GroupPositionator {
	
	public void positionate( Fase fase ) {
		this.positionate( fase, null );
	}
	
	public void positionate( Fase fase, List<? extends ShapeGC> naves ) {				
		int size = naves.size();		
		
		int cellQuantity = fase.getCellQuantity();				
		int compQuantByCell = size / ( cellQuantity - 1 );
		int index = 0;
		int cellIndex = 1;
		for( ; cellIndex < cellQuantity; cellIndex++ ) {
			for( int j = 0; j < compQuantByCell; j++ ) {
				ShapeGC nave = naves.get( index );
				this.positionate( fase, nave, index, cellIndex );				
				index++;				
			}
		}
		cellIndex--;
		
		while( index < size ) {
			ShapeGC nave = naves.get( index );
			this.positionate( fase, nave, index, cellIndex );
			index++;
		}
	}
	
	private void positionate( Fase fase, ShapeGC nave, int index, int cellIndex ) {
		float cellWidth = fase.getShape().getCellWidth();
		float cellHeight = fase.getShape().getCellHeight();		
		float faseX1 = fase.getShape().getX1();
		float faseY1 = fase.getShape().getY1();
				
		float w = nave.getShape().getWidth();
		float h = nave.getShape().getHeight();
		
		float randomX = (float)( Math.random() * ( cellWidth  - w ) );
		float randomY = (float)( Math.random() * ( cellHeight - h ) );
		float cellY = cellHeight * cellIndex;
		
		nave.setX( faseX1 + randomX + w*.5f );
		nave.setY( faseY1 + randomY + h*.5f + cellY );		
	}
		
}
