package batalhaestrelar.modules.nave.shot;

public interface ShotTO {
	
	public boolean isToShot();

	public void toShotState();
	
	public void toStopState();
		
	public void resetShotIntervalCount();

	public void incGSCount();
	
	public int getGSCount();
	
	public void incShotIntervalCount();
	
	public int getShotIntervalCount();
	
	public void incStopIntervalCount();

	public int getStopIntervalCount();

	public int getQuantityBySequence();
	
	public int getShotInterval();

	public int getStopInterval();
		
}
