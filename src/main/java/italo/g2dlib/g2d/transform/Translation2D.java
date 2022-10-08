package italo.g2dlib.g2d.transform;

public class Translation2D extends Transform2D {

	public Translation2D() {
		this( 0, 0 );
	}
	
	public Translation2D( float x, float y ) {
		super.setX( x );
		super.setY( y );
	}

}
