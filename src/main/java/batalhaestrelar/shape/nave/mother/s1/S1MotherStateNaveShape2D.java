package batalhaestrelar.shape.nave.mother.s1;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.shape.gun.BigGunShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class S1MotherStateNaveShape2D extends StateNaveShape2D {

	private final Color GUNSHOT_COLOR = Color.RED;		
	private final float GUN_DIRECTION_ANGLE = (float)(Math.PI * 1.5f); 
			
	private GeomColorizer2D bottomBaseColorizer = new GeomColorizer2D();  
	private GeomColorizer2D topBaseColorizer = new GeomColorizer2D();  
	private GeomColorizer2D gunsBaseColorizer = new GeomColorizer2D();  
	
	public S1MotherStateNaveShape2D( int gunQuantity ) {
		super( gunQuantity );
	}
			
	public void initializeAndBuildGuns(NaveShapeDriver driver ) {
		gunShapes[0] = new BigGunShape2D( this, 5 ); 
		gunShapes[1] = new BigGunShape2D( this, 5 ); 
		gunShapes[2] = new BigGunShape2D( this, 7 );
	
		gunShapes[0].getInitScale().setX( .5f ); 
		gunShapes[0].getInitScale().setY( .5f ); 
		
		gunShapes[1].getInitScale().setX( .5f ); 
		gunShapes[1].getInitScale().setY( .5f ); 
		
		for( int i = 0; i < gunShapes.length; i++ ) {
			gunShapes[i].initialize( driver.getGunRotations()[ i ] );
			super.addShape( gunShapes[i] );
		}
		
		float l = super.getPXWidth();
		float a = super.getPXHeight();
		
		gunShapes[0].setX( -6.5f * l );  		
		gunShapes[0].setY( -4.0f * a );  		
		gunShapes[1].setX(  6.5f * l );  		
		gunShapes[1].setY( -4.0f * a ); 
	}

	public void buildShape( Geom2DBuilder gb ) {
		float l = super.getPXWidth();
		float a = super.getPXHeight();
						
		float[][] gunsBase = {
			{ -8 * l,  -3 * a },
			{  8 * l,  -3 * a },
			{  8 * l,  -5 * a },
			{ -8 * l,  -5 * a }
		};		
		Geom2D gunsBasePolyg = gb.buildPolygonGeom( gunsBase ); 
		gb.addGeomToStruct( super.getInitStruct2D(), gunsBasePolyg, gunsBaseColorizer );
		
		float[][] bottomBase = {
			{ -6 * l,  8 * a },
			{  6 * l,  8 * a },
			{  8 * l,  6 * a },
			{  8 * l,  2 * a },
			{  6 * l,  0	 },
			{  5 * l, -5 * a },
			{  2 * l, -8 * a },
			{ -2 * l, -8 * a },
			{ -5 * l, -5 * a },
			{ -6 * l, 0 },
			{ -8 * l, 2 * a },
			{ -8 * l, 6 * a }
		};		
		Geom2D bottomBasePolyg = gb.buildPolygonGeom( bottomBase ); 
		gb.addGeomToStruct( super.getInitStruct2D(), bottomBasePolyg, bottomBaseColorizer );
		
		float[][] topBase = {
			{ -3 * l,  4 * a },
			{  3 * l,  4 * a },
			{  5 * l,  2 * a },
			{  3 * l, -4 * a },
			{  1 * l, -6 * a },
			{ -1 * l, -6 * a },
			{ -3 * l, -4 * a },
			{ -5 * l,  2 * a }
		};
		
		Geom2D topBasePolyg = gb.buildPolygonGeom( topBase ); 
		gb.addGeomToStruct( super.getInitStruct2D(), topBasePolyg, topBaseColorizer );	
	}
	
	public void setNaveColorAll(Color color, Color borderColor) {
		this.setBottomBaseColor( color, borderColor );
		this.setTopBaseColor( color, borderColor );
		this.setGunsBaseColor( color, borderColor );
	}

	public void setGunsBaseColor( Color color, Color borderColor ) {
		gunsBaseColorizer.setFaceFillColor( color );
		gunsBaseColorizer.setFaceDrawColor( borderColor );
	}
	
	public void setBottomBaseColor( Color color, Color borderColor ) {
		bottomBaseColorizer.setFaceFillColor( color );
		bottomBaseColorizer.setFaceDrawColor( borderColor );
	}
	
	public void setTopBaseColor( Color color, Color borderColor ) {
		topBaseColorizer.setFaceFillColor( color );
		topBaseColorizer.setFaceDrawColor( borderColor );
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
