package batalhaestrelar.kernel.adapter;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.gun.GunshotBuffer;

public class ComputerGunshotBuffer implements GunshotBuffer {

	private Fase fase;
	
	public ComputerGunshotBuffer( Fase fase ) {
		this.fase = fase;
	}

	public Gunshot[] getOwnBuffer() {
		return fase.getComputerGunshots();
	}

	public Gunshot[] getEnemiesBuffer() {
		return fase.getPlayerGunshots();
	}

}