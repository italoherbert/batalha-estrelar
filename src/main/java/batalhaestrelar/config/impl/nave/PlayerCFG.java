package batalhaestrelar.config.impl.nave;

import batalhaestrelar.config.impl.gun.RepeatPolygGunCFG;
import batalhaestrelar.kernel.gun.GunConfig;
import batalhaestrelar.kernel.nave.player.PlayerConfig;
import batalhaestrelar.shape.nave.NaveShapeConstants;

public class PlayerCFG implements PlayerConfig {

	private int style = NaveShapeConstants.PLAYER_S1;
	private int colorStyle = NaveShapeConstants.COLOR_CONF_S1;
	private int energy = 3;

	private float width = 0.25f;
	private float height = 0.25f;

	private int distributeAngleInterval = 300;
	
	private float bonusDistributeAngle = (float)Math.toRadians( 30 );
	private int bonusEnergyIncrement = 3;	
	
	private int shotedInterval = 20;
	private int destroyedInterval = 20;

	private int energyIncInterval = 20;
	private int expandShotInterval = 20;

	private GunConfig gunConfig = new RepeatPolygGunCFG();

	public int getStyle() {
		return style;
	}

	public int getColorStyle() {
		return colorStyle;
	}

	public int getEnergy() {
		return energy;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public float getBonusDistributeAngle() {
		return bonusDistributeAngle;
	}

	public int getBonusEnergyIncrement() {
		return bonusEnergyIncrement;
	}

	public int getDistributeAngleInterval() {
		return distributeAngleInterval;
	}

	public int getShotedInterval() {
		return shotedInterval;
	}

	public int getDestroyedInterval() {
		return destroyedInterval;
	}

	public int getEnergyIncInterval() {
		return energyIncInterval;
	}

	public int getExpandShotInterval() {
		return expandShotInterval;
	}

	public GunConfig getGunConfig() {
		return gunConfig;
	}

}
