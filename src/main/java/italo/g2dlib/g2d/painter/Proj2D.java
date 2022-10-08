package italo.g2dlib.g2d.painter;

import italo.g2dlib.g2d.G2DUtilities;

public class Proj2D {

	private G2DUtilities utils;

	public Proj2D( G2DUtilities utils ) {
		this.utils = utils;
	}

	public int[] calculatePoint( float x, float y ) {
		int[] p = new int[2];
		this.calculatePoint( x, y, p );
		return p;
	}

	public void calculatePoint( float x, float y, int[] point ) {
		int centerX = (int)Math.ceil( utils.getScreen().getWidth() * .5d );
		int centerY = (int)Math.ceil( utils.getScreen().getHeight() * .5d );		
		
		point[0] = centerX + ( (int)Math.ceil( utils.getNormalizer().value( x ) ) );
		point[1] = centerY - ( (int)Math.ceil( utils.getNormalizer().value( y ) ) );		
	}
	
}
