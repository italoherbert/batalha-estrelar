package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.nave.player.Player;

public interface NaveKernel {
					
	public void addGunshotToAll( Nave nave );
	
	public Gunshot addGunshot( Nave nave, Gun gun );
	
	public Gun randomGun( Nave nave );
	
	public void updateDistributeGunsAngle( Player player );
	
	public void playerShotOn( Player player );
	
	public void playerShotOff( Player player );		
	
	public boolean isKilled( Nave nave );
						
	public void changeState( Nave nave, int state );
	
	public void changeNormalState( Player player, int state );
	
	public void updateState( Nave nave );

	public void updateNormalState( Player player );
	
	public void horizontalMoveInScreen( Player player );

	public void verticalMoveInScreen( Player player );
	
	public void leftMoveInScreen( Player player );
	
	public void rightMoveInScreen( Player player );
	
	public void upMoveInScreen( Player player );
	
	public void downMoveInScreen( Player player );
	
	public boolean horizontalMoveInFase( Nave nave, float inc );

	public boolean verticalMoveInFase( Nave nave, float inc );
	
	public boolean upMoveInFase( Nave nave, float inc );
	
	public boolean downMoveInFase( Nave nave, float inc );
	
	public boolean leftMoveInFase( Nave nave, float inc );
	
	public boolean rightMoveInFase( Nave nave, float inc );
	
}
