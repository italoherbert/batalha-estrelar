package batalhaestrelar.kernel;

import italo.control.ControlManager;
import italo.control.ControlTO;

public class AbstractGC implements GComponent {

	private ControlManager<? extends ControlTO> control;

	public ControlManager<? extends ControlTO> getControl() {
		return control;
	}

	public void setControl( ControlManager<? extends ControlTO> control ) {
		this.control = control;
	}
	
}
