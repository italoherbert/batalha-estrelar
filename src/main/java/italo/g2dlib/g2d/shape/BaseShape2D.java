package italo.g2dlib.g2d.shape;

import java.util.Collection;

public interface BaseShape2D extends Shape2D {

	public Collection<Shape2D> getAllChilds();
	
	public Collection<Shape2D> getChildsForPaint();
	
	public void setPainterShape2DListener( PainterBaseShape2DListener listener );

}
