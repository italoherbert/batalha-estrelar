package batalhaestrelar.kernel.nave.computer.group;

import java.util.List;

import batalhaestrelar.kernel.nave.computer.Computer;

public interface ComputerGroup {
	
	public int getType();

	public List<Computer> getComputers();

	public int[] getTranslationIndexes();

	public float[][] getTranslationValues();
	
	public int getGroupPositionatorType();

}
