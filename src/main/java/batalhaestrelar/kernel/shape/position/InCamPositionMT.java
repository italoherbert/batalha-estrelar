package batalhaestrelar.kernel.shape.position;

import batalhaestrelar.kernel.ShapeGC;

public class InCamPositionMT implements PositionMT {

	public float getX( ShapeGC sgc ) {
		return sgc.getCamX();
	}

	public float getY( ShapeGC sgc ) {
		return sgc.getCamY();
	}

}