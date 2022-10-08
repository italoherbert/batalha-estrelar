package batalhaestrelar.config.fase2.comps;

import batalhaestrelar.config.impl.gun.QuickOvalGunCFG;
import batalhaestrelar.config.impl.gun.rot.OccilationGunRotCFG;
import batalhaestrelar.config.impl.gun.shot.LongSleepShotCFG;
import batalhaestrelar.config.impl.mover.QuickNaveMoverCFG;
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

public class MotherNaveCFGF2T3 implements ComputerConfig {

	private int type = Computer.MOTHER;
	private int style = NaveShapeConstants.MOTHER_S1;
	private int colorStyle = NaveShapeConstants.COLOR_CONF_S1;
	private int quantity = 2;
	
	private int[] translateIndexes = { 0, 1 };
	
	private float[][] translationValues = {
		{  0.6f,  0.5f },
		{ -0.6f,  0.5f }
	};
	
	private int singlePosCellNumber = 7; 
	
	private int singlePositionatorType = SinglePositionator.CENTER;
	private int groupPositionatorType = GroupPositionator.NONE;
	
	private int energy = 12;
	private boolean shotOnlyIfSelected = false;

	private float width = 0.5f;
	private float height = 0.5f;

	private int shotedInterval = 30;
	private int destroyedInterval = 20;

	private int moverType = Mover.HORIZONTAL;
	private int shotType = ShotCMD.RANDOM;
	private int gunRotatorType = GunRotator.RANDOM;

	private GunConfig gunConfig = new QuickOvalGunCFG();
	private NaveMoverConfig moverConfig = new QuickNaveMoverCFG( true );
	private ShotConfig shotConfig = new LongSleepShotCFG();
	private GunRotatorConfig gunRotatorConfig = new OccilationGunRotCFG();

	public int getType() {
		return type;
	}
	
	public int getStyle() {
		return style;
	}

	public int getColorStyle() {
		return colorStyle;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSinglePosCellNumber() {
		return singlePosCellNumber;
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

	public NaveMoverConfig getMoverConfig() {
		return moverConfig;
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

	public int[] getTranslationIndexes() {
		return translateIndexes;
	}

	public float[][] getTranslationValues() {
		return translationValues;
	}
	
}
