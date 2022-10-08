package batalhaestrelar.shape.nave.child;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

import batalhaestrelar.kernel.gun.GunShape;
import batalhaestrelar.kernel.nave.NaveShapeDriver;
import batalhaestrelar.shape.gun.GunShapesBuilder;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class ChildStateNaveShape2D extends StateNaveShape2D {

	private final Color GUNSHOT_COLOR = Color.ORANGE;		
	private final float GUN_DIRECTION_ANGLE = (float)(Math.PI * 1.5f); 
			
	private GeomColorizer2D bottomBaseColorizer = new GeomColorizer2D();  
	private GeomColorizer2D topBaseColorizer = new GeomColorizer2D();  	
	
	private GunShapesBuilder gsbuilder;
	
	public ChildStateNaveShape2D( GunShapesBuilder gsbuilder, int gunQuantity ) {
		super( gunQuantity );
		this.gsbuilder = gsbuilder;
	}
			
	public void initializeAndBuildGuns( NaveShapeDriver driver ) {
		gsbuilder.build( this, gunShapes, driver.getGunRotations() );
	}
	
	public void buildShape( Geom2DBuilder gb ) {		
		int nsides = 16;
		float r = Math.min( super.getWidth(), super.getHeight() )*.5f;
		float r2 = r * .7f;		
						
		Geom2D bottomBasePolyg = gb.buildRegularPolygonGeom( 0, 0, r, nsides );   
		gb.addGeomToStruct( super.getInitStruct2D(), bottomBasePolyg, bottomBaseColorizer );
							
		Geom2D topBasePolyg = gb.buildRegularPolygonGeom( 0, 0, r2, nsides );  
		gb.addGeomToStruct( super.getInitStruct2D(), topBasePolyg, topBaseColorizer );
	}		
		
	public void setNaveColorAll(Color color, Color borderColor) {
		this.setBottomBaseColor( color, borderColor );
		this.setTopBaseColor( color, borderColor );
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
