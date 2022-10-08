package batalhaestrelar.modules.gunrot;

import batalhaestrelar.kernel.gun.Gun;

public class RandomGunRotator implements GunRotator {

	public void rotate( Gun gun, GunRotatorTO to ) {	
		if( !to.isExecIfShoting() )
			if( gun.getNave().isShoting() )
				return;
		
		int count = gun.getNave().getFase().getSession().getCounter().getCount();
		if( count % to.getInterval() == 0 ) {			
			if( to.getAngle() < -to.getAngleLimit() || to.getAngle() > to.getAngleLimit() ) {					
				if( to.isCycle() ) {
					if( to.getAngle() < -to.getAngleLimit() ) {
						to.setAngle( to.getAngleLimit() );
					} else {
						to.setAngle( -to.getAngleLimit() );
					}
				} else {
					to.setAngleIncrement( -to.getAngleIncrement() );						
				}
			} else if( to.getRandomDirectionInterval() != 0 ) {
				if( count % to.getRandomDirectionInterval() == 0 ) {
					int randomValue = (int)Math.round( Math.random() );
					if( randomValue == 1 )
						to.setAngleIncrement( -to.getAngleIncrement() );
				}
			}
			gun.setRotationAngle( to.getAngle() );
			to.setAngle( to.getAngle() + to.getAngleIncrement() );
		}		
	}

}
