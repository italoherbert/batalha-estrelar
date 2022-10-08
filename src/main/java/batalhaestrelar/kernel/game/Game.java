package batalhaestrelar.kernel.game;

import java.util.List;

import batalhaestrelar.kernel.GComponent;
import batalhaestrelar.kernel.cam.Cam;
import batalhaestrelar.kernel.fase.Fase;

public interface Game extends GComponent {
	
	public GameSession getSession();

	public Cam getCam();
	
	public List<Fase> getFases();
		
	public int getLifeQuantity();
	
	public int getPontuationForDestroyedChildNave();

	public int getPontuationForDestroyedMotherNave();

	public int getPontuationForLifeIncrement();
		
	public void setLifeQuantity( int lifeQuantity );
				
}
