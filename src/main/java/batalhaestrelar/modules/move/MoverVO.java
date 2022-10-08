package batalhaestrelar.modules.move;

public class MoverVO implements MoverTO {

	private int interval;
	private float inc;

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public float getInc() {
		return inc;
	}

	public void setIncrement(float inc) {
		this.inc = inc;
	}

}
