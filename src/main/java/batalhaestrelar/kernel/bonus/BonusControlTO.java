package batalhaestrelar.kernel.bonus;

import italo.control.ControlTO;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.GameConfig;

public interface BonusControlTO extends ControlTO {

	public BonusConfig getBonusConfig();

	public GameConfig getGameConfig();

	public Bonus getBonus();
	
	public Fase getFase();

	public BonusShape getShape();
	
	public BonusGroup getGroup();
	
}
