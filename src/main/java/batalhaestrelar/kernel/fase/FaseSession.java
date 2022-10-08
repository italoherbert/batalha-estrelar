package batalhaestrelar.kernel.fase;

import batalhaestrelar.kernel.ITCounter;
import batalhaestrelar.kernel.nave.computer.Computer;



public class FaseSession {

	private ITCounter counter = new ITCounter();
	private FaseState state;
	private Computer naveForShot;
	private Computer[] inScreenNave;	
	private int inScreenNaveQuantity;
	
	public FaseState getState() {
		return state;
	}

	public void setState(FaseState state) {
		this.state = state;
	}

	public ITCounter getCounter() {
		return counter;
	}

	public int getInScreenNaveQuantity() {
		return inScreenNaveQuantity;
	}

	public void setInScreenNaveQuantity(int inScreenNaveQuantity) {
		this.inScreenNaveQuantity = inScreenNaveQuantity;
	}

	public Computer[] getInScreenComputers() {
		return inScreenNave;
	}

	public void setInScreenComputers(Computer[] inScreenNave) {
		this.inScreenNave = inScreenNave;
	}

	public Computer getNaveForShot() {
		return naveForShot;
	}

	public void setNaveForShot(Computer naveForShot) {
		this.naveForShot = naveForShot;
	}

}
