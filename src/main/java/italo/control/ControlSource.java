package italo.control;

public interface ControlSource {

	public ControlManager<? extends ControlTO> getControl();
	
	public void setControl( ControlManager<? extends ControlTO> control );
	
}
