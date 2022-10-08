package batalhaestrelar.kernel.nave.computer;

import batalhaestrelar.kernel.gun.GunRotatorConfig;
import batalhaestrelar.kernel.gun.ShotConfig;
import batalhaestrelar.kernel.nave.NaveConfig;
import batalhaestrelar.kernel.nave.NaveMoverConfig;

public interface ComputerConfig extends NaveConfig {
			
	public int getType();
	
	public int getQuantity();
	
	public int[] getTranslationIndexes();
	
	public float[][] getTranslationValues();
	
	public boolean isShotOnlyIfSelected();

	public int getGroupPositionatorType();
	
	public int getSinglePositionatorType();
	
	public int getSinglePosCellNumber();
	
	public int getMoverType();

	public int getShotType();
				
	public int getGunRotatorType();
	
	public NaveMoverConfig getMoverConfig();

	public GunRotatorConfig getGunRotatorConfig();
	
	public ShotConfig getShotConfig();
	
}
