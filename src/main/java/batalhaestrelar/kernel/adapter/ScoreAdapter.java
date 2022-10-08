package batalhaestrelar.kernel.adapter;

import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.score.ScoreDriver;

public class ScoreAdapter implements ScoreDriver {

	private Game game;
	
	public ScoreAdapter(Game game) {
		this.game = game;
	}

	public int getLifeQuantity() {
		return game.getLifeQuantity();
	}

	public int getCurrentFaseIndex() {
		return game.getSession().getCurrentFaseIndex();
	}

	public int getScoreCount() {
		return game.getSession().getScoreValue();
	}

	public int getPlayerEnergy() {
		return game.getFases().get( game.getSession().getCurrentFaseIndex() ).getPlayer().getEnergy();
	}

}
