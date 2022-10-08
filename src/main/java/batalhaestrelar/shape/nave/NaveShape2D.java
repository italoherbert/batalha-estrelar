package batalhaestrelar.shape.nave;

import italo.g2dlib.g2d.shape.CardShape2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.kernel.nave.NaveConfig;
import batalhaestrelar.kernel.nave.NaveShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.shape.AbstractS2D;

public abstract class NaveShape2D extends AbstractS2D implements NaveShape, NaveShapeConstants {
					
	private NaveShapeDriver driver;
	protected CardShape2D cardS2D = new CardShape2D();
	
	public NaveShape2D() {
		super();
		super.addShape( cardS2D );
	}

	public abstract StateNaveShape2D getNormalStateS2D();
	public abstract StateNaveShape2D getShotedStateS2D();
	public abstract StateNaveShape2D getLowStateS2D();
	public abstract StateNaveShape2D getDestroyedStateS2D();
	public abstract StateNaveShape2D getInactiveStateS2D();
	public abstract StateNaveShape2D[] getOtherStateS2Ds();
	
	public abstract void configure();
	
	public void initialize( NaveConfig config, NaveShapeDriver driver ) {
		super.initialize();
				
		cardS2D.putShape( NORMAL_NAVE_STATE, this.getNormalStateS2D() );
		cardS2D.putShape( SHOTED_NAVE_STATE, this.getShotedStateS2D() );
		cardS2D.putShape( LOW_NAVE_STATE, this.getLowStateS2D() );
		cardS2D.putShape( DESTROYED_NAVE_STATE, this.getDestroyedStateS2D() );
		cardS2D.putShape( INACTIVE_NAVE_STATE, this.getInactiveStateS2D() );
		cardS2D.setCurrentShape( NORMAL_NAVE_STATE );	
		
		StateNaveShape2D[] others = this.getOtherStateS2Ds();		
		
		this.getNormalStateS2D().initialize( config, driver );		
		this.getShotedStateS2D().initialize( config, driver );
		this.getLowStateS2D().initialize( config, driver );
		this.getDestroyedStateS2D().initialize( config, driver );
		this.getInactiveStateS2D().initialize( config, driver );
						
		this.getNormalStateS2D().setColorAll( Color.WHITE, Color.DARK_GRAY );		
		this.getShotedStateS2D().setColorAll( Color.RED, Color.WHITE );		
		this.getLowStateS2D().setColorAll( Color.DARK_GRAY, Color.WHITE );		
		this.getDestroyedStateS2D().setColorAll( Color.BLACK, Color.ORANGE );		
		this.getInactiveStateS2D().setColorAll( Color.LIGHT_GRAY, Color.DARK_GRAY );
		
		if( others != null ) {
			for( StateNaveShape2D s : others ) {
				s.initialize( config, driver );
				s.setColorAll( Color.WHITE, Color.DARK_GRAY );
			}
		}	
		
		this.configure();				
		this.driver = driver;
	}		

	public void buildShape( Geom2DBuilder gb ) {}			
	
	public boolean activeCondition() {
		return ( driver == null ? true : driver.activeCondition() );
	}	
	
	public GunShape[] getGunShapes() {
		return ((StateNaveShape2D)cardS2D.getCurrentShape()).getGunShapes();
	}
		
	public float getWidth() {
		return ((StateNaveShape2D)cardS2D.getCurrentShape()).getWidth();
	}

	public float getHeight() {
		return ((StateNaveShape2D)cardS2D.getCurrentShape()).getHeight();
	}

	public CardShape2D getCardS2D() {
		return cardS2D;
	}
			
}
