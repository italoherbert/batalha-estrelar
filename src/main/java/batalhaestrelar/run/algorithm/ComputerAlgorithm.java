package batalhaestrelar.run.algorithm;

import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.computer.Computer;

public class ComputerAlgorithm {

	private Kernel kernel;

	public ComputerAlgorithm( Kernel kernel ) {
		this.kernel = kernel;
	}
	
	public void exec( Nave nave ) {
		Computer c = (Computer)nave;
		
		kernel.getModuleManager().getNaveMover( c.getMoverType() ).move( c.getFase(), c, c.getMoverTO() );
		kernel.getModuleManager().getNaveGunRotator( c.getGunRotatorType() ).rotate( c, c.getGunRotatorTO() );
		kernel.getModuleManager().getNaveGunshoot( c.getShotType() ).shot( c, c.getShotTO() );
		
		kernel.getNaveKernel().updateState( c );		
	}	

}
