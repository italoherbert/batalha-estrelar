package batalhaestrelar.config.impl.gun.shot;

import batalhaestrelar.kernel.gun.ShotConfig;

public class LongSleepShotCFG implements ShotConfig {

	private int quantityBySequence = 1;
	private int shotInterval = 1;
	private int stopInterval = 1;

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
