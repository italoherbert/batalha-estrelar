package batalhaestrelar.modules.gunrot;

public class GunRotatorVO implements GunRotatorTO {

	private float angle;
	private float angleLimit;
	private float angleIncrement;
	private int interval;
	private int randomDirectionInterval;
	private boolean isCycle;
	private boolean execIfShoting;

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public float getAngleLimit() {
		return angleLimit;
	}

	public void setAngleLimit(float angleLimit) {
		this.angleLimit = angleLimit;
	}

	public float getAngleIncrement() {
		return angleIncrement;
	}

	public void setAngleIncrement(float angleIncrement) {
		this.angleIncrement = angleIncrement;
	}

	public int getRandomDirectionInterval() {
		return randomDirectionInterval;
	}

	public void setRandomDirectionInterval(int randomDirectionInterval) {
		this.randomDirectionInterval = randomDirectionInterval;
	}

	public boolean isCycle() {
		return isCycle;
	}

	public void setCycle(boolean isCycle) {
		this.isCycle = isCycle;
	}

	public boolean isExecIfShoting() {
		return execIfShoting;
	}

	public void setExecIfShoting(boolean execIfShoting) {
		this.execIfShoting = execIfShoting;
	}

}
