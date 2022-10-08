package batalhaestrelar.kernel.gun;

import batalhaestrelar.kernel.Math2DSourceDriver;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.NaveShape;
import batalhaestrelar.math.Math2D;

public class GunMediator {
	
	private Math2DSourceDriver driver;	
	
	public GunMediator(Math2DSourceDriver driver) {
		this.driver = driver;
	}

	public Gunshot addGunshot( Gunshot[] buffer, Gun gun ) {
		Gunshot gunshot = null;
		for( int i = 0; gunshot == null && i < buffer.length; i++ ) {
			Gunshot gs = buffer[ i ];
			if( !gs.isActive() ) {
				gs.setGun( gun );
				this.initGunshot( gs );
				
				gunshot = gs;
			}
		}
		return gunshot;		
	}
	
	public void initGunshot( Gunshot gunshot ) {
		Gun gun = gunshot.getGun();
		
		float radial = gunshot.getGun().getRadial();
		float angle = gun.getAngle() + gun.getRotationAngle();
		float[] p = driver.getMath().coordinate( radial, angle ); 				
		gunshot.setX( p[0] );
		gunshot.setY( p[1] ); 
		gunshot.setAngle( gun.getRotationAngle() );
		gunshot.setGun( gun );
		gunshot.setActive( true );
		
		if( !gun.isRepeat() ) {
			gunshot.setGunAbsX( gun.getAbsX() );
			gunshot.setGunAbsY( gun.getAbsY() );
		}
		
		float positionRadial = this.getGunshotPosRadial( gun );
		this.move( gunshot, positionRadial, angle );		
	}
	
	public void move( Gunshot gunshot, float radial, float angle ) {		
		float[] p = driver.getMath().coordinate( radial, angle );
		gunshot.setX( gunshot.getX() + p[0] );
		gunshot.setY( gunshot.getY() + p[1] );
	}
	
	public Gunshot shotedNaveVerify( Nave nave ) {
		Gunshot[] gunshots = nave.getGunshotBuffer().getEnemiesBuffer();
		for( Gunshot gs : gunshots ) {
			if( !gs.isActive() )
				continue;
			if( this.colision( gs, nave ) )
				return gs;						
		}
		return null;
	}
	
	public boolean colision( Gunshot gunshot, Nave nave ) {
		NaveShape ns = nave.getShape();
		
		float gsRadial = this.getGunshotRadial( gunshot.getGun() );
		float gsWidth = this.getGunshotWidth( gunshot.getGun() );
		float gsAngle = this.getGunshotAngle( gunshot );
		float gsx1 = gunshot.getCamX() - gsWidth*.5f;
		float gsy1 = gunshot.getCamY();
		
		float gsx2;
		float gsy2;				
		if( gunshot.getGun().isRepeat() ) {
			float sw = nave.getFase().getGame().getCam().getScreen().getScreenWidth();
			float sh = nave.getFase().getGame().getCam().getScreen().getScreenHeight();
			
			float[] gsP = driver.getMath().interceptRectPoint( gsx1, gsy1, -sw*.5f, -sh*.5f, sw*.5f, sh*.5f, gsAngle );
			gsx2 = gsP[0] + gsWidth;
			gsy2 = gsP[1];					
		} else {
			float[] gsP = driver.getMath().coordinate( gsRadial, gsAngle );
			gsx2 = gsx1 + gsP[0] + gsWidth;
			gsy2 = gsy1 + gsP[1];					
		}
				
		float nx1 = nave.getCamX() - ns.getWidth()*.5f;
		float ny1 = nave.getCamY() - ns.getHeight()*.5f;
		float nx2 = nave.getCamX() + ns.getWidth()*.5f;
		float ny2 = nave.getCamY() + ns.getHeight()*.5f;
				
		float minNX = Math.min( nx1, nx2 ); 
		float maxNX = Math.max( nx1, nx2 );				
		float minNY = Math.min( ny1, ny2 );
		float maxNY = Math.max( ny1, ny2 );					
		
		float minGSX = Math.min( gsx1, gsx2 ); 
		float maxGSX = Math.max( gsx1, gsx2 );				
		float minGSY = Math.min( gsy1, gsy2 ); 
		float maxGSY = Math.max( gsy1, gsy2 );				
		
		if( gunshot.getGun().isRepeat() ) {
			if( maxNX < minGSX )
				return false;
			if( maxNY < minGSY )
				return false;
			if( minNX >= maxGSX )
				return false;
			if( minNY >= maxGSY )
				return false;			
			
			float ix1 = driver.getMath().calculateX2ByAngle( gsx1, gsy1, ny1, gsAngle );		
			if( ( (ix1-gsWidth) >= minNX && (ix1-gsWidth) <= maxNX ) || ( (ix1+gsWidth) >= minNX && (ix1+gsWidth) <= maxNX ) )
				return true;
			
			float ix2 = driver.getMath().calculateX2ByAngle( gsx1, gsy1, ny2, gsAngle );
			if( ( (ix2-gsWidth) >= minNX && (ix2-gsWidth) <= maxNX ) || ( (ix2+gsWidth) >= minNX && (ix2+gsWidth) <= maxNX ) )
				return true;
			
			return false;		
		} else {
			if( maxGSX < minNX )
				return false;
			if( maxGSY < minNY )
				return false;
			if( minGSX >= maxNX )
				return false;		
			if( minGSY >= maxNY )
				return false;						
			return true;
		}
	}
		
