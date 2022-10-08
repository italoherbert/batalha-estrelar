package batalhaestrelar.kernel.bonus;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.GameConfig;

public class BonusControlVO implements BonusControlTO {

	private BonusConfig bonusConfig;
	private GameConfig gameConfig;

	private Bonus bonus;
	private Fase fase;
	private BonusShape shape;
	private BonusGroup group;

	public BonusConfig getBonusConfig() {
		return bonusConfig;
	}

	public void setBonusConfig(BonusConfig bonusConfig) {
		this.bonusConfig = bonusConfig;
	}

	public GameConfig getGameConfig() {
		return gameConfig;
	}

	public void setGameConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public BonusShape getShape() {
		return shape;
	}

	public void setShape(BonusShape shape) {
		this.shape = shape;
	}

	public BonusGroup getGroup() {
		return group;
	}

	public void setGroup(BonusGroup group) {
		this.group = group;
	}

}
