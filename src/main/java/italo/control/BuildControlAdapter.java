package italo.control;

public abstract class BuildControlAdapter implements BuildControlListener {

	public void beforeBuild( Control<? extends ControlTO> control ) {}

	public void afterBuild( Control<? extends ControlTO> control ) {}

}
