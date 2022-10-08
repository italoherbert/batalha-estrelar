package italo.algorithm;


public class AlgorithmControl implements Runnable {
	
	private Algorithm algorithm;
	private AlgorithmListener listener = new AlgorithmAdapter() {};	
	private ITAlgorithmListener itAlgListener = new ITAlgorithmAdapter() {};
	private PauseListener pauseListener = new PauseAdapter() {};

	private boolean pauseFlag = false;
	private int pauseDelay = 30;	

	private boolean executing;	
	private boolean executed;
	
	public AlgorithmControl() {}
	
	public AlgorithmControl( Algorithm algorithm ) {
		this.algorithm = algorithm;
	}
	
	public AlgorithmControl( SimpleAlgorithm simpleAlg ) {
		this.setSimpleAlgorithm( simpleAlg );
	}
	
	public void run() {		
		listener.beforeExec();		
		algorithm.beforeExec();
		executing = true;
		
		while( algorithm.execCondition() ) {			
			while( pauseFlag ) {
				pauseListener.paused();
				try {
					Thread.sleep( pauseDelay );
				} catch( InterruptedException e ) {
					
				}				
			}
			itAlgListener.beforeITExec();				
			algorithm.execIT();							
			itAlgListener.afterITExec();
		}				
		
		executing = false;
		executed = true;
		algorithm.afterExec();
		listener.afterExec();		
	}
		
	public void pauseOrContinueExecution() {
		if( pauseFlag ) {
			this.continueExecution();
		} else {
			this.pauseExecution();
		}
	}
	
	public void pauseExecution() {
		pauseFlag = true;
		pauseListener.pauseStarted();
	}
	
	public void continueExecution() {
		pauseFlag = false;
		pauseListener.executionStarted();
	}
		
	public boolean isExecuting() {
		return executing;
	}

	public boolean isExecuted() {
		return executed;
	}

	public boolean isPause() {
		return pauseFlag;
	}

	public int getPauseDelay() {
		return pauseDelay;
	}

	public void setPauseDelay(int pauseDelay) {
		this.pauseDelay = pauseDelay;
	}

	public void setSimpleAlgorithm( SimpleAlgorithm simpleAlg ) {
		this.algorithm = new SimpleAlgorithmAdapter( simpleAlg );
	}
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm( Algorithm algorithm ) {
		this.algorithm = algorithm;
	}
	
	public void setAlgorithmListener( AlgorithmListener listener ) {
		this.listener = listener;
	}
	
	public void setITAlgorithmListener( ITAlgorithmListener listener ) {
		this.itAlgListener = listener;
	}
	
	public void setPauseListener( PauseListener listener ) {
		this.pauseListener = listener;
	}
	
}
