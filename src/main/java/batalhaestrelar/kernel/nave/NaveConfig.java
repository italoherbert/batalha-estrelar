package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.gun.GunConfig;


public interface NaveConfig {		

	public int getStyle();
	
	public int getColorStyle();

	public int getEnergy();
				
	public float getWidth();
	
	public float getHeight();	
		
	public int getShotedInterval();
	
	public int getDestroyedInterval();		

	public GunConfig getGunConfig();	

}
