package batalhaestrelar.shape.nave.mother.s3;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.shape.gun.BigGunShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class S3MotherStateNaveShape2D extends StateNaveShape2D {

	private final Color GUNSHOT_COLOR = Color.RED;
	
	private final float GUN_DIRECTION_ANGLE = (float)(Math.PI * 1.5f); 
		
	private GeomColorizer2D baseColorizer = new GeomColorizer2D();  
	private GeomColorizer2D gunsBaseColorizer = new GeomColorizer2D();  
	
	public S3MotherStateNaveShape2D( int gunQuantity ) {		
		super( gunQuantity );
	}
			
	public void initializeAndBuildGuns( NaveShapeDriver driver ) {
		float l = super.getPXWidth();
		float a = super.getPXHeight();
		
		for( int i = 0; i < gunShapes.length; i++ ) {
			GunRotation gr = driver.getGunRotations()[ i ];
			
			gunShapes[i] = new BigGunShape2D( this, 6 );
			gunShapes[i].initialize( gr );
			gunShapes[i].getInitScale().setX( 2.0f );
			gunShapes[i].getInitScale().setY( 2.0f );
			super.addShape( gunShapes[i] );
		}
		
		gunShapes[0].setX( -6.0f * l );  		
		gunShapes[0].setY( -6.0f * a );  		
		gunShapes[1].setX(  6.0f * l );  		
		gunShapes[1].setY( -6.0f * a ); 
		
		gunShapes[2].setX( -6.0f * l );  		
		gunShapes[2].setY(  6.0f * a );  		
		gunShapes[3].setX(  6.0f * l );  		
		gunShapes[3].setY(  6.0f * a );
		
		((BigGunShape2D)gunShapes[0]).setGunWidthFactor( 2.0f );
		((BigGunShape2D)gunShapes[1]).setGunWidthFactor( 2.0f );
		((BigGunShape2D)gunShapes[2]).setGunWidthFactor( 3.0f );
		((BigGunShape2D)gunShapes[3]).setGunWidthFactor( 3.0f );
		((BigGunShape2D)gunShapes[4]).setGunWidthFactor( 4.0f );
	}

	public void buildShape( Geom2DBuilder gb ) {
		float l = super.getPXWidth();
		float a = super.getPXHeight();
				
		float r = 8 * a;				

		Geom2D basePolyg = gb.buildRegularPolygonGeom( 0, 0, r, 16 );  
		gb.addGeomToStruct( super.getInitStruct2D(), basePolyg, baseColorizer );				
		
		float[][] gunsBaseTop = {
			{ -8 * l,  4 * a },
			{  8 * l,  4 * a },
			{  8 * l,  8 * a },
			{ -8 * l,  8 * a }
		};		
		Geom2D gunsBaseTopPolyg = gb.buildPolygonGeom( gunsBaseTop ); 
		gb.addGeomToStruct( super.getInitStruct2D(), gunsBaseTopPolyg, gunsBaseColorizer );
		
		float[][] gunsBaseBottom = {
			{ -8 * l,  -4 * a },
			{  8 * l,  -4 * a },
			{  8 * l,  -8 * a },
			{ -8 * l,  -8 * a }
		};						
		Geom2D gunsBaseBottomPolyg = gb.buildPolygonGeom( gunsBaseBottom ); 
		gb.addGeomToStruct( super.getInitStruct2D(), gunsBaseBottomPolyg, gunsBaseColorizer );
	}
	
	public void setNaveColorAll( Color color, Color borderColor ) {
		this.setBaseColor( color, borderColor );
		this.setGunsBaseColor( color, borderColor );
	}

	public void setGunsBaseColor( Color color, Color borderColor ) {
		gunsBaseColorizer.setFaceFillColor( color );
		gunsBaseColorizer.setFaceDrawColor( borderColor );
	}
	
	public void setBaseColor( Color color, Color borderColor ) {
		baseColorizer.setFaceFillColor( color );
		baseColorizer.setFaceDrawColor( borderColor );
	}
	
	public GunShape[] getGunShapes() {
		return gunShapes;
	}
	
	public float getGunAngle() {
		return GUN_DIRECTION_ANGLE;
	}
	
	public Color getGunshotColor() {
		return GUNSHOT_COLOR;
	}	
	
}
