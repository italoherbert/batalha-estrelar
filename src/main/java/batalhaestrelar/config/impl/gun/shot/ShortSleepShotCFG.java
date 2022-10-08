package batalhaestrelar.config.impl.gun.shot;

import batalhaestrelar.kernel.gun.ShotConfig;

public class ShortSleepShotCFG implements ShotConfig {

	private int quantityBySequence = 1;
	private int shotInterval = 1;
	private int stopInterval = 5;
	
	public int getQuantityBySequence() {
		return quantityBySequence;
	}

	public int getShotInterval() {
		return shotInterval;
	}

	public int getStopInterval() {
		return stopInterval;
	}

}

