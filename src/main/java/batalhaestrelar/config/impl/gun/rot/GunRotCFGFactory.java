package batalhaestrelar.config.impl.gun.rot;

import batalhaestrelar.kernel.gun.GunRotatorConfig;

public class GunRotCFGFactory {

	public final static int NONE = 1000;
	public final static int CYCLIC = 1001;
	public final static int OCCILATION = 1002;
	
	public GunRotatorConfig create( int type ) {
		switch( type ) {
			case CYCLIC: return new CyclicGunRotCFG();
			case OCCILATION: return new OccilationGunRotCFG();		
		}
		return null;
	}
	
}
