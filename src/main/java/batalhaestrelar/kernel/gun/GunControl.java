package batalhaestrelar.kernel.gun;

import italo.control.Control;

public class GunControl implements Control<GunControlTO> {

	private GunImpl gun;

	public void build( GunControlTO to ) {
		gun = (GunImpl)to.getGun();
		gun.setNave( to.getNave() );
		gun.setGunDriver( to.getGunDriver() );
		
		to.getNave().getGuns().add( gun );
	}

	public void init( GunControlTO to ) {
		gun.setGunshotPosFactor( to.getGunConfig().getGunshotPosFactor() );
		gun.setGunshotPosIncFactor( to.getGunConfig().getGunshotPosIncFactor() );
		gun.setGunshotWidthFactor( to.getGunConfig().getGunshotWidthFactor() );
		gun.setGunshotRadialFactor( to.getGunConfig().getGunshotRadialFactor() );
		gun.setGunshotDistFactor( to.getGunConfig().getGunshotDistFactor() );
		gun.setRepeat( to.getGunConfig().isRepeat() );
		gun.setGraphType( to.getGunConfig().getGraphType() );
		
		gun.setRotationAngle( 0 );
	}
	
}
