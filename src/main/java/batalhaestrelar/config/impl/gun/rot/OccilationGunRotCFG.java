package batalhaestrelar.config.impl.gun.rot;

import batalhaestrelar.kernel.gun.GunRotatorConfig;


public class OccilationGunRotCFG implements GunRotatorConfig {

	private float angle = 0;
	private float angleLimit = (float)Math.toRadians( 60 ); 
	private float angleIncrement = (float)Math.toRadians( 5 ); 
	private int interval = 1;
	private int randomDirectionInterval = 120;
	private boolean isCycle = false;
	private boolean execIfShoting = true;

	public float getAngle() {
		return angle;
	}

	public float getAngleLimit() {
		return angleLimit;
	}

	public float getAngleIncrement() {
		return angleIncrement;
	}

	public int getInterval() {
		return interval;
	}

	public int getRandomDirectionInterval() {
		return randomDirectionInterval;
	}

	public boolean isCycle() {
		return isCycle;
	}

	public boolean isExecIfShoting() {
		return execIfShoting;
	}
	
}
