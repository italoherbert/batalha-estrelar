package batalhaestrelar.kernel.gun;

public interface GunConfig {
	
	public float getGunshotPosFactor();

	public float getGunshotPosIncFactor();

	public float getGunshotWidthFactor();
	
	public float getGunshotRadialFactor();
	
	public float getGunshotDistFactor();
			
	public boolean isRepeat();
				
	public int getGraphType();		
		
}
