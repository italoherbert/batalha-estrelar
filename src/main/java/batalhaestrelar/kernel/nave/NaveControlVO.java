package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.gun.GunshotBuffer;

public class NaveControlVO implements NaveControlTO {

	private NaveConfig naveConfig;

	private Nave nave;
	private Fase fase;
	private NaveShape shape;
	private GunshotBuffer gunshotBuffer;

	public NaveConfig getNaveConfig() {
		return naveConfig;
	}

	public void setNaveConfig(NaveConfig naveConfig) {
		this.naveConfig = naveConfig;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public NaveShape getShape() {
		return shape;
	}

	public void setShape(NaveShape shape) {
		this.shape = shape;
	}

	public GunshotBuffer getGunshotBuffer() {
		return gunshotBuffer;
	}

	public void setGunshotBuffer(GunshotBuffer gunshotBuffer) {
		this.gunshotBuffer = gunshotBuffer;
	}

}
