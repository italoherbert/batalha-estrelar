package batalhaestrelar.config.impl.mover;

import batalhaestrelar.kernel.nave.NaveMoverConfig;

public class QuickNaveMoverCFG implements NaveMoverConfig {

	private int interval = 1;
	private float increment = 0.03f;
	private boolean execIfShoting = true;
	
	public QuickNaveMoverCFG( boolean execIfShoting ) {
		this.execIfShoting = execIfShoting;
	}
	
	public int getInterval() {
		return interval;
	}

	public float getIncrement() {
		return increment;
	}

	public boolean isExecIFShoting() {
		return execIfShoting;
	}

}
