package batalhaestrelar.shape.nave.child.gun;

import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.shape.gun.GunShape2D;
import batalhaestrelar.shape.gun.GunShapesBuilder;
import batalhaestrelar.shape.gun.RectGunShape2D;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class S1ChildNGunSBuilder implements GunShapesBuilder {

	public void build( StateNaveShape2D base, GunShape2D[] gunShapes, GunRotation[] gunRotations ) {
		gunShapes[ 0 ] = new RectGunShape2D( base, false );		
		for( int i = 0; i < gunShapes.length; i++ ) {
			gunShapes[i].initialize( gunRotations[ i ] );
			gunShapes[i].getInitScale().setX( 4.0f );
			gunShapes[i].getInitScale().setY( 12.0f );
			gunShapes[i].getInitRotation().setAngle( (float)Math.PI );
			base.addShape( gunShapes[i] );
		}
	}

}
