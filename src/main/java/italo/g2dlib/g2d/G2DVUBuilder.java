package italo.g2dlib.g2d;

import italo.g2dlib.g2d.shape.VirtualUniverse2D;
import italo.g2dlib.g2d.shape.VirtualUniverse2DImpl;

public class G2DVUBuilder {

	private G2DUtilities utilities;

	public G2DVUBuilder( G2DUtilities utilities ) {
		this.utilities = utilities;
	}
	
	public VirtualUniverse2D createVU() {
		return new VirtualUniverse2DImpl( utilities );
	}
	
}
