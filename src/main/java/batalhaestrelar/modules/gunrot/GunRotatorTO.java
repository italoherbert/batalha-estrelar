package batalhaestrelar.modules.gunrot;

public interface GunRotatorTO {
		
	public float getAngle();
	
	public float getAngleLimit();
	
	public float getAngleIncrement();
	
	public int getInterval();

	public int getRandomDirectionInterval();

	public boolean isCycle();
	
	public boolean isExecIfShoting();
	
	public void setAngle( float angle );
	
	public void setAngleIncrement( float inc );		
	
}
