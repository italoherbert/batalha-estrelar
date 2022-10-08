package batalhaestrelar.kernel.gun;

import java.awt.Color;

import batalhaestrelar.kernel.AbstractGC;
import batalhaestrelar.kernel.nave.Nave;



public class GunImpl extends AbstractGC implements Gun {
		
	private float gunshotPosFactor;
	private float gunshotPosIncFactor;
	private float gunshotWidthFactor;
	private float gunshotRadialFactor;
	private float gunshotDistFactor;	
	private boolean repeat;
	private int graphType;

	private float rotationAngle;	

	private Nave nave;
	private GunDriver gunDriver;
	
	public float getCamX() {
		return nave.getCamX() + this.getX();
	}
	
	public float getCamY() {
		return nave.getCamY() + this.getY();
	}
	
	public float getAbsX() {
		return nave.getAbsX() + this.getX();
	}

	public float getAbsY() {
		return nave.getAbsY() + this.getY();
	}

	public int getIndex() {
		return gunDriver.getIndex();
	}
	
	public float getX() {
		return gunDriver.getX();
	}
	
	public float getY() {
		return gunDriver.getY();
	}
	
	public float getWidth() {
		return gunDriver.getWidth();
	}
		
	public float getAngle() {
		return gunDriver.getAngle();
	}
	
	public Color getGunshotColor() {
		return gunDriver.getGunshotColor();
	}
	
	public float getRadial() {
		return gunDriver.getRadial();
	}

	public float getGunshotWidthFactor() {
		return gunshotWidthFactor;
	}

	public void setGunshotWidthFactor( float gunshotWidthFactor ) {
		this.gunshotWidthFactor = gunshotWidthFactor;
	}

	public float getGunshotRadialFactor() {
		return gunshotRadialFactor;
	}
	
	public void setGunshotRadialFactor( float cumpriment  ) {
		this.gunshotRadialFactor = cumpriment;
	}

	public float getGunshotDistFactor() {
		return gunshotDistFactor;
	}

	public void setGunshotDistFactor( float desloc ) {
		this.gunshotDistFactor = desloc;
	}
	
	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat( boolean repeat ) {
		this.repeat = repeat;
	}

	public int getGraphType() {
		return graphType;
	}

	public void setGraphType( int graphType ) {
		this.graphType = graphType;
	}	
	
	public float getGunshotPosFactor() {
		return gunshotPosFactor;
	}

	public void setGunshotPosFactor(float gunshotPosFactor) {
		this.gunshotPosFactor = gunshotPosFactor;
	}

	public float getGunshotPosIncFactor() {
		return gunshotPosIncFactor;
	}

	public void setGunshotPosIncFactor(float gunshotPosIncFactor) {
		this.gunshotPosIncFactor = gunshotPosIncFactor;
	}

	public float getRotationAngle() {
		return rotationAngle;
	}

	public void setRotationAngle(float rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
	
	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public GunDriver getGunDriver() {
		return gunDriver;
	}

	public void setGunDriver(GunDriver driver) {
		this.gunDriver = driver;
	}
	
}