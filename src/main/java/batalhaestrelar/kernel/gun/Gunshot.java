package batalhaestrelar.kernel.gun;


public class Gunshot {

	private float x;
	private float y;
	private float gunAbsX;
	private float gunAbsY;
	
	private float angle;
	private Gun gun;
	private boolean active;
	
	public float getAbsX() {
		return ( gun.isRepeat() ? gun.getAbsX() : gunAbsX ) + x;
	}
	
	public float getAbsY() {
		return ( gun.isRepeat() ? gun.getAbsY() : gunAbsY ) + y;
	}
	
	public float getCamX() {
		if( gun.isRepeat() )
			return gun.getCamX() + x;
		return gunAbsX + x - gun.getNave().getFase().getGame().getCam().getX();
	}
	
	public float getCamY() {
		if ( gun.isRepeat() )
			return gun.getCamY() + y;
		return gunAbsY + y - gun.getNave().getFase().getGame().getCam().getY();
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getGunAbsX() {
		return gunAbsX;
	}

	public void setGunAbsX(float gunAbsX) {
		this.gunAbsX = gunAbsX;
	}

	public float getGunAbsY() {
		return gunAbsY;
	}

	public void setGunAbsY(float gunAbsY) {
		this.gunAbsY = gunAbsY;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}	

}
