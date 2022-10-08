package batalhaestrelar.modules.gunrot;

import batalhaestrelar.kernel.gun.Gun;

public interface GunRotator {
	
	public final static int NONE = 0;
	public final static int RANDOM = 1;
	
	public void rotate( Gun gun, GunRotatorTO to ); 

}
