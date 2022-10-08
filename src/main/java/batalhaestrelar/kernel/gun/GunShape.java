package batalhaestrelar.kernel.gun;

import java.awt.Color;

import batalhaestrelar.kernel.GCShape;

public interface GunShape extends GCShape {

	public float getX();
	
	public float getY();
	
	public float getRadial();
	
	public float getAngle();
	
	public float getGunWidth();
		
	public Color getGunshotColor();
	
}
