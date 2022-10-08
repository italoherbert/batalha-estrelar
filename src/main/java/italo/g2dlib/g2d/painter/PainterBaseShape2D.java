package italo.g2dlib.g2d.painter;

import italo.g2dlib.g2d.shape.PainterBaseShape2DListener;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

public interface PainterBaseShape2D {

	public PainterBaseShape2DListener getPainterBaseShape2DListener();

	public void beforeChildsPaint( Graph2D g2D, Graph graph, Proj2D proj );

}
