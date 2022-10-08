package batalhaestrelar.shape.bonus;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;

import java.awt.Color;

public class EBonusShape2D extends BonusShape2D {

	private GeomColorizer2D colorizer = new GeomColorizer2D();

	public EBonusShape2D() {
		super();
	}
	
	public void buildBonus(Geom2DBuilder gb) {
		float l = super.getWidth() / DIMENSION;
		float a = super.getHeight() / DIMENSION;
		
		float[][] verts2 = {
			{ -4 * l,  5 * a },	
			{  4 * l,  5 * a },	
			{  4 * l,  3 * a },	
			{ -2 * l,  3 * a },
			{ -2 * l,  1 * a },	
			{  3 * l,  1 * a },	
			{  3 * l, -1 * a },	
			{ -2 * l, -1 * a },	
			{ -2 * l, -3 * a },	
			{  4 * l, -3 * a },	
			{  4 * l, -5 * a },	
			{ -4 * l, -5 * a }		
		};
		Geom2D polyg2 = gb.buildPolygonGeom( verts2 );
		gb.addGeomToStruct( super.getInitStruct2D(), polyg2, colorizer );
		
		borderColorizer.setFaceDrawColor( Color.GREEN );
		borderColorizer.setFaceFillColor( Color.DARK_GRAY );
		
		colorizer.setFaceFillColor( Color.GREEN );
		colorizer.setFaceDrawColor( Color.GREEN );
	}

}
