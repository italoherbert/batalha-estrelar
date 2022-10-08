package batalhaestrelar.kernel.shape;

import batalhaestrelar.kernel.BoundShapeGC;
import batalhaestrelar.kernel.ShapeGC;

public class GCShapeManager implements GCShapeKernel {

	private GCShapeMediator shapeMT;
	
	public GCShapeManager( GCShapeMediator shapeMT ) {
		this.shapeMT = shapeMT;
	}

	public boolean inScreen( ShapeGC sgc, float sw, float sh ) {
		return shapeMT.inScreen( sgc.getCamX(), sgc.getCamY(), sw, sh );
	}
	
	public boolean inScreen( float x, float y, float sw, float sh ) {
		return shapeMT.inScreen( x, y, sw, sh );
	}
	
	public boolean colision( ShapeGC sgc1, ShapeGC sgc2 ) {
		return shapeMT.colision( sgc1, sgc2 );
	}
	
	public boolean colision( float c1x1, float c1y1, float c1x2, float c1y2, float c2x1, float c2y1, float c2x2, float c2y2 ) {
		return shapeMT.colision( c1x1, c1y1, c1x2, c1y2, c2x1, c2y1, c2x2, c2y2 );
	}
		
	public boolean horizontalMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		return shapeMT.horizontalMove( base, sgc, inc );
	}

	public boolean verticalMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		return shapeMT.verticalMove( base, sgc, inc );
	}
	
	public boolean upMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		return shapeMT.upMove( base, sgc, inc );
	}
	
	public boolean downMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		return shapeMT.downMove( base, sgc, inc );
	}
	
	public boolean leftMove( BoundShapeGC base, ShapeGC sgc, float inc ) {		
		return shapeMT.leftMove( base, sgc, inc );
	}
	
	public boolean rightMove( BoundShapeGC base, ShapeGC sgc, float inc ) {
		return shapeMT.rightMove( base, sgc, inc );
	}	
	
}
