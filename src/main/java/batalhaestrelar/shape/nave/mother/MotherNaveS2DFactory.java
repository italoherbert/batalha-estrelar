package batalhaestrelar.shape.nave.mother;

import batalhaestrelar.shape.nave.NaveShape2D;
import batalhaestrelar.shape.nave.NaveShapeConstants;
import batalhaestrelar.shape.nave.mother.s1.S1MotherNaveShape2D;
import batalhaestrelar.shape.nave.mother.s2.S2MotherNaveShape2D;
import batalhaestrelar.shape.nave.mother.s3.S3MotherNaveShape2D;

public class MotherNaveS2DFactory {

	public NaveShape2D create( int style ) {
		switch( style ) {
			case NaveShapeConstants.MOTHER_S1: return new S1MotherNaveShape2D();
			case NaveShapeConstants.MOTHER_S2: return new S2MotherNaveShape2D();
			case NaveShapeConstants.MOTHER_S3: return new S3MotherNaveShape2D();
		}
		return null;
	}
	
}
