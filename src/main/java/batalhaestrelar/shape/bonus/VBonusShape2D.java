package batalhaestrelar.shape.bonus;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

public class VBonusShape2D extends BonusShape2D {

	private GeomColorizer2D colorizer = new GeomColorizer2D();

	public VBonusShape2D() {
		super();
	}
	
	public void buildBonus(Geom2DBuilder gb) {
		float l = super.getWidth() / DIMENSION;
		float a = super.getHeight() / DIMENSION;
		
		float[][] verts2 = {
			{ -5 * l,  5 * a },	
			{ -3 * l,  5 * a },	
			{  0 * l, -3 * a },	
			{  3 * l,  5 * a },
			{  5 * l,  5 * a },	
			{  1.25f * l, -5 * a },	
			{ -1.25f * l, -5 * a }	
		};
		Geom2D polyg2 = gb.buildPolygonGeom( verts2 );
		gb.addGeomToStruct( super.getInitStruct2D(), polyg2, colorizer );

		borderColorizer.setFaceDrawColor( Color.GREEN );
		borderColorizer.setFaceFillColor( Color.DARK_GRAY );
		
		colorizer.setFaceFillColor( new Color( 50, 225, 50 ) );
		colorizer.setFaceDrawColor( new Color( 50, 225, 50 ) );
	}

}
