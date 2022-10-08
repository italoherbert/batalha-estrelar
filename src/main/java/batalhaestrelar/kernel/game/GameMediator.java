package batalhaestrelar.kernel.game;

import batalhaestrelar.kernel.fase.Fase;

public class GameMediator {			
			
	public void processScore( Game game ) {
		GameSession session = game.getSession();
		int scoreValue = session.getScoreValue();
		int pontuation = game.getPontuationForLifeIncrement() * session.getLifeIncCount();
		
		if( scoreValue >= pontuation ) {
			game.setLifeQuantity( game.getLifeQuantity() + 1 );
			session.setLifeIncCount( session.getLifeIncCount() + 1 ); 
		}
	}
	
	public boolean backFase( Game game ) {
		GameSession session = game.getSession();
		int index = session.getCurrentFaseIndex();
		if( index > 0 ) {
			session.setCurrentFaseIndex( session.getCurrentFaseIndex() - 1 );
			return true;
		}
		return false;
	}
	
	public boolean nextFase( Game game ) {
		GameSession session = game.getSession();
		int size = game.getFases().size();		
		int index = session.getCurrentFaseIndex();
		if( index < size-1 ) {
			session.setCurrentFaseIndex( session.getCurrentFaseIndex() + 1 );
			return true;
		}
		return false;
	}
	
	public Fase getCurrentFase( Game game ) {
		return game.getFases().get( game.getSession().getCurrentFaseIndex() );
	}
	
	public boolean isGameOver( Game game ) {
		return game.getLifeQuantity() == 0;
	}
	
	public boolean isLastFase( Game game ) {
		int size = game.getFases().size();
		return game.getSession().getCurrentFaseIndex() == (size-1);
	}
			
}
