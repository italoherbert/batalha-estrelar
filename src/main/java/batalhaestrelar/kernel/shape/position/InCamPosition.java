package batalhaestrelar.kernel.shape.position;

import batalhaestrelar.kernel.ShapeGC;

public class InCamPosition implements Position {

	private ShapeGC sgc;

	public InCamPosition(ShapeGC sgc) {
		this.sgc = sgc;
	}

	public float getX() {
		return sgc.getCamX();
	}

	public float getY() {
		return sgc.getCamY();
	}
	
}

