package batalhaestrelar.kernel.bonus;

import java.util.List;

public class BonusGroupImpl implements BonusGroup {

	private int type;
	private List<Bonus> bonusList;

	private int groupPositionatorType;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getGroupPositionatorType() {
		return groupPositionatorType;
	}

	public void setGroupPositionatorType(int groupPositionatorType) {
		this.groupPositionatorType = groupPositionatorType;
	}

	public List<Bonus> getBonusList() {
		return bonusList;
	}

	public void setBonusList(List<Bonus> bonusList) {
		this.bonusList = bonusList;
	}

}
