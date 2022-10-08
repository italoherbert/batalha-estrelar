package batalhaestrelar.kernel.game;

import java.util.List;

import batalhaestrelar.kernel.AbstractGC;
import batalhaestrelar.kernel.cam.Cam;
import batalhaestrelar.kernel.fase.Fase;

public class GameImpl extends AbstractGC implements Game {
	
	private Cam cam;
	private List<Fase> fases;
	private int lifeQuantity;
	
	private int pontuationForDestroyedChildNave;
	private int pontuationForDestroyedMotherNave;
	private int pontuationForLifeIncrement;

	private GameSession session = new GameSession();
	
	public GameSession getSession() {
		return session;
	}

	public void setSession(GameSession session) {
		this.session = session;
	}

	public int getLifeQuantity() {
		return lifeQuantity;
	}

	public void setLifeQuantity(int lifeQuantity) {
		this.lifeQuantity = lifeQuantity;
	}

	public int getPontuationForDestroyedChildNave() {
		return pontuationForDestroyedChildNave;
	}

	public void setPontuationForDestroyedChildNave(
			int pontuationForDestroyedChildNave) {
		this.pontuationForDestroyedChildNave = pontuationForDestroyedChildNave;
	}

	public int getPontuationForDestroyedMotherNave() {
		return pontuationForDestroyedMotherNave;
	}

	public void setPontuationForDestroyedMotherNave(int pontuationForDestroyedMotherNave) {
		this.pontuationForDestroyedMotherNave = pontuationForDestroyedMotherNave;
	}

	public int getPontuationForLifeIncrement() {
		return pontuationForLifeIncrement;
	}

	public void setPontuationForLifeIncrement(int pontuationForLifeIncrement) {
		this.pontuationForLifeIncrement = pontuationForLifeIncrement;
	}

	public Cam getCam() {
		return cam;
	}

	public void setCam(Cam cam) {
		this.cam = cam;
	}

	public List<Fase> getFases() {
		return fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

}
