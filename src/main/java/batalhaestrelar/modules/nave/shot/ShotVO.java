package batalhaestrelar.modules.nave.shot;

public class ShotVO implements ShotTO {
	
	private int quantityBySequence;
	private int shotInterval;
	private int stopInterval;
	
	private int gunshotCount; 
	private int shotIntervalCount;
	private int stopIntervalCount;	

	private boolean toShotFlag = true;		
	
	public boolean isToShot() {
		return toShotFlag;
	}
	
	public void toShotState() {
		gunshotCount = 0;
		shotIntervalCount = 0;
		stopIntervalCount = 0;
		toShotFlag = true;
	}

	public void toStopState() {
		stopIntervalCount = 0;;
		toShotFlag = false;
	}
	
	public void resetShotIntervalCount() {
		shotIntervalCount = 0;
	}
	
	public void incGSCount() {
		gunshotCount++;
	}
	
	public int getGSCount() {
		return gunshotCount;
	}
	
	public void incShotIntervalCount() {
		shotIntervalCount++;
	}
	
	public int getShotIntervalCount() {
		return shotIntervalCount;
	}
	
	public void incStopIntervalCount() {
		stopIntervalCount++;
	}
	
	public int getStopIntervalCount() {
		return stopIntervalCount;
	}
	
	public int getQuantityBySequence() {
		return quantityBySequence;
	}

	public void setQuantityBySequence(int quantityBySequence) {
		this.quantityBySequence = quantityBySequence;
	}

	public int getStopInterval() {
		return stopInterval;
	}

	public void setStopInterval(int stopInterval) {
		this.stopInterval = stopInterval;
	}

	public int getShotInterval() {
		return shotInterval;
	}

	public void setShotInterval(int gunshotInterval) {
		this.shotInterval = gunshotInterval;
	}

}
