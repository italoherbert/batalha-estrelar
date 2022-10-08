package italo.algorithm;

public class SimpleAlgorithmAdapter implements Algorithm {
	
	private boolean flag = true;
	private SimpleAlgorithm algorithm;
	
	public SimpleAlgorithmAdapter( SimpleAlgorithm algorithm ) {
		this.algorithm = algorithm;
	}

	public void beforeExec() {}

	public void afterExec() {}

	public void execIT() {
		algorithm.exec();
		flag = false;
	}

	public boolean execCondition() {
		return flag;
	}

}
