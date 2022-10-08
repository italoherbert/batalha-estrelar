package batalhaestrelar.kernel.nave.computer;

import batalhaestrelar.kernel.nave.NaveImpl;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.modules.gunrot.GunRotatorTO;
import batalhaestrelar.modules.nave.move.NaveMoverTO;
import batalhaestrelar.modules.nave.shot.ShotTO;
import batalhaestrelar.modules.positionator.single.SinglePositionatorTO;

public class ComputerImpl extends NaveImpl implements Computer {
		
	private ComputerGroup group;
	
	private int singlePositionatorType;
	private int shotType;
	private int gunRotatorType;
	private int moverType;
	
	private SinglePositionatorTO singlePositionatorTO = null;
	private GunRotatorTO gunRotatorTO = null;
	private NaveMoverTO moverTO = null;
	private ShotTO shotTO = null;
	
	private boolean shotOnlyIfSelected;

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
	
	public int getSinglePositionatorType() {
		return singlePositionatorType;
	}

	public void setSinglePositionatorType(int singlePositionatorType) {
		this.singlePositionatorType = singlePositionatorType;
	}

	public int getShotType() {
		return shotType;
	}

	public void setShotType(int shotType) {
		this.shotType = shotType;
	}

	public int getMoverType() {
		return moverType;
	}

	public void setMoverType(int moverType) {
		this.moverType = moverType;
	}

	public int getGunRotatorType() {
		return gunRotatorType;
	}

	public void setGunRotatorType(int gunRotatorType) {
		this.gunRotatorType = gunRotatorType;
	}

	public SinglePositionatorTO getSinglePositionatorTO() {
		return singlePositionatorTO;
	}

	public void setSinglePositionatorTO(SinglePositionatorTO singlePositionatorTO) {
		this.singlePositionatorTO = singlePositionatorTO;
	}

	public GunRotatorTO getGunRotatorTO() {
		return gunRotatorTO;
	}

	public void setGunRotatorTO(GunRotatorTO gunRotatorTO) {
		this.gunRotatorTO = gunRotatorTO;
	}

	public NaveMoverTO getMoverTO() {
		return moverTO;
	}

	public void setMoverTO(NaveMoverTO moverTO) {
		this.moverTO = moverTO;
	}
	
	public ShotTO getShotTO() {
		return shotTO;
	}

	public void setShotTO(ShotTO shotTO) {
		this.shotTO = shotTO;
	}

	public boolean isShotOnlyIfSelected() {
		return shotOnlyIfSelected;
	}

	public void setShotOnlyIfSelected(boolean shotOnlyIfSelected) {
		this.shotOnlyIfSelected = shotOnlyIfSelected;
	}

	public ComputerGroup getGroup() {
		return group;
	}

	public void setGroup(ComputerGroup group) {
		this.group = group;
	}

}
