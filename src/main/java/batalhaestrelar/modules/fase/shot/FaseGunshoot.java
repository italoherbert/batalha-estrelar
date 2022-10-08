package batalhaestrelar.modules.fase.shot;

import batalhaestrelar.kernel.fase.Fase;

public interface FaseGunshoot {

	public final static int NONE = 0;
	public final static int RANDOM = 1;
	
	public void shot( Fase fase );
	
}
