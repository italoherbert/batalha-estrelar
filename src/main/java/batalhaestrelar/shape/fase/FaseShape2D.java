package batalhaestrelar.shape.fase;

import italo.g2dlib.g2d.norm.Normalizer;
import italo.g2dlib.g2d.shape.Screen;
import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;
import italo.g2dlib.g2d.shape.geom.GeomVisibility2D;

import java.awt.Color;

import batalhaestrelar.kernel.fase.FaseConfig;
import batalhaestrelar.kernel.fase.FaseShape;
import batalhaestrelar.shape.AbstractS2D;


public class FaseShape2D extends AbstractS2D implements FaseShape {
	
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	
	private float width;
	private float height;
	private float cellWidth;
	private float cellHeight;
	
	private float starWidth;
	private float starHeight;
	private int starQuantity;
	private int cellQuantity;	
		
	public void initialize( FaseConfig faseConfig ) {
		super.initialize();
		
		this.starWidth  = faseConfig.getStarWidth();
		this.starHeight = faseConfig.getStarHeight();
		this.starQuantity = faseConfig.getStarQuantity();
		this.cellQuantity = faseConfig.getCellQuantity();
	}
	
	@Override
	public void buildShape( Geom2DBuilder gb ) {		
		Normalizer norm = super.getG2DUtilities().getNormalizer();
		Screen screen = super.getG2DUtilities().getScreen();
		
		cellWidth = norm.normal( screen.getWidth() );
		cellHeight = norm.normal( screen.getHeight() );								
				
		width = cellWidth;
		height = cellQuantity * cellHeight;
		
		x1 = - cellWidth *.5f;
		y1 = - cellHeight*.5f;
		x2 =   cellWidth*.5f;
		y2 = - cellHeight*.5f + height;	
                		
		Geom2D rectG = gb.buildRectGeom( x1, y1, x2, y2 );
		gb.addGeomToStruct( super.getInitStruct2D(), rectG );
		
		GeomColorizer2D colorizer = new GeomColorizer2D( Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE );		
		GeomVisibility2D visibility = new GeomVisibility2D( false, false, false, true );
				
		for( int i = 0; i < starQuantity; i++ ) {
			float x = x1 + (float)( Math.random() * width );
			float y = y1 + (float)( Math.random() * height );	
						
			Geom2D star = gb.buildLosangGeom( x-starWidth*.5f, y-starHeight*.5f, x+starWidth, y+starHeight );
			gb.addGeomToStruct( super.getInitStruct2D(), star, colorizer, visibility );
		}		
		
		super.getColorizer2D().setFaceFillColor( Color.BLACK );
		super.getVisibility2D().setDrawFace( false );
		super.setVertexesVisible( false );
		super.setEdgesVisible( false );
		super.setFacesVisible( true );
	}	
		
	public float getCellWidth() {
		return cellWidth;
	}

	public float getCellHeight() {
		return cellHeight;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getX1() {
		return x1;
	}

	public float getY1() {
		return y1;
	}

	public float getX2() {
		return x2;
	}

	public float getY2() {
		return y2;
	}

}

