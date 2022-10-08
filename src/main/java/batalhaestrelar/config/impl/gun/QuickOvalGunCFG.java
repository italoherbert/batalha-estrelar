package batalhaestrelar.config.impl.gun;

import batalhaestrelar.kernel.gun.GunConfig;
import batalhaestrelar.kernel.gun.GunConstants;

public class QuickOvalGunCFG implements GunConfig {

	private float gunshotPosFactor = 0.0f;
	private float gunshotPosIncFactor = 0.4f;
	private float gunshotWidthFactor = 0.8f;
	private float gunshotRadialFactor = 1.0f;
	private float gunshotDistFactor = 0.05f;	
	private boolean repeat = false;
	private int graphType = GunConstants.OVAL_GRAPH;

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
