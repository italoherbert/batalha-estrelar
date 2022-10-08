package batalhaestrelar.kernel.bonus;

import java.util.List;

public interface BonusGroup {

	public int getType();
	
	public int getGroupPositionatorType();
	
	public List<Bonus> getBonusList();
	
}
