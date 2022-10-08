package italo.g2dlib.g2d.painter;

import italo.g2dlib.g2d.shape.PainterShape2DListener;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

public interface PainterShape2D {

	public PainterShape2DListener getPainterShape2DListener();
	
	public void beforePaint( Graph2D g2D, Graph graph, Proj2D proj);
	
	public void afterPaint( Graph2D g2D, Graph graph, Proj2D proj);
		
}
