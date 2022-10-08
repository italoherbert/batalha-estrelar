package batalhaestrelar.shape.nave.child;

import batalhaestrelar.shape.gun.GunShapesBuilder;
import batalhaestrelar.shape.nave.NaveShape2D;
import batalhaestrelar.shape.nave.NaveShapeConstants;
import batalhaestrelar.shape.nave.child.gun.S1ChildNGunSBuilder;
import batalhaestrelar.shape.nave.child.gun.S2ChildNGunSBuilder;

public class ChildNaveS2DFactory {

	private GunShapesBuilder gsbuilder1 = new S1ChildNGunSBuilder();
	private S2ChildNGunSBuilder gsbuilder2 = new S2ChildNGunSBuilder( 2.6f, 6 );
	private S2ChildNGunSBuilder gsbuilder3 = new S2ChildNGunSBuilder( 5, 7 );
	
	public NaveShape2D create( int style ) {		
		switch( style ) {
			case NaveShapeConstants.CHILD_S1: return new ChildNaveShape2D( gsbuilder1 );
			case NaveShapeConstants.CHILD_S2: return new ChildNaveShape2D( gsbuilder2 );
			case NaveShapeConstants.CHILD_S3: return new ChildNaveShape2D( gsbuilder3 );
		}
		return null;
	}
	
}
