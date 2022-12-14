package italo.g2dlib.g2d.vector;

public class Vector2D {

	private float x;
	private float y;
	
	public Vector2D() {}
	
	public Vector2D( float x, float y ) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
