package batalhaestrelar.config.impl.gun;

import batalhaestrelar.kernel.gun.GunConfig;

public class GunCFGFactory {

	public final static int NONE = 1000;
	public final static int QUICK_OVAL = 1001;
	public final static int REPEAT_POLYG = 1002;

	public GunConfig create( int type ) {
		switch( REPEAT_POLYG ) {
			case QUICK_OVAL: return new QuickOvalGunCFG();
			case REPEAT_POLYG: return new RepeatPolygGunCFG();			
		}
		return null;
	}
	
}

