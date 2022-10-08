package batalhaestrelar.shape.gun;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;

public class BigGunShape2D extends GunShape2D {
	
	private final float GUN_ANGLE = (float)(Math.PI * 1.5f);
	private float gunWidthFactor = 2.6f;
	private float radialFactor = 7.0f; 
	
	public BigGunShape2D( NaveS2DSource source, float radialFactor ) {
		super( source );
		this.radialFactor = radialFactor;
	}

	protected float getSWGunFactor() {
		return 1.0f;
	}
	
	protected float getSHRGunFactor() {
		return 9.0f / radialFactor;
	}
	
	protected float getGunWidthFactor() {
		return gunWidthFactor;
	}
	
	public void buildShape( Geom2DBuilder gb ) {
		float l = source.getPXWidth();
		float a = source.getPXHeight();
				
		super.radial = radialFactor * a;		
		super.gunWidth  = this.getGunWidthFactor() * l ;
		
		float gw2 = super.gunWidth*.5f;
		
		float[][] vertsCenterGun = {
			{ -1 * l,   2 * a },
			{  1 * l,   2 * a },
			{  2 * l,   1 * a },
			{  2 * l,  -1 * a },
			{  1 * l,  -2 * a },
			{  gw2  ,  -radialFactor * a },
			{ -gw2  ,  -radialFactor * a },
			{ -1 * l,  -2 * a },
			{ -2 * l,  -1 * a },
			{ -2 * l,   1 * a }
		};		
		Geom2D polygCenterGun = gb.buildPolygonGeom( vertsCenterGun ); 
		gb.addGeomToStruct( super.getInitStruct2D(), polygCenterGun );			
	}	

	public float getAngle() {
		return GUN_ANGLE; 
	}
	
	public void setGunWidthFactor( float factor ) {
		this.gunWidthFactor = factor;
	}

}

