package batalhaestrelar.kernel.gun;

public interface GunRotatorConfig {

	public float getAngle();
	
	public float getAngleLimit();
	
	public float getAngleIncrement();
	
	public int getInterval();
	
	public int getRandomDirectionInterval();

	public boolean isCycle();
	
	public boolean isExecIfShoting();
		
}
