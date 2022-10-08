package batalhaestrelar.kernel.gun;

import java.awt.Color;

import batalhaestrelar.kernel.GComponent;
import batalhaestrelar.kernel.nave.Nave;

public interface Gun extends GComponent, GunRotation, GunConfig {
	
	public float getRotationAngle();
	
	public Nave getNave();

	public int getIndex();
	
	public float getCamX();
	
	public float getCamY();
	
	public float getAbsX();

	public float getAbsY();

	public float getX();
	
	public float getY();
	
	public float getWidth();
	
	public float getRadial();
	
	public float getAngle();
	
	public Color getGunshotColor();
	
}
