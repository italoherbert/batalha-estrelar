package batalhaestrelar.kernel;

import batalhaestrelar.kernel.bonus.BonusShape;
import batalhaestrelar.kernel.fase.FaseShape;
import batalhaestrelar.kernel.nave.NaveShape;

public interface ShapeFactory {

	public FaseShape createAndAddFaseShape( int faseIndex );
	
	public BonusShape createAndAddBonusShape( int faseIndex, int type );
	
	public NaveShape createAndAddNaveShape( int faseIndex, int type, int style );
	
}
