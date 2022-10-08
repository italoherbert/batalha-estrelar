package italo.g2dlib.g2d;

import italo.g2dlib.g2d.norm.Normalizer;
import italo.g2dlib.g2d.painter.ShapePainter2D;
import italo.g2dlib.g2d.shape.Screen;
import italo.g2dlib.g2d.shape.Shape2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.transform.Transformer2DManager;
import italo.g2dlib.g2d.vector.VMath2D;

public interface G2DUtilities {

	public void recursiveSetG2DUtilities( Shape2D shape );

	public Screen getScreen();
	
	public ShapePainter2D getPainter();
	
	public Normalizer getNormalizer();
	
	public VMath2D getVMath();
	
	public Geom2DBuilder getGBuilder();
	
	public Transformer2DManager getTransformer();
	
}
