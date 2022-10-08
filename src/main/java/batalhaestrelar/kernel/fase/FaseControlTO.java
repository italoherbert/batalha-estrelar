package batalhaestrelar.kernel.fase;

import italo.control.ControlTO;

import java.util.List;

import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;

public interface FaseControlTO extends ControlTO {

	public FaseConfig getFaseConfig();

	public Fase getFase();

	public Game getGame();
	
	public int getIndex();

	public FaseShape getShape();
	
	public List<ComputerGroup> getComputerGroups();
	
	public List<BonusGroup> getBonusGroups();
	
}
