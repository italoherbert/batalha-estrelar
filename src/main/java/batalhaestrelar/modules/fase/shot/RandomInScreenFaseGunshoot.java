package batalhaestrelar.modules.fase.shot;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.fase.FaseSession;
import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.nave.NaveKernel;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.modules.ModuleDriver;

public class RandomInScreenFaseGunshoot implements FaseGunshoot {

	private ModuleDriver driver;
	private int interval = 50;
	
	public RandomInScreenFaseGunshoot( ModuleDriver driver ) {
		this.driver = driver;
	}

	public void shot( Fase fase ) {
		NaveKernel naveKernel = driver.getKernel().getNaveKernel();
		
		FaseSession session = fase.getSession();
		if( session.getCounter().getCount() % interval == 0 ) {			
			int count = 0;
			for( int i = 0; i < session.getInScreenNaveQuantity(); i++ ) {
				Computer nave = session.getInScreenComputers()[ i ];
				if( !naveKernel.isKilled( nave ) )
					count++;				
			}
			
			if( count > 0 ) {
				int randomValue = ( (int)Math.ceil( Math.random() * (count-1) ) ) + 1;
				Computer computer = null;
				for( int i = 0; randomValue > 0; i++ ) {
					computer = session.getInScreenComputers()[ i ];
					if( !naveKernel.isKilled( computer ) )
						randomValue--;					
				}
									
				Gun gun = naveKernel.randomGun( computer );
				if( gun != null )
					naveKernel.addGunshot( computer, gun );				
			}
														
		}
	}
	
}
