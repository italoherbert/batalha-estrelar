package batalhaestrelar.shape;

import italo.g2dlib.g2d.shape.AbstractGroupShape2D;
import italo.g2dlib.g2d.transform.Translation2D;

public abstract class AbstractS2D extends AbstractGroupShape2D {

	private Translation2D translation = new Translation2D();
	
	public AbstractS2D() {
		super.getViewTransforms().add( translation );

		super.setVertexesVisible( false );
		super.setEdgesVisible( false );
		super.setFacesVisible( true );
	}	
		
	protected void initialize() {
		translation.setX( 0 );
		translation.setY( 0 );
	}
	
	public float getX() {
		return translation.getX();
	}

	public float getY() {
		return translation.getY();
	}

	public void setX( float x ) {
		translation.setX( x );
	}

	public void setY( float y ) {
		translation.setY( y );
	}
	
}
