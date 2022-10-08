package batalhaestrelar.kernel.nave;

import italo.control.ControlTO;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.gun.GunshotBuffer;


public interface NaveControlTO extends ControlTO {

	public NaveConfig getNaveConfig();

	public Nave getNave();
	
	public Fase getFase();

	public NaveShape getShape();

	public GunshotBuffer getGunshotBuffer();
	
}
