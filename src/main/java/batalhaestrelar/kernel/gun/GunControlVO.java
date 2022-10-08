package batalhaestrelar.kernel.gun;

import batalhaestrelar.kernel.nave.Nave;

public class GunControlVO implements GunControlTO {

	private GunConfig gunConfig;	
	private GunDriver gunDriver;
	
	private Gun gun;
	private Nave nave;

	public GunConfig getGunConfig() {
		return gunConfig;
	}

	public void setGunConfig(GunConfig gunConfig) {
		this.gunConfig = gunConfig;
	}

	public GunDriver getGunDriver() {
		return gunDriver;
	}

	public void setGunDriver(GunDriver gunDriver) {
		this.gunDriver = gunDriver;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
}
