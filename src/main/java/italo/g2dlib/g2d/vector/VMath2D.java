package italo.g2dlib.g2d.vector;


public class VMath2D {

	public void add( Vector2D v1, Vector2D v2 ) {
		this.add( v1, v1, v2 );
	}
		
	public Vector2D addAndRet( Vector2D v1, Vector2D v2 ) {
		Vector2D v = new Vector2D();
		this.add( v, v1, v2 );
		return v;
	}		
	
	public void sub( Vector2D v1, Vector2D v2 ) {
		this.sub( v1, v1, v2 );
	}
	
	public Vector2D subAndRet( Vector2D v1, Vector2D v2 ) {
		Vector2D v = new Vector2D();
		this.sub( v, v1, v2 );
		return v;
	}
	
	public void mul( Vector2D v1, Vector2D v2 ) {
		this.mul( v1, v1, v2 );
	}
	
	public Vector2D mulAndRet( Vector2D v1, Vector2D v2 ) {
		Vector2D v = new Vector2D();
		this.mul( v, v1, v2 );
		return v;
	}
	
	public void div( Vector2D v1, Vector2D v2 ) {
		this.div( v1, v1, v2 );
	}
	
	public Vector2D divAndRet( Vector2D v1, Vector2D v2 ) {
		Vector2D v = new Vector2D();
		this.div( v, v1, v2 );
		return v;
	}
	
	public void add( Vector2D v, Vector2D v1, Vector2D v2 ) {
		v.setX( v1.getX() + v2.getX() );
		v.setY( v1.getY() + v2.getY() );		
	}
	
	public void sub( Vector2D v, Vector2D v1, Vector2D v2 ) {
		v.setX( v1.getX() - v2.getX() );
		v.setY( v1.getY() - v2.getY() );		
	}
	
	public void mul( Vector2D v, Vector2D v1, Vector2D v2 ) {
		v.setX( v1.getX() * v2.getX() );
		v.setY( v1.getY() * v2.getY() );		
	}
	
	public void div( Vector2D v, Vector2D v1, Vector2D v2 ) {
		v.setX( v1.getX() / v2.getX() );
		v.setY( v1.getY() / v2.getY() );		
	}
	
}
