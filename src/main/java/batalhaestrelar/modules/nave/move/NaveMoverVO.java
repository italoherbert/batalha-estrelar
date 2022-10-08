package batalhaestrelar.modules.nave.move;

import batalhaestrelar.modules.move.MoverVO;

public class NaveMoverVO extends MoverVO implements NaveMoverTO {

	private boolean execIfShoting;

	public boolean isExecIfShoting() {
		return execIfShoting;
	}

	public void setExecIfShoting(boolean execIfShoting) {
		this.execIfShoting = execIfShoting;
	}
	
}
