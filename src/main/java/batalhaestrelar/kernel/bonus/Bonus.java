package batalhaestrelar.kernel.bonus;

import batalhaestrelar.kernel.InScreenGC;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.modules.move.MoverTO;
import batalhaestrelar.modules.positionator.single.SinglePositionatorTO;

public interface Bonus extends InScreenGC, BonusShapeDriver, BonusConstants {

	public Fase getFase();
		
	public int getSinglePositionatorType();
	
	public int getMoverType();
	
	public SinglePositionatorTO getSinglePositionatorTO();

	public MoverTO getMoverTO();
	
	public BonusGroup getGroup();
	
}
