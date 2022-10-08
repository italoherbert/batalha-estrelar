package batalhaestrelar.kernel.shape.position;

import batalhaestrelar.kernel.ShapeGC;

public class AbsPosition implements Position {

	private ShapeGC sgc;

	public AbsPosition(ShapeGC sgc) {
		this.sgc = sgc;
	}

	public float getX() {
		return sgc.getAbsX();
	}

	public float getY() {
		return sgc.getAbsY();
	}
	
}
