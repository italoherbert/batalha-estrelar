package batalhaestrelar.kernel.nave.player;

import batalhaestrelar.kernel.nave.Nave;

public interface Player extends Nave {
		
	public float getPositionIncInCam();
	
	public float getBonusDistributeAngle();
	
	public int getBonusEnergyIncrement();
	
	public int getDistributeAngleInterval();

	public int getEnergyIncInterval();
	
	public int getExpandShotInterval();

	public int getNormalState();
	
	public void setNormalState( int state );
	
	public boolean isGunOn();
	
	public void setGunOn( boolean on );

	public boolean isUpMoveOn();

	public void setUpMoveOn(boolean upMoveOn);

	public boolean isDownMoveOn();

	public void setDownMoveOn(boolean downMoveOn);

	public boolean isLeftMoveOn();

	public void setLeftMoveOn(boolean leftMoveOn);

	public boolean isRightMoveOn();
	
	public void setRightMoveOn(boolean rightMoveOn);

}
