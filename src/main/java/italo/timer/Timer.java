package italo.timer;

public class Timer {
	
	private long delay;		
	private TimerListener listener = new TimerAdapter() {};
	
	public Timer( long delay ) {
		this.delay = delay;
	}

	public void sleep( long ms ) {
		int time = 0;
		while( time < ms ) {
			listener.sleeping( time );
			try {
				Thread.sleep( delay );
			} catch( InterruptedException e ) {
				
			}
			time += delay;
		}
	}
	
	public void setTimerListener( TimerListener listener ) {
		this.listener = listener;
	}
	
	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}
	
}
