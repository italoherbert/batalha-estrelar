package italo.control;

public interface BuildControlListener {

	public void beforeBuild( Control<? extends ControlTO> control );
	
	public void afterBuild( Control<? extends ControlTO> control );
	
}