	public float[] interceptScreenPoint( Gunshot gunshot, float sw, float sh ) {
		float bx = gunshot.getCamX();
		float by = gunshot.getCamY(); 
		float angle = this.getGunshotAngle( gunshot );
		float x1 = -sw*.5f;
		float y1 = -sh*.5f;
		float x2 =  sw*.5f;
		float y2 =  sh*.5f;
		
		return driver.getMath().interceptRectPoint( bx, by, x1, y1, x2, y2, angle );
	}
		
	public float[][] gunshotPolygon( Gunshot gunshot ) {
		float x = gunshot.getCamX(); 
		float y = gunshot.getCamY(); 
		float rotAngle = gunshot.getGun().getRotationAngle();
		float w = this.getGunshotWidth( gunshot.getGun() );					
		float r = this.getGunshotRadial( gunshot.getGun() );
		float angle = this.getGunshotAngle( gunshot );
		
		float[] rp = driver.getMath().coordinate( r, angle );
		
		float[] p1 = {  w*.5f, 0 };
		float[] p2 = { -w*.5f, 0 };
		
		driver.getMath().rotate( p1, rotAngle );
		driver.getMath().rotate( p2, rotAngle );
		
		return new float[][] {
			{ x + p2[0], y + p2[1] },
			{ x + p1[0], y + p1[1] },
			{ x + rp[0] + p1[0], y + rp[1] + p1[1] },
			{ x + rp[0] + p2[0], y + rp[1] + p2[1] }
		};
	}
		
	public float getGunshotAngle( Gunshot gunshot ) {
		return gunshot.getGun().getAngle() + gunshot.getAngle();
	}
		
	public float getGunshotPosRadial( Gun gun ) {
		return gun.getGunshotPosFactor() * gun.getWidth();
	}
	
	public float getGunshotPosIncRadial( Gun gun ) {
		return gun.getGunshotPosIncFactor() * gun.getWidth();
	}
	
	public float getGunshotWidth( Gun gun ) {
		return gun.getGunshotWidthFactor() * gun.getWidth();
	}
	
	public float getGunshotRadial( Gun gun ) {
		return gun.getGunshotRadialFactor() * gun.getWidth();
	}
	
	public float getGunshotDist( Gun gun ) {
		return gun.getGunshotDistFactor() * gun.getWidth();
	}

	public Math2D getMath() {
		return driver.getMath();
	}		
	
}
