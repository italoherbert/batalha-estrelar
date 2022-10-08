package batalhaestrelar.kernel.adapter;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunDriver;
import batalhaestrelar.kernel.nave.Nave;


public class NaveGunAdapter implements GunDriver {
	
	private Nave nave;
	private int index;
	
	public NaveGunAdapter( Nave nave, int index ) {
		this.nave = nave;		
		this.index = index;		
	}	
			
	public int getIndex() {
		return index;
	}
	
	public Color getGunshotColor() {
		return nave.getShape().getGunShapes()[ index ].getGunshotColor(); 
	}

	public float getWidth() {
		return nave.getShape().getGunShapes()[ index ].getWidth(); 
	}

	public float getRadial() {
		return nave.getShape().getGunShapes()[ index ].getRadial();		
	}

	public float getAngle() {
		return nave.getShape().getGunShapes()[ index ].getAngle(); 
	}

	public float getX() {
		return nave.getShape().getGunShapes()[ index ].getX();
	}

	public float getY() {
		return nave.getShape().getGunShapes()[ index ].getY();
	}
		
}
