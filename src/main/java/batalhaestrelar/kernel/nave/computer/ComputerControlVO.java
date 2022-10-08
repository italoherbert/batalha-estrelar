package batalhaestrelar.kernel.nave.computer;

import batalhaestrelar.kernel.nave.NaveControlVO;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;

public class ComputerControlVO extends NaveControlVO implements ComputerControlTO {

	private ComputerGroup group;

	public ComputerGroup getGroup() {
		return group;
	}

	public void setGroup(ComputerGroup group) {
		this.group = group;
	}
	
}
