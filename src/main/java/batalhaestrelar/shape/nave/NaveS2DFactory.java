package batalhaestrelar.shape.nave;

import batalhaestrelar.kernel.nave.NaveShape;
import batalhaestrelar.shape.nave.child.ChildNaveS2DFactory;
import batalhaestrelar.shape.nave.mother.MotherNaveS2DFactory;
import batalhaestrelar.shape.nave.player.PlayerNaveS2DFactory;

public class NaveS2DFactory {

	private PlayerNaveS2DFactory playerFactory = new PlayerNaveS2DFactory();
	private MotherNaveS2DFactory motherNaveFactory = new MotherNaveS2DFactory();
	private ChildNaveS2DFactory childNaveFactory = new ChildNaveS2DFactory();
	
	public NaveShape2D create( int type, int style ) {
		switch( type ) {
			case NaveShape.PLAYER: return playerFactory.create( style );
			case NaveShape.CHILD:  return childNaveFactory.create( style );
			case NaveShape.MOTHER: return motherNaveFactory.create( style );
		}
		return null;
	}
	
}
