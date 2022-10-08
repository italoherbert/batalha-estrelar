package batalhaestrelar.kernel.game;


public class GameSession {
	
	private int currentFaseIndex;
	private int scoreValue;
	private int lifeIncCount;
	private GameState state;

	public int getCurrentFaseIndex() {
		return currentFaseIndex;
	}

	public void setCurrentFaseIndex( int currentFaseIndex ) {
		this.currentFaseIndex = currentFaseIndex;
	}

	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	public int getLifeIncCount() {
		return lifeIncCount;
	}

	public void setLifeIncCount(int lifeIncCount) {
		this.lifeIncCount = lifeIncCount;
	}

	public GameState getState() {
		return state;
	}

	public void setState( GameState state ) {
		this.state = state;
	}

}
