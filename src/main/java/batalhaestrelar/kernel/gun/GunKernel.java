package batalhaestrelar.kernel.gun;



public interface GunKernel {

	public Gunshot addGunshot( Gunshot[] buffer, Gun gun );
	
	public void move( Gunshot gunshot );
	
	public void move( Gunshot gunshot, float radial, float angle );		
		
	public float[] interceptScreenPoint( Gunshot gunshot );
	
	public float[][] gunshotPolygon( Gunshot gunshot );

	public float getGunshotAngle( Gunshot gunshot );

	public float getGunshotPosRadial( Gun gun );
	
	public float getGunshotPosIncRadial( Gun gun );
	
	public float getGunshotDist( Gun gun );

	public float getGunshotWidth( Gun gun );
	
	public float getGunshotRadial( Gun gun );
	
}
