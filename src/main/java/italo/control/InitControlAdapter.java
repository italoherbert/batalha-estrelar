package italo.control;

public abstract class InitControlAdapter implements InitControlListener {

	public void beforeInit( Control<? extends ControlTO> control ) {}
	public void afterInit( Control<? extends ControlTO> control ) {}

}
