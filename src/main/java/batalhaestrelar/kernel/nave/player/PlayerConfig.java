package batalhaestrelar.kernel.nave.player;

import batalhaestrelar.kernel.nave.NaveConfig;

public interface PlayerConfig extends NaveConfig {

	public float getBonusDistributeAngle();

	public int getBonusEnergyIncrement();
	
	public int getDistributeAngleInterval();
	
	public int getEnergyIncInterval();

	public int getExpandShotInterval();
	
}
