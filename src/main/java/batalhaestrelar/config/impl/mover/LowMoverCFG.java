package batalhaestrelar.config.impl.mover;

import batalhaestrelar.kernel.MoverConfig;

public class LowMoverCFG implements MoverConfig {

	private int interval = 1;
	private float increment = 0.01f;
	
	public int getInterval() {
		return interval;
	}

	public float getIncrement() {
		return increment;
	}

}
