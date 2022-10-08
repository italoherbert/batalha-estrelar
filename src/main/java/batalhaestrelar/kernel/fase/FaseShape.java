package batalhaestrelar.kernel.fase;

import batalhaestrelar.kernel.GCShape;

public interface FaseShape extends GCShape {
		
	public void initialize( FaseConfig faseConfig );
	
	public float getCellWidth();

	public float getCellHeight();
	
	public float getX1();
	
	public float getY1();
	
	public float getX2();
	
	public float getY2();
				
}
