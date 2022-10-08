package batalhaestrelar.kernel.shape;

import batalhaestrelar.kernel.AbstractShapeGC;
import batalhaestrelar.kernel.BoundShapeGC;
import batalhaestrelar.kernel.GCShape;
import batalhaestrelar.kernel.ShapeGC;

public class GCShapeMediator {		
	
	public boolean inScreen( ShapeGC sgc, float sw, float sh ) {
		return this.inScreen( sgc.getCamX(), sgc.getCamY(), sw, sh );
	}
	
	public boolean inScreen( float x, float y, float sw, float sh ) {
		if( x < -sw*.5f )
			return false;
		if( y < -sh*.5f )
			return false;
		if( x >= sw*.5f )
			return false;
		if( y >= sh*.5f )
			return false;
		return true;
	}
	
	public boolean colision( ShapeGC sgc1, ShapeGC sgc2 ) {
		GCShape c1 = sgc1.getShape();
		GCShape c2 = sgc2.getShape();
		
		float c1x1 = sgc1.getX() - ( c1.getWidth()  *.5f );
		float c1y1 = sgc1.getY() - ( c1.getHeight() *.5f );
		float c1x2 = sgc1.getX() + ( c1.getWidth()  *.5f );
		float c1y2 = sgc1.getY() + ( c1.getHeight() *.5f );
		
		float c2x1 = sgc2.getX() - ( c2.getWidth()  *.5f );
		float c2y1 = sgc2.getY() - ( c2.getHeight() *.5f );
		float c2x2 = sgc2.getX() + ( c2.getWidth()  *.5f );
		float c2y2 = sgc2.getY() + ( c2.getHeight() *.5f );
		
		return this.colision( c1x1, c1y1, c1x2, c1y2, c2x1, c2y1, c2x2, c2y2 );
	}
	
	public boolean colision( float c1x1, float c1y1, float c1x2, float c1y2, float c2x1, float c2y1, float c2x2, float c2y2 ) {
		float minC2X = Math.min( c2x1, c2x2 ); 
		float maxC2X = Math.max( c2x1, c2x2 );				
		float minC2Y = Math.min( c2y1, c2y2 );
		float maxC2Y = Math.max( c2y1, c2y2 );		
		
		if( c1x1 < minC2X && c1x2 < minC2X )
			return false;
		if( c1x1 >= maxC2X && c1x2 >= maxC2X )
			return false;
		if( c1y1 < minC2Y && c1y2 < minC2Y )
			return false;
		if( c1y1 >= maxC2Y && c1y2 >= maxC2Y )
			return false;
		return true;
	}
		
	public boolean horizontalMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		if( inc < 0 ) 
			return this.leftMove( base, sgc, -inc );
		else return this.rightMove( base, sgc, inc );
	}

	public boolean verticalMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		if( inc < 0 ) 
			return this.downMove( base, sgc, -inc );
		else return this.upMove( base, sgc, inc );
	}
	
	public boolean upMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		float y = sgc.getY();
		float h = sgc.getShape().getHeight();		
		if( ( y + h*.5f + inc ) < base.getY2() ) {
			((AbstractShapeGC)sgc).setY( y + inc );
			return true;
		} else {
			((AbstractShapeGC)sgc).setY( base.getY2() - h*.5f );
			return false;
		}
	}
	
	public boolean downMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		float y = sgc.getY();
		float h = sgc.getShape().getHeight();
		if( ( y - h*.5f - inc ) >= base.getY1() ) {
			((AbstractShapeGC)sgc).setY( y - inc );
			return true;
		} else {
			((AbstractShapeGC)sgc).setY( base.getY1() + h*.5f );
			return false;
		}
	}
	
	public boolean leftMove( BoundShapeGC base, ShapeGC sgc, float inc ) {		
		float x = sgc.getX();
		float w = sgc.getShape().getWidth();
		if( ( x - w*.5f - inc ) >= base.getX1() ) {
			((AbstractShapeGC)sgc).setX( x - inc );
			return true;
		} else {
			((AbstractShapeGC)sgc).setX( base.getX1() + w*.5f );
			return false;
		}
	}
	
	public boolean rightMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		float x = sgc.getX();
		float w = sgc.getShape().getWidth();
		if( ( x + w*.5f + inc ) < base.getX2() ) {
			((AbstractShapeGC)sgc).setX( x + inc );
			return true;
		} else {
			((AbstractShapeGC)sgc).setX( base.getX2() - w*.5f );
			return false;
		}
	}	
	
}
