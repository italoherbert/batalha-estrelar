package batalhaestrelar.config.impl.gun.shot;

import batalhaestrelar.kernel.gun.ShotConfig;

public class ShotCFGFactory {

	public final static int NONE = 1000;
	public final static int SHORTSLEEP = 1001;
	public final static int LONGSLEEP = 1002;
	
	public ShotConfig create( int type ) {
		switch( type ) {
			case SHORTSLEEP: return new ShortSleepShotCFG();
			case LONGSLEEP: return new LongSleepShotCFG();
		}
		return null;
	}
	
	
}
