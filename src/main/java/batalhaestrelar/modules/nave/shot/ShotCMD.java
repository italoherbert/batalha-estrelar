package batalhaestrelar.modules.nave.shot;

import batalhaestrelar.kernel.nave.computer.Computer;

public interface ShotCMD {

	public final static int NONE = 0;
	public final static int RANDOM = 1;
	
	public void shot( Computer nave, ShotTO to );
	
}
