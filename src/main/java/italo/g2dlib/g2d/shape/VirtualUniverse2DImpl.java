package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.G2DUtilities;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;

public class VirtualUniverse2DImpl extends AbstractGroupShape2D implements VirtualUniverse2D {

	private G2DUtilities utils;
		
	public VirtualUniverse2DImpl( G2DUtilities utils ) {
		this.utils = utils;
	}

	public void configurePainterForThis() {
		utils.getPainter().configure( this );
	}

	public void buildInit() {
		utils.recursiveSetG2DUtilities( this );
		
		super.buildInit();		
	}

	@Override
	public void buildShape( Geom2DBuilder gb ) {
		
	}		
	
}
