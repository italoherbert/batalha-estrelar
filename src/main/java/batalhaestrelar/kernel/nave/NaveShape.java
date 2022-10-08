package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.GCShape;
import batalhaestrelar.kernel.gun.GunShape;

public interface NaveShape extends GCShape, NaveConstants {
	
	public void initialize( NaveConfig config, NaveShapeDriver driver );
				
	public void configureByShapeType( int colorConfType );
		
	public int getGunQuantity();
	
	public GunShape[] getGunShapes();	
		
}
