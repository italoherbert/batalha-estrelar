package batalhaestrelar.kernel.nave.computer;

import batalhaestrelar.kernel.nave.NaveControlTO;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;

public interface ComputerControlTO extends NaveControlTO {
	
	public ComputerGroup getGroup();

}
