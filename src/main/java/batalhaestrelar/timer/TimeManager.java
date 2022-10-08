package batalhaestrelar.timer;

import italo.timer.Timer;
import batalhaestrelar.kernel.TimeKernel;

public class TimeManager implements TimeKernel {
	
	private Timer timer = new Timer( 30 );		
	private long preferredDelay = 30;	
	private long delay = 30;
	private int adjustFequenceMultiple = 100;
	private int adjustTimeElapsedLimit = 2;
	private int count = 0;	
	
	private long initialTime;
	private boolean firstAdjust = true;
	
	public void sleep( long ms ) {
		timer.sleep( ms );
	}

	public void faseExecutionSleep() {
		if( count % adjustFequenceMultiple == 1 ) {
			long elapsed = System.currentTimeMillis() - initialTime;
			if( ( firstAdjust && elapsed < preferredDelay ) || ( elapsed < adjustTimeElapsedLimit ) ) 		
				delay = preferredDelay - elapsed;			
			
			firstAdjust = false;
		}
		
		try {
			Thread.sleep( delay );
		} catch( InterruptedException e ) {
			
		}
		
		if( count % adjustFequenceMultiple == 0 ) {
			delay = preferredDelay;
			initialTime = System.currentTimeMillis();
		}
		count++;
	}

	public long getPreferredDelay() {
		return preferredDelay;
	}

	public void setPreferredDelay( long preferredDelay ) {
		this.preferredDelay = preferredDelay;
	}

	public Timer getTimer() {
		return timer;
	}	
	
}
