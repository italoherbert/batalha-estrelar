package batalhaestrelar.modules.nave.gunrot;

import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.modules.gunrot.GunRotatorTO;

public interface NaveGunRotator {
	
	public final static int NONE = 0;
	public final static int RANDOM = 1;
	
	public void rotate( Nave nave, GunRotatorTO to ); 

}
