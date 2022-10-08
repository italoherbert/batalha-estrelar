package batalhaestrelar.modules.move;

import batalhaestrelar.kernel.InScreenGC;
import batalhaestrelar.kernel.fase.Fase;

public interface Mover {

	public final static int NONE = 0;
	public final static int HORIZONTAL = 1;
		
	public void move( Fase fase, InScreenGC sgc, MoverTO to );
	
}
