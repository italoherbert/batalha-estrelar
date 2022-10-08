package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.ITCounter;

public class NaveSession {

	private ITCounter stateCounter = new ITCounter();
	private ITCounter distributeGunsAngleCounter = new ITCounter();
	
	public ITCounter getStateCounter() {
		return stateCounter;
	}

	public ITCounter getDistributeGunsAngleCounter() {
		return distributeGunsAngleCounter;
	}	
	
}
