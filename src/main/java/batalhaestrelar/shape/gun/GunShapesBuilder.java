package batalhaestrelar.shape.gun;

import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public interface GunShapesBuilder {

	public void build( StateNaveShape2D base, GunShape2D[] gunShapes, GunRotation[] gunRotations );
	
}
