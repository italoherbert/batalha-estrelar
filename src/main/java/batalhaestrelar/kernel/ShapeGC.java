package batalhaestrelar.kernel;


public interface ShapeGC extends GComponent {

	public GCShape getShape();
	
	public float getX();
	
	public float getY();
	
	public float getAbsX();
	
	public float getAbsY();
	
	public float getCamX();
	
	public float getCamY();
	
	public void setX( float x );
	
	public void setY( float y );
	
}
