package batalhaestrelar.kernel.nave.player;

import batalhaestrelar.kernel.nave.NaveImpl;

public class PlayerImpl extends NaveImpl implements Player {
	
	private boolean gunOn;
	
	private float camX;
	private float camY;
	private float positionIncInCam;
	private float bonusDistributeAngle;	
	private int bonusEnergyIncrement;
	
	private int distributeAngleInterval;
	private int energyIncInterval;
	private int expandShotInterval;
	
	private int normalState;
	
	private boolean leftMoveOn;
	private boolean rightMoveOn;
	private boolean upMoveOn;
	private boolean downMoveOn;
	
	public boolean isGunOn() {
		return gunOn;
	}
	
	public boolean isShoting() {
		return this.isGunOn();
	}

	public int currentState() {
		int state = super.currentState();
		if( state == NORMAL_NAVE_STATE ) {
			if( normalState != INITIAL_NORMAL_STATE ) {
				if( super.getSession().getStateCounter().getCount() % 2 == 0 )
					return normalState;
				return LOW_NAVE_STATE;
			}
			return normalState;				
		}
		return state;
	}
	
	public float getX() {
		return fase.getGame().getCam().getX() + camX;
	}
	
	public float getY() {
		return fase.getGame().getCam().getY() + camY;
	}
	
	public float getAbsX() {
		return this.getX() - fase.getX();
	}

	public float getAbsY() {
		return this.getY() - fase.getY();
	}

	public void setGunOn( boolean on ) {
		this.gunOn = on;
	}

	public float getCamX() {
		return camX;
	}

	public void setCamX(float camX) {
		this.camX = camX;
	}

	public float getCamY() {
		return camY;
	}

	public void setCamY(float camY) {
		this.camY = camY;
	}
	
	public int getNormalState() {
		return normalState;
	}

	public void setNormalState(int normalState) {
		this.normalState = normalState;
	}

	public float getPositionIncInCam() {
		return positionIncInCam;
	}

	public void setPositionIncInCam(float positionIncInCam) {
		this.positionIncInCam = positionIncInCam;
	}

	public float getBonusDistributeAngle() {
		return bonusDistributeAngle;
	}

	public void setBonusDistributeAngle(float distributeAngle) {
		this.bonusDistributeAngle = distributeAngle;
	}
		
	public int getBonusEnergyIncrement() {
		return bonusEnergyIncrement;
	}

	public void setBonusEnergyIncrement(int bonusEnergyIncrement) {
		this.bonusEnergyIncrement = bonusEnergyIncrement;
	}

	public int getDistributeAngleInterval() {
		return distributeAngleInterval;
	}

	public void setDistributeAngleInterval(int distributeAngleInterval) {
		this.distributeAngleInterval = distributeAngleInterval;
	}

	public int getEnergyIncInterval() {
		return energyIncInterval;
	}

	public void setEnergyIncInterval(int energyIncInterval) {
		this.energyIncInterval = energyIncInterval;
	}

	public int getExpandShotInterval() {
		return expandShotInterval;
	}

	public void setExpandShotInterval(int expandShotInterval) {
		this.expandShotInterval = expandShotInterval;
	}
	
	public boolean isLeftMoveOn() {
		return leftMoveOn;
	}

	public void setLeftMoveOn(boolean leftMoveOn) {
		this.leftMoveOn = leftMoveOn;
	}

	public boolean isRightMoveOn() {
		return rightMoveOn;
	}

	public void setRightMoveOn(boolean rightMoveOn) {
		this.rightMoveOn = rightMoveOn;
	}

	public boolean isUpMoveOn() {
		return upMoveOn;
	}

	public void setUpMoveOn(boolean upMoveOn) {
		this.upMoveOn = upMoveOn;
	}

	public boolean isDownMoveOn() {
		return downMoveOn;
	}

	public void setDownMoveOn(boolean downMoveOn) {
		this.downMoveOn = downMoveOn;
	}
	
}
