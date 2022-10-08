package italo.g2dlib.g2d.transform;

public class Rotation2D extends Transform2D {	
	
	public Rotation2D() {
		this( 0 );
	}
	
	public Rotation2D( float angle ) {
		this.setAngle( angle );
	}
	
	public float getAngle() {
		return super.getX();
	}
	
	public void setAngle( float angle ) {
		super.setX( angle );
		super.setY( angle );
	}
	
}
