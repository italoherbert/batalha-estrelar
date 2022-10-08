package batalhaestrelar.kernel.nave;

import java.util.List;

import batalhaestrelar.kernel.InScreenGC;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.gun.GunshotBuffer;

public interface Nave extends InScreenGC, NaveConstants {
		
	public boolean activeCondition();
	
	public int currentState();

	public boolean isShoting();

	public NaveShape getShape();
	
	public NaveSession getSession();
	
	public List<Gun> getGuns();
	
	public GunshotBuffer getGunshotBuffer();
		
	public Fase getFase();
		
	public int getEnergy();
		
	public int getState();
			
	public int getShotedInterval();
	
	public int getDestroyedInterval();
	
	public void setEnergy( int energy );
	
	public void setShoting( boolean flag );
	
}
