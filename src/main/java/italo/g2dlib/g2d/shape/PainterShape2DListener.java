package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.painter.Proj2D;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

public interface PainterShape2DListener {

	public void beforePaint( Shape2D shape, Graph2D g2D, Graph g, Proj2D proj );
	
	public void afterPaint( Shape2D shape, Graph2D g2D, Graph g, Proj2D proj );
	
}
