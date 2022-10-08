package batalhaestrelar.kernel;

public class ITCounter {
	
	private int count;

	public void inc() {
		count++;
	}
	
	public void dec() {
		count--;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
