package batalhaestrelar.kernel.game;

import batalhaestrelar.kernel.fase.Fase;

public interface GameKernel {
		
	public void processScore( Game game );

	public Fase getCurrentFase( Game game );
	
	public boolean backFase( Game game );

	public boolean nextFase( Game game );
	
	public boolean isLastFase( Game game );
			
}
