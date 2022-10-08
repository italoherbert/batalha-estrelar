package batalhaestrelar.kernel.gun;

import italo.control.ControlManagerInitializer;
import batalhaestrelar.kernel.adapter.NaveGunAdapter;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.NaveShapeDriver;

public class GunInitializer {
		
	private ControlManagerInitializer<GunControlTO> cmInitializer = new ControlManagerInitializer<GunControlTO>();	

	public void initialize( GunConfig gunConfig, int index, Nave nave, NaveShapeDriver nshapeDrv ) {
		GunImpl gun = new GunImpl();
		
		GunControlVO vo = new GunControlVO();
		vo.setGunConfig( gunConfig );
		vo.setGun( gun );
		vo.setNave( nave );
		vo.setGunDriver( new NaveGunAdapter( nave, index ) );
		
		GunControl control = new GunControl();
		cmInitializer.initialize( nave, gun, control, vo );
		
		nshapeDrv.getGunRotations()[ index ] = gun;
	}
	
}
