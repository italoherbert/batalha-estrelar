package batalhaestrelar.shape.gun;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;

public class RectGunShape2D extends GunShape2D {
		
	private boolean positionYInCenter = false;
	
	public RectGunShape2D( NaveS2DSource source, boolean positionYInCenter ) {
		super( source );
		this.positionYInCenter = positionYInCenter;
	}

	public void buildShape( Geom2DBuilder gb ) {
		float l = source.getPXWidth();
		float a = source.getPXHeight();
				
		super.gunWidth = l;
		super.radial = ( positionYInCenter ? a*.5f : a );
		
		float x1 = -l*.5f;
		float y1 = ( positionYInCenter ? -a*.5f : 0 );
		float x2 =  l*.5f;		
		float y2 = ( positionYInCenter ?  a*.5f : a );
		
		Geom2D polyg = gb.buildRectGeom( x1, y1, x2, y2 ); 
		gb.addGeomToStruct( super.getInitStruct2D(), polyg );			
	}

}
