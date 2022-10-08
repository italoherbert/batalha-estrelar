package batalhaestrelar.modules.nave.gunrot;

import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.NaveKernel;
import batalhaestrelar.modules.ModuleDriver;
import batalhaestrelar.modules.gunrot.GunRotator;
import batalhaestrelar.modules.gunrot.GunRotatorTO;

public class RandomNaveGunRotator implements NaveGunRotator {

	private ModuleDriver driver;
	
	public RandomNaveGunRotator(ModuleDriver driver) {
		this.driver = driver;
	}

	public void rotate( Nave nave, GunRotatorTO to ) {
		GunRotator rotator = driver.getKernel().getModuleManager().getGunRotator( GunRotator.RANDOM );		
		NaveKernel naveKernel = driver.getKernel().getNaveKernel();
		
		if( nave.getFase().getSession().getCounter().getCount() % to.getInterval() == 0 ) {			
			if( nave.isInScreen() ) {
				Gun gun = naveKernel.randomGun( nave );
				if( gun != null )
					rotator.rotate( gun, to );
			}
		}		
	}

}
