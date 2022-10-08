package batalhaestrelar.run.algorithm;

import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.player.Player;

public class PlayerAlgorithm {

	private Kernel kernel;

	public PlayerAlgorithm( Kernel kernel ) {
		this.kernel = kernel;
	}

	public void exec( Nave nave ) {		
		kernel.getNaveKernel().updateState( nave );
		
		kernel.getNaveKernel().updateNormalState( (Player)nave );
		kernel.getNaveKernel().updateDistributeGunsAngle( (Player)nave );		
	}
	
}
