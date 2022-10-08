package batalhaestrelar.config.impl.mover;

import batalhaestrelar.kernel.MoverConfig;

public class MoverCFGFactory {

	public final static int NONE = 1000;
	public final static int QUICK = 1001;
	
	public final static int MOVE_AND_ROT_ALLOWED = 2001;
	public final static int NO_MOVE_AND_ROT_ALLOWED = 2002;
	
	public MoverConfig create( int type, boolean moveAndRotAllowed ) {
		switch( type ) {
			case QUICK: return new QuickNaveMoverCFG( moveAndRotAllowed );				
		}
		return null;
	}
}
