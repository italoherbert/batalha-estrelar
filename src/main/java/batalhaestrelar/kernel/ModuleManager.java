package batalhaestrelar.kernel;

import batalhaestrelar.modules.gunrot.GunRotator;
import batalhaestrelar.modules.move.Mover;
import batalhaestrelar.modules.nave.gunrot.NaveGunRotator;
import batalhaestrelar.modules.nave.move.NaveMover;
import batalhaestrelar.modules.nave.shot.ShotCMD;
import batalhaestrelar.modules.positionator.group.GroupPositionator;
import batalhaestrelar.modules.positionator.single.SinglePositionator;

public interface ModuleManager {
		
	public GroupPositionator getGroupPositionator( int type );
	
	public SinglePositionator getSinglePositionator( int type );

	public ShotCMD getNaveGunshoot( int type );

	public GunRotator getGunRotator( int type );
	
	public NaveGunRotator getNaveGunRotator( int type );
	
	public Mover getMover( int type );
	
	public NaveMover getNaveMover( int type );

}
