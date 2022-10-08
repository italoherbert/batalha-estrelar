package italo.g2dlib.g2d.transform;

public class Scale2D extends Transform2D {

	public Scale2D() {
		this( 1.0f, 1.0f );
	}
	
	public Scale2D( float x, float y ) {
		super.setX( x );
		super.setY( y );
	}
	
}
