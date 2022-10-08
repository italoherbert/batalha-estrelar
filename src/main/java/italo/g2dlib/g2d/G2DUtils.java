package italo.g2dlib.g2d;

import italo.g2dlib.g2d.norm.Normalizer;
import italo.g2dlib.g2d.norm.NormalizerDriver;
import italo.g2dlib.g2d.painter.ShapePainter2D;
import italo.g2dlib.g2d.shape.BaseShape2D;
import italo.g2dlib.g2d.shape.Screen;
import italo.g2dlib.g2d.shape.Shape2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.transform.Transformer2DManager;
import italo.g2dlib.g2d.vector.VMath2D;

import java.util.Collection;

public class G2DUtils implements G2DUtilities, NormalizerDriver {

	private ShapePainter2D painter = new ShapePainter2D( this );
	private Normalizer normalizer = new Normalizer( this );
	
	private Geom2DBuilder gbuilder = new Geom2DBuilder();
	private Transformer2DManager transformer = new Transformer2DManager();	
	private VMath2D math = new VMath2D();
	
	private Screen screen;

	public G2DUtils( Screen screen ) {
		this.screen = screen;
	}
	
	public void recursiveSetG2DUtilities( Shape2D s ) {
		s.setG2DUtilities( this );
		if( s instanceof BaseShape2D ) {
			Collection<Shape2D> shapes = ((BaseShape2D)s).getAllChilds();
			for( Shape2D child : shapes )
				this.recursiveSetG2DUtilities( child );			
		}
	}
	
	public float screenHeight() {
		return screen.getHeight();
	}

	public Screen getScreen() {
		return screen;
	}

	public ShapePainter2D getPainter() {
		return painter;
	}

	public Normalizer getNormalizer() {
		return normalizer;
	}

	public VMath2D getVMath() {
		return math;
	}

	public Geom2DBuilder getGBuilder() {
		return gbuilder;
	}

	public Transformer2DManager getTransformer() {
		return transformer;
	}

}
