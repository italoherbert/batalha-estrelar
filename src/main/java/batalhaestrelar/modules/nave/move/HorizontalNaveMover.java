package batalhaestrelar.modules.nave.move;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.modules.ModuleDriver;
import batalhaestrelar.modules.move.Mover;
import batalhaestrelar.modules.move.HorizontalMover;

public class HorizontalNaveMover implements NaveMover {
	
	private Mover mover;
	
	public HorizontalNaveMover( ModuleDriver driver ) {
		this.mover = new HorizontalMover( driver );
	}

	public void move( Fase fase, Nave nave, NaveMoverTO to ) {
		if( !to.isExecIfShoting() )
			if( nave.isShoting() )
				return;
		
		mover.move( fase, nave, to );
	}

}
