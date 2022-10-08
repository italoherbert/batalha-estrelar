package batalhaestrelar.shape.nave;

import italo.g2dlib.g2d.shape.AbstractGroupShape2D;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.kernel.nave.NaveConfig;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.shape.gun.GunShape2D;
import batalhaestrelar.shape.gun.NaveS2DSource;

public abstract class StateNaveShape2D extends AbstractGroupShape2D implements NaveS2DSource {

	private final float dimension = 16.0f;
	
	protected float width;
	protected float height;
	protected float pxWidth;
	protected float pxHeight;
	protected GunShape2D[] gunShapes = {};
				
	public StateNaveShape2D( int gunQuantity ) {
		this.gunShapes = new GunShape2D[ gunQuantity ];
	}
			
	public abstract GunShape[] getGunShapes();
	
	public abstract void initializeAndBuildGuns( NaveShapeDriver driver );
		
	public void initialize( NaveConfig config, NaveShapeDriver driver ) {
		this.width = config.getWidth();
		this.height = config.getHeight();
		this.pxWidth = width / dimension;
		this.pxHeight = height / dimension;
			
		super.setVertexesVisible( false );
		super.setEdgesVisible( false );
		super.setFacesVisible( true );
		
		this.initializeAndBuildGuns( driver );
	}
		
	public void setColorAll( Color color, Color borderColor ) {
		this.setNaveColorAll( color, borderColor );
		this.setGunsColor( color, borderColor );
	}

	public void setNaveColorAll( Color color, Color borderColor ) {
		super.getColorizer2D().setFaceFillColor( color );
		super.getColorizer2D().setFaceDrawColor( borderColor );
		this.setGunsColor( color, borderColor );
	}
	
	public void setGunsColor( Color color, Color borderColor ) {
		GunShape[] gshapes = this.getGunShapes();
		for( GunShape gs : gshapes ) {
			((GunShape2D)gs).getColorizer2D().setFaceFillColor( color );
			((GunShape2D)gs).getColorizer2D().setFaceDrawColor( borderColor );
		}
	}
	
	public float getPXWidth() {
		return pxWidth;
	}
	
	public float getPXHeight() {
		return pxHeight;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public float getDimension() {
		return dimension;
	}

}

