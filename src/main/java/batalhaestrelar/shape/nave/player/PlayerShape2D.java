package batalhaestrelar.shape.nave.player;

import java.awt.Color;

import batalhaestrelar.shape.nave.NaveShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class PlayerShape2D extends NaveShape2D {

	private PlayerStateNaveShape2D initialNormalStateS2D; 
	private PlayerStateNaveShape2D energyIncNormalStateS2D; 
	private PlayerStateNaveShape2D expandShotNormalStateS2D; 
	private PlayerStateNaveShape2D shotedStateS2D; 
	private PlayerStateNaveShape2D lowStateS2D; 
	private PlayerStateNaveShape2D destroyedStateS2D; 
	private PlayerStateNaveShape2D inactiveStateS2D;
	private PlayerStateNaveShape2D[] normalStateS2Ds = {};

	private int gunQuantity = 5;
	
	public PlayerShape2D() {
		super();
		
		initialNormalStateS2D = new PlayerStateNaveShape2D( gunQuantity ); 
		energyIncNormalStateS2D = new PlayerStateNaveShape2D( gunQuantity ); 
		expandShotNormalStateS2D = new PlayerStateNaveShape2D( gunQuantity ); 
		shotedStateS2D = new PlayerStateNaveShape2D( gunQuantity );
		lowStateS2D = new PlayerStateNaveShape2D( gunQuantity );
		destroyedStateS2D = new PlayerStateNaveShape2D( gunQuantity ); 
		inactiveStateS2D = new PlayerStateNaveShape2D( gunQuantity );
		normalStateS2Ds = new PlayerStateNaveShape2D[] { 
			energyIncNormalStateS2D, expandShotNormalStateS2D 
		};
		
		cardS2D.putShape( INITIAL_NORMAL_STATE, initialNormalStateS2D );
		cardS2D.putShape( ENERGY_INC_NORMAL_STATE, energyIncNormalStateS2D );
		cardS2D.putShape( EXPAND_SHOT_NORMAL_STATE, expandShotNormalStateS2D );
	}	

	public void configure() {
		for( PlayerStateNaveShape2D normalStateS2D : new PlayerStateNaveShape2D[]{ 
					initialNormalStateS2D, 
					energyIncNormalStateS2D, 
					expandShotNormalStateS2D 
				} ) {
			normalStateS2D.setGunsBaseColor( Color.WHITE, Color.LIGHT_GRAY );
			normalStateS2D.setBottomBaseColor( Color.WHITE, Color.LIGHT_GRAY );
			normalStateS2D.setTopBaseColor( new Color( 100, 150, 220 ), Color.WHITE );
			normalStateS2D.setTopColor( Color.WHITE, Color.WHITE );
			normalStateS2D.setGunsColor( Color.WHITE, Color.LIGHT_GRAY );
		}
		
		energyIncNormalStateS2D.setTopBaseColor( Color.GREEN, Color.WHITE );
		expandShotNormalStateS2D.setTopBaseColor( Color.BLUE, Color.WHITE );
		
		shotedStateS2D.setTopColor( Color.WHITE, new Color( 100, 150, 220 ) );
	}

	public void configureByShapeType(int colorConfigType) {
		
	}

	public StateNaveShape2D[] getOtherStateS2Ds() {
		return normalStateS2Ds;
	}
	
	public StateNaveShape2D getNormalStateS2D() {
		return initialNormalStateS2D;
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

	public int getGunQuantity() {
		return gunQuantity;
	}
	
}
