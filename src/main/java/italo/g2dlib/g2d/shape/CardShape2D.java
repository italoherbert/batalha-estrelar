package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardShape2D extends AbstractBaseShape2D implements BaseShape2D {

	private Map<Object, Shape2D> shapesMap = new HashMap<Object, Shape2D>();
	private List<Shape2D> currentShapeList = new ArrayList<Shape2D>( 1 );
	private Object currentKey;
	
	public CardShape2D() {
		currentShapeList.add( new ConcreteShape2D() );
	}
	
	public void buildShape( Geom2DBuilder gb ) {}
		
	public List<Shape2D> getChildsForPaint() {
		return currentShapeList;
	}
	
	public Shape2D getCurrentShape() {
		return currentShapeList.get( 0 ); 
	}	
		
	public void putShape( Object key, Shape2D shape ) {
		if( !super.getAllChilds().contains( shape ) )
			super.addChild( shape );
		shapesMap.put( key, shape );
	}
		
	public void setCurrentShape( Object key ) {
		this.currentKey = key;
		
		Shape2D shape = shapesMap.get( key );
		currentShapeList.set( 0, shape );
	}

	public Map<Object, Shape2D> getShapesMap() {
		return shapesMap;
	}

	public Object getCurrentKey() {
		return currentKey;
	}
		
}
