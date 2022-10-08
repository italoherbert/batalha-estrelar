package batalhaestrelar.kernel.nave;

import java.util.ArrayList;
import java.util.List;

import batalhaestrelar.kernel.AbstractShapeGC;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.gun.GunshotBuffer;

public abstract class NaveImpl extends AbstractShapeGC implements Nave {

	private NaveShape shape;
	
	protected Fase fase;	
	private List<Gun> guns = new ArrayList<Gun>();
	private GunshotBuffer gunshotBuffer;
	
	private int energy;
	private int state;
	
	private int shotedITQuantity;
	private int destroyedITQuantity;
			
	private boolean inScreen;
	private boolean shoting;
	
	private NaveSession session = new NaveSession();
	
	public boolean activeCondition() {
		return state != INACTIVE_NAVE_STATE;
	}
	
	public int currentState() {
		if( state == SHOTED_NAVE_STATE ) {
			if( session.getStateCounter().getCount() % 2 == 0 )
				return SHOTED_NAVE_STATE;
			return LOW_NAVE_STATE;
		}
		return state;
	}
	
	public NaveSession getSession() {
		return session;
	}

	public void setSession(NaveSession session) {
		this.session = session;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
	public List<Gun> getGuns() {
		return guns;
	}

	public void setGuns(List<Gun> guns) {
		this.guns = guns;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public boolean isInScreen() {
		return inScreen;
	}

	public void setInScreen(boolean inScreen) {
		this.inScreen = inScreen;
	}	

	public boolean isShoting() {
		return shoting;
	}

	public void setShoting(boolean shoting) {
		this.shoting = shoting;
	}

	public int getShotedInterval() {
		return shotedITQuantity;
	}

	public void setShotedITQuantity(int shotedITQuantity) {
		this.shotedITQuantity = shotedITQuantity;
	}

	public int getDestroyedInterval() {
		return destroyedITQuantity;
	}

	public void setDestroyedITQuantity(int destroyedITQuantity) {
		this.destroyedITQuantity = destroyedITQuantity;
	}	

	public GunshotBuffer getGunshotBuffer() {
		return gunshotBuffer;
	}

	public void setGunshotBuffer(GunshotBuffer gunshotBuffer) {
		this.gunshotBuffer = gunshotBuffer;
	}

	public NaveShape getShape() {
		return shape;
	}

	public void setShape(NaveShape shape) {
		this.shape = shape;
	}

}
