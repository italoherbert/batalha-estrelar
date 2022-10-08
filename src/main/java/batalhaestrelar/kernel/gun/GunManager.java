package batalhaestrelar.kernel.gun;

import batalhaestrelar.kernel.cam.Cam;



public class GunManager implements GunKernel {

	private GunMediator gunMT;

	public GunManager( GunMediator gunMT ) {
		this.gunMT = gunMT;
	}
	
	public Gunshot addGunshot( Gunshot[] buffer, Gun gun ) {
		return gunMT.addGunshot( buffer, gun );		
	}
		
	public void move( Gunshot gunshot ) {
		float radial = this.getGunshotPosIncRadial( gunshot.getGun() );
		float angle = this.getGunshotAngle( gunshot );
		this.move( gunshot, radial, angle );
	}
	
	public void move( Gunshot gunshot, float radial, float angle ) {
		gunMT.move( gunshot, radial, angle );
	}
	
	public float getGunshotAngle( Gunshot gunshot ) {
		return gunMT.getGunshotAngle( gunshot );
	}
	
	public float getGunshotPosRadial( Gun gun ) {
		return gunMT.getGunshotPosRadial( gun );
	}
	
	public float getGunshotPosIncRadial( Gun gun ) {
		return gunMT.getGunshotPosIncRadial( gun );
	}
	
	public float getGunshotDist( Gun gun ) {
		return gunMT.getGunshotDist( gun );
	}
	
	public float getGunshotWidth( Gun gun ) {
		return gunMT.getGunshotWidth( gun );
	}
	
	public float getGunshotRadial( Gun gun ) { 
		return gunMT.getGunshotRadial( gun );
	}
			
	public float[] interceptScreenPoint( Gunshot gunshot ) {
		Cam cam = gunshot.getGun().getNave().getFase().getGame().getCam();
		float sw = cam.getScreen().getScreenWidth();
		float sh = cam.getScreen().getScreenHeight();
		return gunMT.interceptScreenPoint( gunshot, sw, sh );
	}
	
	public float[][] gunshotPolygon( Gunshot gunshot ) {
		return gunMT.gunshotPolygon( gunshot );
	}
			
}
