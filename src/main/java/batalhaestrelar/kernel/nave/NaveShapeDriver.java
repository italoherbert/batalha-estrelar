package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.gun.GunRotation;

public interface NaveShapeDriver {

	public boolean activeCondition();
	
	public GunRotation[] getGunRotations();
	
	public int currentState();
			
}
