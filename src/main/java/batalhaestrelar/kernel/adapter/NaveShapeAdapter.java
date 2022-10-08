package batalhaestrelar.kernel.adapter;

import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.NaveShapeDriver;

public class NaveShapeAdapter implements NaveShapeDriver {

	private Nave nave;
	private GunRotation[] gunRotations;
	
	public NaveShapeAdapter( Nave nave, int maxGunQuantity ) {
		this.nave = nave;
		this.gunRotations = new GunRotation[ maxGunQuantity ];
	}

	public boolean activeCondition() {
		return nave.activeCondition(); 
	}

	public GunRotation[] getGunRotations() {
		return gunRotations;
	}

	public int currentState() {
		return nave.currentState();
	}

}
