package batalhaestrelar.kernel;

import italo.control.Control;
import italo.control.ControlTO;


public abstract class AbstractShapeControl<T extends ControlTO> implements Control<T> { 

	public abstract void initSCtrl( T to );
	
	public abstract void buildSCtrl( T to );
	
	public abstract ShapeGC getShapeGC();
	
	public void build( T to ) {
		this.buildSCtrl( to );
	}

	public void init( T to ) {
		this.getShapeGC().setX( 0 );
		this.getShapeGC().setY( 0 );
		this.initSCtrl( to );
	}

}
