package batalhaestrelar.modules.nave.move;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.nave.Nave;

public interface NaveMover {

	public final static int NONE = 0;
	public final static int HORIZONTAL = 1;
	
	public void move( Fase fase, Nave nave, NaveMoverTO to );

}
