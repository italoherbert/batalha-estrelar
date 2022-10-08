package italo.g2dlib.g2d.shape;

import java.util.List;

public abstract class AbstractGroupShape2D extends AbstractBaseShape2D implements GroupShape2D {
		
	public void addShape( Shape2D shape ) {
		super.addChild( shape );
	}

	public List<Shape2D> getChildsForPaint() {
		return super.getAllChilds();
	}
	
}
