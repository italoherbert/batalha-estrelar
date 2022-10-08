package batalhaestrelar.shape.nave.player;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.shape.gun.RectGunShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class PlayerStateNaveShape2D extends StateNaveShape2D {

	private final Color GUNSHOT_COLOR = Color.BLUE;
	
	private final float GUN_ANGLE = (float)(Math.PI *.5f);
	private final float GUN_Y = 3.0f;
		
	private GeomColorizer2D topColorizer = new GeomColorizer2D();  
	private GeomColorizer2D bottomBaseColorizer = new GeomColorizer2D();  
	private GeomColorizer2D topBaseColorizer = new GeomColorizer2D();  
	private GeomColorizer2D gunsBaseColorizer = new GeomColorizer2D();
			
	public PlayerStateNaveShape2D( int gunQuantity ) {
		super( gunQuantity );
	}
		
	public void initializeAndBuildGuns( NaveShapeDriver driver ) {
		for( int i = 0; i < gunShapes.length; i++ ) {
			gunShapes[i] = new RectGunShape2D( this, true );		
			gunShapes[i].initialize( driver.getGunRotations()[ i ] );
			gunShapes[i].getInitScale().setX( 1.0f );
			gunShapes[i].getInitScale().setY( 3.0f );
			super.addShape( gunShapes[i] );
		}

		float l = super.getPXWidth();
		float a = super.getPXHeight();		
		float gunsY = GUN_Y;
		
		gunShapes[0].setX( -4.5f * l );
		gunShapes[0].setY( gunsY * a );
		gunShapes[1].setX( -2.5f * l );
		gunShapes[1].setY( gunsY * a );
		gunShapes[2].setX(     0 * l );
		gunShapes[2].setY( gunsY * a );		
		gunShapes[3].setX(  2.5f * l );
		gunShapes[3].setY( gunsY * a );
		gunShapes[4].setX(  4.5f * l );
		gunShapes[4].setY( gunsY * a );	
	}

	public void buildShape( Geom2DBuilder gb ) {			
		float l = super.getPXWidth();
		float a = super.getPXHeight();						
		float gunsY = GUN_Y;		
				
		float[][] gunsBase = {
			{ -4 * l,  (gunsY+0.5f) * a },
			{  4 * l,  (gunsY+0.5f) * a },
			{  4 * l,  (gunsY-0.5f) * a },
			{ -4 * l,  (gunsY-0.5f) * a }
		};		
		Geom2D gunsBasePolyg = gb.buildPolygonGeom( gunsBase ); 
		gb.addGeomToStruct( super.getInitStruct2D(), gunsBasePolyg, gunsBaseColorizer );
			
		float[][] bottomBase = {
			{  0    ,  8 * a },
			{ -8 * l, -6 * a },
			{  0    , -2 * a },
			{  8 * l, -6 * a }
		};		
		Geom2D bottomBasePolyg = gb.buildPolygonGeom( bottomBase ); 
		gb.addGeomToStruct( super.getInitStruct2D(), bottomBasePolyg, bottomBaseColorizer );
		
		float[][] topBase = {
			{  0    ,  8 * a },
			{ -5 * l, -8 * a },
			{  0    , -4 * a },
			{  5 * l, -8 * a }
		};		
		Geom2D topBasePolyg = gb.buildPolygonGeom( topBase ); 
		gb.addGeomToStruct( super.getInitStruct2D(), topBasePolyg, topBaseColorizer );	
		
		float[][] top = {
			{  0    ,  6 * a },
			{ -2 * l, -2 * a },
			{  0    , -3 * a },
			{  2 * l, -2 * a }
		};		
		Geom2D topPolyg = gb.buildPolygonGeom( top ); 
		gb.addGeomToStruct( super.getInitStruct2D(), topPolyg, topColorizer );	
	}
			
	public void setNaveColorAll(Color color, Color borderColor) {
		this.setBottomBaseColor( color, borderColor );
		this.setTopBaseColor( color, borderColor );
		this.setTopColor( color, borderColor );
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
	
	public void setTopColor( Color color, Color borderColor ) {
		topColorizer.setFaceFillColor( color );
		topColorizer.setFaceDrawColor( borderColor );
	}
	
	public GunShape[] getGunShapes() {
		return gunShapes;
	}
		
	public float getGunAngle() {
		return GUN_ANGLE; 
	}
	
	public Color getGunshotColor() {
		return GUNSHOT_COLOR;
	}
	
}
