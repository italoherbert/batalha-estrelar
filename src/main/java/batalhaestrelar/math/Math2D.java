package batalhaestrelar.math;


public class Math2D {
			
	public float[] interceptRectPoint( float bx, float by, float x1, float y1, float x2, float y2, float angle ) {
		float[] p = { 0, 0 };		
		if( !this.isAngleIn0_360( angle ) )			
			angle = this.angle0_360( angle );
		
		if( angle < Math.PI ) {			
			p[0] = ( angle < ( Math.PI * .5d ) ? x2 : x1 );			
			p[1] = this.calculateY2ByAngle( bx, by, p[0], angle );
			if( p[1] > y2 ) {
				p[1] = y2;
				p[0] = this.calculateX2ByAngle( bx, by, p[1], angle );
			}
		} else {
			p[0] = ( angle < ( Math.PI * 1.5d ) ? x1 : x2 );							
			p[1] = this.calculateY2ByAngle( bx, by, p[0], angle );
			if( p[1] < y1 ) {
				p[1] = y1;
				p[0] = this.calculateX2ByAngle( bx, by, p[1], angle );
			}
		}		
		return p;
	}
	
	public float cumpriment( float[] p ) {
		return this.cumpriment( p[0], p[1] );
	}
	
	public float cumpriment( float x, float y ) {
		return (float)Math.sqrt( (x*x) + (y*y) );
	}
	
	public float calculateX2ByAngle( float x1, float y1, float y2, float angle ) {
		if( y2 - y1 == 0 )
			return x1;
		return this.calculateX2( x1, y1, y2, (float)Math.tan( angle ) );
	}
	
	public float calculateY2ByAngle( float x1, float y1, float x2, float angle ) {
		if( x2 == x1 )
			return y1;
		return this.calculateY2( x1, y1, x2, (float)Math.tan( angle ) );
	}

	public float calculateX2( float x1, float y1, float y2, float cang ) {
		if( y2 - y1 == 0 )
			return x1;
		return ( ( y2 - y1 ) + ( x1 * cang ) ) / cang;
	}
	
	public float calculateY2( float x1, float y1, float x2, float cang ) {
		return ( cang * ( x2 - x1 ) ) + y1;
	}
	
	public float[] coordinate( float x, float y, float radial, float angle ) {
		float[] p = this.coordinate( radial, angle );
		p[0] += x;
		p[1] += y;
		return p;
	}
	
	public float[] coordinate( float radial, float angle ) {
		float[] p = { radial, 0 };
		this.rotate( p, angle );
		return p;
	}
	
	public void rotate( float[] p, float angle ) {
		float a = (float)Math.atan2( p[1], p[0] );
		float r = (float)Math.sqrt( ( p[0]*p[0] ) + ( p[1]*p[1] ) );
		
		p[0] = r * (float)Math.cos( angle + a );
		p[1] = r * (float)Math.sin( angle + a );		
	}
					
	public boolean isAngleInS_180( float a ) {
		return a > -Math.PI && a <= Math.PI;
	}
	
	public boolean isAngleIn0_360( float a ) {
		return a >= 0 && a < (2.0d * Math.PI);
	}
	
	public float angleS_180( float a ) {
		return this.angle0_360toS_180( this.angle0_360( a ) );	
	}
	
	public float angle0_360toS_180( float a ) {
		if( a < Math.PI ) {
			return a;
		} else {
			return (float)( a - (Math.PI + Math.PI ) );
		}
	}
	
	public float angle0_360( float a ) {
		if( a >= 0 ) {
			return (float) ( a % ( 2.0d * Math.PI ) );			 
		} else {
			return (float) ( (2.0d * Math.PI ) - ( (-a) % ( 2.0d * Math.PI ) ) );
		}
	}
	
}
