package batalhaestrelar.kernel.bonus;

import batalhaestrelar.kernel.MoverConfig;

public interface BonusConfig {

	public int getType();
	
	public int getQuantity();
	
	public int getSinglePosCellNumber();
	
	public int getGroupPositionatorType();

	public int getSinglePositionatorType();
	
	public int getMoverType();
	
	public MoverConfig getMoverConfig();
	
}
