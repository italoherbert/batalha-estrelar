package batalhaestrelar.shape.gun;

import italo.g2dlib.g2d.transform.Rotation2D;
import italo.g2dlib.g2d.transform.Scale2D;
import italo.g2dlib.g2d.transform.Translation2D;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.shape.AbstractS2D;

public abstract class GunShape2D extends AbstractS2D implements GunShape {

	private GunRotation2DAdapter rotation = new GunRotation2DAdapter();
	
	private Translation2D initTranslation = new Translation2D();
	private Rotation2D initRotation = new Rotation2D();
	private Scale2D initScale = new Scale2D();

	protected float radial;
	protected float gunWidth;
		
	protected GunRotation gunRotation;
	protected NaveS2DSource source;	
		
	public GunShape2D( NaveS2DSource source ) {
		super();
		super.addInitTransform( initTranslation );
		super.addInitTransform( initScale );
		super.addInitTransform( initRotation );
		
		super.addViewTransform( rotation );
		
		this.source = source;		
	}

	protected float getSHRGunFactor() { return 1.0f; };
	protected float getSWGunFactor() { return 1.0f; };
	
	public void initialize( GunRotation grot ) {
		super.initialize();
		rotation.setGunRotation( grot );
	}
	
	public Color getGunshotColor() {
		return source.getGunshotColor();
	}

	public float getAngle() {
		return source.getGunAngle();
	}

	public float getRadial() {
		return radial * initScale.getY();
	}

	public float getGunWidth() {
		return gunWidth * initScale.getX();
	}

	public float getWidth() {
		return ( gunWidth * this.getSWGunFactor() ) + ( gunWidth * ( initScale.getX()-1 ) ); 
	}

	public float getHeight() {
		return ( radial * this.getSHRGunFactor() ) + ( radial * ( initScale.getY()-1 ) ); 
	}

	public Rotation2D getInitRotation() {
		return initRotation;
	}

	public Scale2D getInitScale() {
		return initScale;
	}

	public Translation2D getInitTranslation() {
		return initTranslation;
	}	
	
}
