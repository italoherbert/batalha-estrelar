package batalhaestrelar.kernel;

import batalhaestrelar.kernel.score.ScoreDriver;

public interface PainterKernel {
	
	public void initialize( ScoreDriver score );
	
	public void repaint();
		
	public void showCenterMessage( String message );
	
	public void hideCenterMessage();
	
	public boolean isPaintInitialScreen();

	public void setPaintInitialScreen( boolean paintGame );
			
}
