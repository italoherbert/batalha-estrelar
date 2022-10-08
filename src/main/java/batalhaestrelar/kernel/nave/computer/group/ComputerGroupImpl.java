package batalhaestrelar.kernel.nave.computer.group;

import java.util.List;

import batalhaestrelar.kernel.nave.computer.Computer;

public class ComputerGroupImpl implements ComputerGroup {

	private int type;	
	private List<Computer> computers;
	private int[] translationIndexes;
	private float[][] translationValues;

	private int groupPositionatorType;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	public int getGroupPositionatorType() {
		return groupPositionatorType;
	}

	public void setGroupPositionatorType(int groupPositionatorType) {
		this.groupPositionatorType = groupPositionatorType;
	}

	public int[] getTranslationIndexes() {
		return translationIndexes;
	}

	public void setTranslationIndexes(int[] translationIndexes) {
		this.translationIndexes = translationIndexes;
	}

	public float[][] getTranslationValues() {
		return translationValues;
	}

	public void setTranslationValues(float[][] translations) {
		this.translationValues = translations;
	}

}
