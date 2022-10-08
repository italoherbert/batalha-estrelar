package italo.g2dlib.g2d.transform;

import italo.g2dlib.g2d.vector.Vector2D;

public class Rotator2D implements Transformer2D {

	@Override
	public void transform( Vector2D gt, Vector2D vertex ) {
		this.rotate( gt, vertex );
	}
	
	public void rotate( Vector2D gt, Vector2D vertex ) {
		double angle = Math.atan2( vertex.getY(), vertex.getX() );
		double r = Math.sqrt( ( vertex.getX()*vertex.getX() ) + ( vertex.getY()*vertex.getY() ) );
		
		vertex.setX( (float)( r * Math.cos( angle + gt.getX() ) ) );
		vertex.setY( (float)( r * Math.sin( angle + gt.getY() ) ) ); 	
	}
	
	public void rotate( float[] p, float angle ) {
		this.rotate( p, p[0], p[1], angle );
	}	
	
	public float[] rotate( float x, float y, float angle ) {
		float[] newV = new float[2];
		this.rotate( newV, x, y, angle );
		return newV;
	}
	
	public void rotate( float[] newV, float x, float y, float angle ) {
		double rotAngle = Math.atan2( y, x );
		double r = Math.sqrt( ( x*x ) + ( y*y ) );
		
		newV[ 0 ] = (float)( r * Math.cos( rotAngle + angle ) );
		newV[ 1 ] = (float)( r * Math.sin( rotAngle + angle ) );
	}

}
