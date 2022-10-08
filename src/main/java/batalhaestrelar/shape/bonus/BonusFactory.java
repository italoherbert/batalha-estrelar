package batalhaestrelar.shape.bonus;

import batalhaestrelar.kernel.bonus.BonusShape;

public class BonusFactory {

	public BonusShape2D create( int type ) {
		switch( type ) {
			case BonusShape.ENERGY_INCREMENT: return new EBonusShape2D();
			case BonusShape.EXPAND_SHOT: return new TBonusShape2D();
		}
		return null;
	}
	
}
