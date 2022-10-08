package batalhaestrelar.kernel;


public interface TimeKernel {

	public void sleep( long ms );
	
	public void faseExecutionSleep();

	public long getPreferredDelay();
	
	public void setPreferredDelay( long delay );
	
}
