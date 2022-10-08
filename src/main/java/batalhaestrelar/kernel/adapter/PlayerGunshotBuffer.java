package batalhaestrelar.kernel.adapter;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.gun.GunshotBuffer;

public class PlayerGunshotBuffer implements GunshotBuffer {

	private Fase fase;
	
	public PlayerGunshotBuffer(Fase fase) {
		this.fase = fase;
	}

	public Gunshot[] getOwnBuffer() {
		return fase.getPlayerGunshots();
	}

	public Gunshot[] getEnemiesBuffer() {
		return fase.getComputerGunshots();
	}

}
