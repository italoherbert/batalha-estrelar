package italo.g2dlib.g2d;

import italo.g2dlib.g2d.shape.Screen;
import italo.g2dlib.g2d.shape.VirtualUniverse2D;

public class G2D {

	public VirtualUniverse2D createSimpleVU( Screen screen ) {
		G2DVUBuilder builder = this.createVUBuilder( screen );
		VirtualUniverse2D vu = builder.createVU();
		vu.configurePainterForThis();
		return vu;
	}
	
	public G2DVUBuilder createVUBuilder( Screen screen ) {
		return this.createVUBuilder( this.createG2DUtilities( screen ) );
	}
		
	public G2DVUBuilder createVUBuilder( G2DUtilities utils ) {
		return new G2DVUBuilder( utils );
	}
			
	public G2DUtilities createG2DUtilities( Screen screen ) {
		return new G2DUtils( screen );
	}
		
}
