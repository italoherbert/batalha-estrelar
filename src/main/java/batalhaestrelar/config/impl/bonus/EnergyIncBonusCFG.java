package batalhaestrelar.config.impl.bonus;

import batalhaestrelar.config.impl.mover.LowMoverCFG;
import batalhaestrelar.kernel.MoverConfig;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusConfig;
import batalhaestrelar.modules.move.Mover;
import batalhaestrelar.modules.positionator.group.GroupPositionator;
import batalhaestrelar.modules.positionator.single.SinglePositionator;

public class EnergyIncBonusCFG implements BonusConfig {

	private int type = Bonus.ENERGY_INCREMENT;
	private int quantity;
	
	private int singlePosCellNumber;
	
	private int groupPositionatorType = GroupPositionator.NONE;
	private int singlePositionatorType = SinglePositionator.RANDOM;
	private int moverType = Mover.HORIZONTAL;
	
	private MoverConfig moverConfig = new LowMoverCFG();

	public EnergyIncBonusCFG( int cellNumber, int quantity ) {
		this.singlePosCellNumber = cellNumber;
		this.quantity = quantity;
	}
	
	public int getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSinglePosCellNumber() {
		return singlePosCellNumber;
	}

	public int getGroupPositionatorType() {
		return groupPositionatorType;
	}

	public int getSinglePositionatorType() {
		return singlePositionatorType;
	}

	public int getMoverType() {
		return moverType;
	}

	public MoverConfig getMoverConfig() {
		return moverConfig;
	}

}
