package batalhaestrelar.kernel.shape.position;

import batalhaestrelar.kernel.ShapeGC;

public class AbsPositionMT implements PositionMT {

	public float getX( ShapeGC sgc ) {
		return sgc.getAbsX();
	}

	public float getY( ShapeGC sgc ) {
		return sgc.getAbsY();
	}

}
