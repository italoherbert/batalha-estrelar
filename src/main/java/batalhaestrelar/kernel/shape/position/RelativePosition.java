package batalhaestrelar.kernel.shape.position;

import batalhaestrelar.kernel.ShapeGC;

public class RelativePosition implements Position {

	private ShapeGC sgc;

	public RelativePosition(ShapeGC sgc) {
		this.sgc = sgc;
	}

	public float getX() {
		return sgc.getX();
	}

	public float getY() {
		return sgc.getY();
	}
	
}

