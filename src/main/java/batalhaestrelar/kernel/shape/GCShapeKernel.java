package batalhaestrelar.kernel.shape;

import batalhaestrelar.kernel.BoundShapeGC;
import batalhaestrelar.kernel.ShapeGC;

public interface GCShapeKernel {

	public boolean inScreen( ShapeGC sgc, float sw, float sh );
	
	public boolean inScreen( float x, float y, float sw, float sh );
	
	public boolean colision( ShapeGC sgc1, ShapeGC sgc2 );
	
	public boolean colision( float c1x1, float c1y1, float c1x2, float c1y2, float c2x1, float c2y1, float c2x2, float c2y2 );
		
	public boolean horizontalMove( BoundShapeGC base, ShapeGC sgc, float inc );

	public boolean verticalMove( BoundShapeGC base, ShapeGC sgc, float inc );
	
	public boolean upMove( BoundShapeGC base, ShapeGC sgc, float inc );
	
	public boolean downMove( BoundShapeGC base, ShapeGC sgc, float inc );
	
	public boolean leftMove( BoundShapeGC base, ShapeGC sgc, float inc );
	
	public boolean rightMove( BoundShapeGC base, ShapeGC sgc, float inc );
	
}
