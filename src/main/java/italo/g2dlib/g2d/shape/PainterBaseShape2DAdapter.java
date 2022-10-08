package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.painter.Proj2D;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

public abstract class PainterBaseShape2DAdapter extends PainterShape2DAdapter implements PainterBaseShape2DListener {

	public void beforeChildsPaint( BaseShape2D shape, Graph2D g2d, Graph graph,	Proj2D proj ) {}

}
