package batalhaestrelar.shape.bonus;

import italo.g2dlib.g2d.shape.geom.Geom2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;
import batalhaestrelar.kernel.bonus.BonusShape;
import batalhaestrelar.kernel.bonus.BonusShapeDriver;
import batalhaestrelar.kernel.game.GameConfig;
import batalhaestrelar.shape.AbstractS2D;

public abstract class BonusShape2D extends AbstractS2D implements BonusShape {

	protected final int DIMENSION = 16;
	
	protected GeomColorizer2D borderColorizer = new GeomColorizer2D();

	private float width;
	private float height;
	private BonusShapeDriver driver;
	
	public BonusShape2D() {
		super(); 
	}
	
	public abstract void buildBonus( Geom2DBuilder gb );
	
	public void initialize( GameConfig config, BonusShapeDriver driver ) {
		width = config.getBonusWidth();
		height = config.getBonusHeight();
		this.driver = driver;
	}
	
	public void buildShape(Geom2DBuilder gb) {
		float l = width / DIMENSION;
		float a = height / DIMENSION;
		
		float[][] verts1 = {
			{ -8 * l, -8 * a },	
			{  8 * l, -8 * a },	
			{  8 * l,  8 * a },	
			{ -8 * l,  8 * a },	
		};
		Geom2D polyg1 = gb.buildPolygonGeom( verts1 );
		gb.addGeomToStruct( super.getInitStruct2D(), polyg1, borderColorizer );
		
		float[][] verts2 = {
			{ -6 * l, -6 * a },	
			{  6 * l, -6 * a },	
			{  6 * l,  6 * a },	
			{ -6 * l,  6 * a },	
		};
		Geom2D polyg2 = gb.buildPolygonGeom( verts2 );
		gb.addGeomToStruct( super.getInitStruct2D(), polyg2, borderColorizer );
		
		this.buildBonus( gb );
	}
	
	public boolean activeCondition() {
		return driver.isActive();
	}
	
	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
