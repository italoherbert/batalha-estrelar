package italo.g2dlib.g2d.transform;

import italo.g2dlib.g2d.vector.Vector2D;

public class TransformVectors2D {

	private Vector2D translation = new Vector2D( 0, 0 );
	private Vector2D rotation = new Vector2D( 0, 0 );
	private Vector2D scale = new Vector2D( 1, 1 );
	
	public void reinit() {
		translation.setX( 0 );
		translation.setY( 0 );
		rotation.setX( 0 );
		rotation.setY( 0 );
		scale.setX( 1 );
		scale.setY( 1 );
	}

	public Vector2D getTranslation() {
		return translation;
	}

	public Vector2D getRotation() {
		return rotation;
	}

	public Vector2D getScale() {
		return scale;
	}

}
