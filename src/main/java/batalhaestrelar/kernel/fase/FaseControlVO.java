package batalhaestrelar.kernel.fase;

import java.util.List;

import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;

public class FaseControlVO implements FaseControlTO {

	private FaseConfig faseConfig;

	private Fase fase;
	private Game game;
	private int index;
	private FaseShape shape;
	private List<ComputerGroup> computerGroups;
	private List<BonusGroup> bonusGroups;

	public FaseConfig getFaseConfig() {
		return faseConfig;
	}

	public void setFaseConfig(FaseConfig faseConfig) {
		this.faseConfig = faseConfig;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public FaseShape getShape() {
		return shape;
	}

	public void setShape(FaseShape shape) {
		this.shape = shape;
	}

	public List<ComputerGroup> getComputerGroups() {
		return computerGroups;
	}

	public void setComputerGroups(List<ComputerGroup> computerGroups) {
		this.computerGroups = computerGroups;
	}

	public List<BonusGroup> getBonusGroups() {
		return bonusGroups;
	}

	public void setBonusGroups(List<BonusGroup> bonusGroups) {
		this.bonusGroups = bonusGroups;
	}

}
