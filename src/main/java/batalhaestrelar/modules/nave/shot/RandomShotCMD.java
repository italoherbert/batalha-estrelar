package batalhaestrelar.modules.nave.shot;

import batalhaestrelar.kernel.nave.NaveKernel;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.modules.ModuleDriver;

public class RandomShotCMD implements ShotCMD {

	private ModuleDriver driver;
	
	public RandomShotCMD( ModuleDriver driver ) {
		this.driver = driver;
	}

	public void shot( Computer nave, ShotTO to ) {
		NaveKernel naveKernel = driver.getKernel().getNaveKernel();
		if( !nave.isInScreen() )
			return;
		if( naveKernel.isKilled( nave ) )
			return;
		if( nave.getGuns().isEmpty() )
			return;
		if( nave.isShotOnlyIfSelected() )
			if( nave != nave.getFase().getSession().getNaveForShot() )
				return;

		if( to.isToShot() ) {				
			if( to.getGSCount() < to.getQuantityBySequence() ) {
				if( to.getGSCount() == 0 ) {					
					naveKernel.addGunshot( nave, naveKernel.randomGun( nave ) );
					
					to.resetShotIntervalCount();
					to.incGSCount();
					
					nave.setShoting( true );
				} else {				
					if( to.getShotIntervalCount() < to.getShotInterval() ) {
						to.incShotIntervalCount();
					} else {
						naveKernel.addGunshot( nave, naveKernel.randomGun( nave ) );
					
						to.resetShotIntervalCount();
						to.incGSCount();
					}
				}
			} else {
				to.toStopState();
				nave.setShoting( false );
			}
		} else {
			if( to.getStopIntervalCount() < to.getStopInterval() ) {
				to.incStopIntervalCount();
			} else {
				to.toShotState();
				nave.setShoting( true );
			}				
		}	
	}	
	
}
