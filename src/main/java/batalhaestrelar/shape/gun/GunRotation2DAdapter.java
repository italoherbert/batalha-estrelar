package batalhaestrelar.shape.gun;

import italo.g2dlib.g2d.transform.Rotation2D;
import batalhaestrelar.kernel.gun.GunRotation;

public class GunRotation2DAdapter extends Rotation2D {

	private GunRotation rotation;

	public void setGunRotation( GunRotation rotation ) {
		this.rotation = rotation;
	}

	public float getX() {
		if( rotation == null )
			return 0;
		return rotation.getRotationAngle();
	}
	
	public float getY() {
		if( rotation == null )
			return 0;
		return rotation.getRotationAngle();
	}
	
}
