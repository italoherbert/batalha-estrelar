package batalhaestrelar.kernel.bonus;

import batalhaestrelar.kernel.AbstractShapeGC;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.modules.move.MoverTO;
import batalhaestrelar.modules.positionator.single.SinglePositionatorTO;

public class BonusImpl extends AbstractShapeGC implements Bonus {

	private Fase fase;
	private BonusShape shape;	
	private BonusGroup group;
	
	private int singlePositionatorType;
	private int moverType;

	private MoverTO moverTO;
	private SinglePositionatorTO singlePositionatorTO;
	
	private boolean active;
	private boolean inScreen;
			
	public float getCamX() {
		return super.getX() - ( fase.getGame().getCam().getX() - fase.getX() );
	}

	public float getCamY() {
		return super.getY() - ( fase.getGame().getCam().getY() - fase.getY() );
	}

	public float getAbsX() {
		return super.getX() - fase.getX();
	}

	public float getAbsY() {
		return super.getY() - fase.getY();
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isInScreen() {
		return inScreen;
	}

	public void setInScreen(boolean inScreen) {
		this.inScreen = inScreen;
	}
	
	public int getSinglePositionatorType() {
		return singlePositionatorType;
	}

	public void setSinglePositionatorType(int singlePositionatorType) {
		this.singlePositionatorType = singlePositionatorType;
	}

	public MoverTO getMoverTO() {
		return moverTO;
	}

	public void setMoverTO(MoverTO moverTO) {
		this.moverTO = moverTO;
	}

	public SinglePositionatorTO getSinglePositionatorTO() {
		return singlePositionatorTO;
	}

	public void setSinglePositionatorTO(SinglePositionatorTO inFasePositionatorTO) {
		this.singlePositionatorTO = inFasePositionatorTO;
	}

	public int getMoverType() {
		return moverType;
	}

	public void setMoverType(int moverType) {
		this.moverType = moverType;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public BonusShape getShape() {
		return shape;
	}

	public void setShape(BonusShape shape) {
		this.shape = shape;
	}

	public BonusGroup getGroup() {
		return group;
	}

	public void setGroup(BonusGroup group) {
		this.group = group;
	}

}
