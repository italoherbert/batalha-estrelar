package batalhaestrelar.shape.bonus;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

public class TBonusShape2D extends BonusShape2D {
	
	private GeomColorizer2D colorizer = new GeomColorizer2D();
	
	public TBonusShape2D() {
		super();
	}
	
	public void buildBonus( Geom2DBuilder gb ) {
		float l = super.getWidth() / DIMENSION;
		float a = super.getHeight() / DIMENSION;
		
		float[][] verts2 = {
			{ -5 * l,  5 * a },	
			{  5 * l,  5 * a },	
			{  5 * l,  3 * a },	
			{  1 * l,  3 * a },
			{  1 * l, -5 * a },	
			{ -1 * l, -5 * a },	
			{ -1 * l,  3 * a },	
			{ -5 * l,  3 * a }		
		};
		Geom2D polyg2 = gb.buildPolygonGeom( verts2 );
		gb.addGeomToStruct( super.getInitStruct2D(), polyg2, colorizer );
		
		borderColorizer.setFaceDrawColor( new Color( 100, 150, 255 ) );
		borderColorizer.setFaceFillColor( Color.DARK_GRAY );
		
		colorizer.setFaceFillColor( new Color( 100, 150, 255 ) );
		colorizer.setFaceDrawColor( new Color( 100, 150, 255 ) );
	}

}
