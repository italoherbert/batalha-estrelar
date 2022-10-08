package batalhaestrelar.shape.nave.child.gun;

import batalhaestrelar.kernel.gun.GunRotation;
import batalhaestrelar.shape.gun.BigGunShape2D;
import batalhaestrelar.shape.gun.GunShape2D;
import batalhaestrelar.shape.gun.GunShapesBuilder;
import batalhaestrelar.shape.nave.StateNaveShape2D;

public class S2ChildNGunSBuilder implements GunShapesBuilder {

	private float gunWidthFactor;
	private float radialWidthFactor;
	
	public S2ChildNGunSBuilder( float gunWidthFactor, float radialWidthFactor ) {
		this.gunWidthFactor = gunWidthFactor;
		this.radialWidthFactor = radialWidthFactor;
	}

	public void build( StateNaveShape2D base, GunShape2D[] gunShapes, GunRotation[] gunRotations ) {		
		BigGunShape2D gs = new BigGunShape2D( base, radialWidthFactor ); 			
		gs.initialize( gunRotations[ 0 ] );		
		gs.getInitScale().setX( 2 );  		
		gs.getInitScale().setY( 2 );
		gs.setGunWidthFactor( gunWidthFactor );
		
		base.addShape( gs );
		
		gunShapes[0] = gs;
	}

}
