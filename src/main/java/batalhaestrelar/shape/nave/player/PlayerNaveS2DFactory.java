package batalhaestrelar.shape.nave.player;

import batalhaestrelar.shape.nave.NaveShape2D;
import batalhaestrelar.shape.nave.NaveShapeConstants;

public class PlayerNaveS2DFactory {

	public NaveShape2D create( int style ) {
		switch( style ) {
			case NaveShapeConstants.PLAYER_S1: return new PlayerShape2D();
		}
		return null;
	}
	
}
