package batalhaestrelar.config.impl.gun;

import batalhaestrelar.kernel.gun.GunConfig;
import batalhaestrelar.kernel.gun.GunConstants;

public class RepeatPolygGunCFG implements GunConfig {

	private float gunshotPosFactor = 0.0f;
	private float gunshotPosIncFactor = 0.0f;
	private float gunshotWidthFactor = 0.6f;
	private float gunshotRadialFactor = 3.0f;
	private float gunshotDistFactor = 1.0f;
	private boolean repeat = true;
	private int graphType = GunConstants.POLYGON_GRAPH;

	public float getGunshotPosFactor() {
		return gunshotPosFactor;
	}

	public float getGunshotPosIncFactor() {
		return gunshotPosIncFactor;
	}

	public float getGunshotWidthFactor() {
		return gunshotWidthFactor;
	}

	public float getGunshotRadialFactor() {
		return gunshotRadialFactor;
	}

	public float getGunshotDistFactor() {
		return gunshotDistFactor;
	}

	public boolean isRepeat() {
		return repeat;
	}
	
	public int getGraphType() {
		return graphType;
	}

}
