package italo.g2dlib.g2d.transform;

import italo.g2dlib.g2d.vector.Vector2D;

public class Scaller2D implements Transformer2D {

	@Override
	public void transform( Vector2D gt, Vector2D vertex ) {
		vertex.setX( vertex.getX() * gt.getX() );
		vertex.setY( vertex.getY() * gt.getY() );
	}

}
