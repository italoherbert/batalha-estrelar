package batalhaestrelar.kernel.shape.position;

import batalhaestrelar.kernel.ShapeGC;

public class RelativePositionMT implements PositionMT {

	public float getX( ShapeGC sgc ) {
		return sgc.getX();
	}

	public float getY( ShapeGC sgc ) {
		return sgc.getY();
	}

}
