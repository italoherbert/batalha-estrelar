package italo.control;

public interface InitControlListener {

	public void beforeInit( Control<? extends ControlTO> control );
	
	public void afterInit( Control<? extends ControlTO> control );
	
}
