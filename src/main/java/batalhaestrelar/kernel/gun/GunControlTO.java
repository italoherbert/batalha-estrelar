package batalhaestrelar.kernel.gun;

import italo.control.ControlTO;
import batalhaestrelar.kernel.nave.Nave;

public interface GunControlTO extends ControlTO {

	public GunConfig getGunConfig();

	public GunDriver getGunDriver();

	public Gun getGun();

	public Nave getNave();
	
}
