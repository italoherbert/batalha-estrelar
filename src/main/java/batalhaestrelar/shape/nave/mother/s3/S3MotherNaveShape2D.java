package batalhaestrelar.shape.nave.mother.s3;

import java.awt.Color;

import batalhaestrelar.shape.nave.NaveShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class S3MotherNaveShape2D extends NaveShape2D {

	private S3MotherStateNaveShape2D normalStateS2D; 
	private S3MotherStateNaveShape2D shotedStateS2D; 
	private S3MotherStateNaveShape2D lowStateS2D;
	private S3MotherStateNaveShape2D destroyedStateS2D; 
	private S3MotherStateNaveShape2D inactiveStateS2D;

	private int gunQuantity = 5;
	
	public S3MotherNaveShape2D() {
		super();
		
		normalStateS2D = new S3MotherStateNaveShape2D( gunQuantity ); 
		shotedStateS2D = new S3MotherStateNaveShape2D( gunQuantity );
		lowStateS2D = new S3MotherStateNaveShape2D( gunQuantity );
		destroyedStateS2D = new S3MotherStateNaveShape2D( gunQuantity ); 
		inactiveStateS2D = new S3MotherStateNaveShape2D( gunQuantity );		
	}	

	public void configure() {
		Color baseColor2 = Color.WHITE;
		Color baseColor1 = new Color( 10, 91, 239 );
		
		normalStateS2D.setColorAll( baseColor1, baseColor2 );
		normalStateS2D.setGunsColor( baseColor2, baseColor1 );
	}

	public void configureByShapeType(int colorConfigType) {
		
	}

	public StateNaveShape2D getNormalStateS2D() {
		return normalStateS2D;
	}

	public StateNaveShape2D getShotedStateS2D() {
		return shotedStateS2D;
	}

	public StateNaveShape2D getLowStateS2D() {
		return lowStateS2D;
	}

	public StateNaveShape2D getDestroyedStateS2D() {
		return destroyedStateS2D;
	}

	public StateNaveShape2D getInactiveStateS2D() {
		return inactiveStateS2D;
	}

	public StateNaveShape2D[] getOtherStateS2Ds() {
		return null;
	}

	public int getGunQuantity() {
		return gunQuantity;
	}
	
}
