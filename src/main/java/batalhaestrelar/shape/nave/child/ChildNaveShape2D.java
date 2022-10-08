package batalhaestrelar.shape.nave.child;

import java.awt.Color;

import batalhaestrelar.shape.gun.GunShapesBuilder;
import batalhaestrelar.shape.nave.NaveShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class ChildNaveShape2D extends NaveShape2D {

	private ChildStateNaveShape2D normalStateS2D; 
	private ChildStateNaveShape2D shotedStateS2D; 
	private ChildStateNaveShape2D lowStateS2D;
	private ChildStateNaveShape2D destroyedStateS2D; 
	private ChildStateNaveShape2D inactiveStateS2D;

	private int gunQuantity = 1;
	
	public ChildNaveShape2D( GunShapesBuilder gsbuilder ) {
		super();
		
		normalStateS2D = new ChildStateNaveShape2D( gsbuilder, gunQuantity ); 
		shotedStateS2D = new ChildStateNaveShape2D( gsbuilder, gunQuantity );
		lowStateS2D = new ChildStateNaveShape2D( gsbuilder, gunQuantity );
		destroyedStateS2D = new ChildStateNaveShape2D( gsbuilder, gunQuantity ); 
		inactiveStateS2D = new ChildStateNaveShape2D( gsbuilder, gunQuantity );
	}	

	public void configure() {
		this.configureByShapeType( COLOR_CONF_S1 );
	}

	public void configureByShapeType( int type ) {
		Color baseColor1 = Color.DARK_GRAY; 
		Color baseColor2 = Color.WHITE;
		
		switch( type ) {
			case COLOR_CONF_S1: 
				baseColor1 = new Color( 22, 99, 24 ); 
				break;
			case COLOR_CONF_S2: 
				baseColor1 = new Color( 10, 91, 239 ); 
				break;
			case COLOR_CONF_S3:
				baseColor1 = new Color( 177, 119, 28 );
				break;
		}
				
		normalStateS2D.setColorAll( baseColor2, baseColor1 );
		normalStateS2D.setBottomBaseColor( baseColor1, baseColor2 );
		normalStateS2D.setTopBaseColor( baseColor2, baseColor1 );
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
