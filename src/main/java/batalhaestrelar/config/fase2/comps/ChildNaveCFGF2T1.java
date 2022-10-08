package batalhaestrelar.config.fase2.comps;

import batalhaestrelar.config.impl.gun.QuickOvalGunCFG;
import batalhaestrelar.config.impl.gun.rot.CyclicGunRotCFG;
import batalhaestrelar.config.impl.gun.shot.ShortSleepShotCFG;
import batalhaestrelar.kernel.gun.GunConfig;
import batalhaestrelar.kernel.gun.GunRotatorConfig;
import batalhaestrelar.kernel.gun.ShotConfig;
import batalhaestrelar.kernel.nave.NaveMoverConfig;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.ComputerConfig;
import batalhaestrelar.modules.gunrot.GunRotator;
import batalhaestrelar.modules.move.Mover;
import batalhaestrelar.modules.nave.shot.ShotCMD;
import batalhaestrelar.modules.positionator.group.GroupPositionator;
import batalhaestrelar.modules.positionator.single.SinglePositionator;
import batalhaestrelar.shape.nave.NaveShapeConstants;

public class ChildNaveCFGF2T1 implements ComputerConfig {

	private int type = Computer.CHILD;	
	private int style = NaveShapeConstants.CHILD_S2;
	private int colorStyle = NaveShapeConstants.COLOR_CONF_S1;
	private int quantity = 25;
		
	private int[] translateIndexes = null;	
	private float[][] translationValues = null;
	
	private int energy = 1;
	private boolean shotOnlyIfSelected = true;
	
	private float width = 0.1f;
	private float height = 0.1f;

	private int shotedInterval = 20;
	private int destroyedInterval = 20;
	
	private int singlePosCellNumber = 0;
	
	private int groupPositionatorType = GroupPositionator.RANDOM_BY_CELL;
	private int singlePositionatorType = SinglePositionator.NONE;
	private int moverType = Mover.NONE;
	private int shotType = ShotCMD.RANDOM;
	private int gunRotatorType = GunRotator.RANDOM;

	private ShotConfig shotConfig = new ShortSleepShotCFG();
	private GunConfig gunConfig = new QuickOvalGunCFG();
	private GunRotatorConfig gunRotatorConfig = new CyclicGunRotCFG();

	public int getType() {
		return type;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public int getSinglePosCellNumber() {
		return singlePosCellNumber;
	}

	public int getStyle() {
		return style;
	}

	public int getColorStyle() {
		return colorStyle;
	}

	public int getEnergy() {
		return energy;
	}
	
	public boolean isShotOnlyIfSelected() {
		return shotOnlyIfSelected;
	}
	
	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public int getShotedInterval() {
		return shotedInterval;
	}

	public int getDestroyedInterval() {
		return destroyedInterval;
	}

	public int getGroupPositionatorType() {
		return groupPositionatorType;
	}

	public int getSinglePositionatorType() {
		return singlePositionatorType;
	}

	public int getMoverType() {
		return moverType;
	}

	public int getShotType() {
		return shotType;
	}

	public int getGunRotatorType() {
		return gunRotatorType;
	}
	
	public ShotConfig getShotConfig() {
		return shotConfig;
	}

	public GunConfig getGunConfig() {
		return gunConfig;
	}

	public GunRotatorConfig getGunRotatorConfig() {
		return gunRotatorConfig;
	}

	public NaveMoverConfig getMoverConfig() {
		return null;
	}
	
	public void setShapeStyle( int style ) {
		this.style = style;
	}

	public int[] getTranslationIndexes() {
		return translateIndexes;
	}

	public float[][] getTranslationValues() {
		return translationValues;
	}

}
