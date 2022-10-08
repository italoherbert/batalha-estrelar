package batalhaestrelar.kernel;

import italo.swingx.Painter;
import batalhaestrelar.kernel.fase.Fase;

public interface ShapeKernel extends ShapeFactory, Painter {
	
	public void initialize();

	public void configureAfterInit( Fase fase );

	public void configureBeforeRepaint( Fase fase ); 
	
	public CamScreen getCamScreen();
	
}
