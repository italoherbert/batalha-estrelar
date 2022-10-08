package batalhaestrelar.modules;

import batalhaestrelar.kernel.Kernel;
import batalhaestrelar.kernel.ModuleManager;
import batalhaestrelar.modules.gunrot.GunRotator;
import batalhaestrelar.modules.gunrot.NoneGunRotator;
import batalhaestrelar.modules.gunrot.RandomGunRotator;
import batalhaestrelar.modules.move.HorizontalMover;
import batalhaestrelar.modules.move.Mover;
import batalhaestrelar.modules.move.NoneMover;
import batalhaestrelar.modules.nave.gunrot.NaveGunRotator;
import batalhaestrelar.modules.nave.gunrot.NoneNaveGunRotator;
import batalhaestrelar.modules.nave.gunrot.RandomNaveGunRotator;
import batalhaestrelar.modules.nave.move.HorizontalNaveMover;
import batalhaestrelar.modules.nave.move.NaveMover;
import batalhaestrelar.modules.nave.move.NoneNaveMover;
import batalhaestrelar.modules.nave.shot.NoneShotCMD;
import batalhaestrelar.modules.nave.shot.RandomShotCMD;
import batalhaestrelar.modules.nave.shot.ShotCMD;
import batalhaestrelar.modules.positionator.group.GroupPositionator;
import batalhaestrelar.modules.positionator.group.NoneGroupPositionator;
import batalhaestrelar.modules.positionator.group.RandomByCellGroupPositionator;
import batalhaestrelar.modules.positionator.single.CellY2SinglePositionator;
import batalhaestrelar.modules.positionator.single.CenterCellSinglePositionator;
import batalhaestrelar.modules.positionator.single.NoneSinglePositionator;
import batalhaestrelar.modules.positionator.single.RandomSinglePositionator;
import batalhaestrelar.modules.positionator.single.SinglePositionator;

public class KModManager implements ModuleManager, ModuleDriver {

	private GroupPositionator randomByCellGroupPositionator = new RandomByCellGroupPositionator();
	private GroupPositionator noneGroupPositionator = new NoneGroupPositionator();
	
	private SinglePositionator randomSinglePositionator = new RandomSinglePositionator();
	private SinglePositionator y2CellSinglePositionator = new CellY2SinglePositionator();
	private SinglePositionator centerCellSinglePositionator = new CenterCellSinglePositionator();
	private SinglePositionator noneSinglePositionator = new NoneSinglePositionator();
	
	private ShotCMD randomShotCMD = new RandomShotCMD( this );
	private ShotCMD noneShotCMD = new NoneShotCMD();
		
	private GunRotator randomGunRotator = new RandomGunRotator();
	private GunRotator noneGunRotator = new NoneGunRotator();
	
	private NaveGunRotator randomNaveGunRotator = new RandomNaveGunRotator( this );
	private NaveGunRotator noneNaveGunRotator = new NoneNaveGunRotator();
	
	private Mover randomHorizontalMover = new HorizontalMover( this );
	private Mover noneMover = new NoneMover();
	
	private NaveMover randomHorizontalNaveMover = new HorizontalNaveMover( this );
	private NaveMover noneNaveMover = new NoneNaveMover();
	
	private ModuleDriver driver;	

	public KModManager( ModuleDriver driver ) {
		this.driver = driver;
	}

	public GroupPositionator getGroupPositionator(int type) {
		switch( type ) {
			case GroupPositionator.RANDOM_BY_CELL: return randomByCellGroupPositionator;
		}
		return noneGroupPositionator;
	}
	
	public SinglePositionator getSinglePositionator(int type) {
		switch( type ) {
			case SinglePositionator.RANDOM: return randomSinglePositionator;
			case SinglePositionator.CELL_Y2: return y2CellSinglePositionator;
			case SinglePositionator.CENTER: return centerCellSinglePositionator;
		}
		return noneSinglePositionator;
	}

	public ShotCMD getNaveGunshoot( int type ) {
		switch( type ) {
			case ShotCMD.RANDOM: return randomShotCMD;
		}
		return noneShotCMD;
	}

	public GunRotator getGunRotator( int type ) {
		switch( type ) {
			case GunRotator.RANDOM: return randomGunRotator;
		}
		return noneGunRotator;
	}

	public NaveGunRotator getNaveGunRotator( int type ) {
		switch( type ) {
			case NaveGunRotator.RANDOM: return randomNaveGunRotator;
		}
		return noneNaveGunRotator;
	}
	
	public Mover getMover(int type) {
		switch( type ) {
			case Mover.HORIZONTAL: return randomHorizontalMover;
		}
		return noneMover;
	}
	
	public NaveMover getNaveMover(int type) {
		switch( type ) {
			case NaveMover.HORIZONTAL: return randomHorizontalNaveMover;
		}
		return noneNaveMover;
	}

	public Kernel getKernel() {
		return driver.getKernel();
	}
	
}
