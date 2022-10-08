package batalhaestrelar.kernel.game;

import italo.control.Control;

import java.util.ArrayList;

import batalhaestrelar.kernel.fase.Fase;

public class GameControl implements Control<GameControlTO> {

	public void build( GameControlTO to ) {
		((GameImpl)to.getGame()).setFases( new ArrayList<Fase>() ); 
	}

	@Override
	public void init( GameControlTO to ) {
		GameImpl g = (GameImpl)to.getGame();	
		g.setLifeQuantity( to.getGameConfig().getLifeQuantity() );
		g.setPontuationForDestroyedChildNave( to.getGameConfig().getPontuationForDestroyedChildNave() );
		g.setPontuationForDestroyedMotherNave( to.getGameConfig().getPontuationForDestroyedMotherNave() );
		g.setPontuationForLifeIncrement( to.getGameConfig().getPontuationForLifeIncrement() );
	
		g.getSession().setState( GameState.EXECUTING );
		g.getSession().setCurrentFaseIndex( 0 );
		g.getSession().setScoreValue( 0 );
		g.getSession().setLifeIncCount( 1 );
	}

}
