package italo.g2dlib.g2d.transform;

import italo.g2dlib.g2d.vector.Vector2D;

import java.util.List;

public class Transformer2DManager {

	private Rotator2D rotator = new Rotator2D();
	private Translator2D translator = new Translator2D();
	private Scaller2D scaller = new Scaller2D();
		
	public void buildTransformVectors( TransformVectors2D tvectors, List<Transform2D> gts ) {
		for( Transform2D gt : gts ) {
			if( gt instanceof Rotation2D ) {
				tvectors.getRotation().setX( tvectors.getRotation().getX() + gt.getX() );
				tvectors.getRotation().setY( tvectors.getRotation().getY() + gt.getY() );
			} else if( gt instanceof Translation2D ) {
				tvectors.getTranslation().setX( tvectors.getTranslation().getX() + gt.getX() );
				tvectors.getTranslation().setY( tvectors.getTranslation().getY() + gt.getY() );		
			} else if( gt instanceof Scale2D ) {
				tvectors.getScale().setX( tvectors.getScale().getX() * gt.getX() );
				tvectors.getScale().setY( tvectors.getScale().getY() * gt.getY() );
			}
		}
	}
	
	public void transform( TransformVectors2D tvectors, Vector2D vertex ) {
		rotator.transform( tvectors.getRotation(), vertex );
		translator.transform( tvectors.getTranslation(), vertex );
		scaller.transform( tvectors.getScale(), vertex );
	}

	public Rotator2D getRotator() {
		return rotator;
	}

	public Translator2D getTranslator() {
		return translator;
	}

	public Scaller2D getScaller() {
		return scaller;
	}
	
}
