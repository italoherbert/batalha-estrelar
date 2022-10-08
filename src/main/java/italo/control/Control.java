package italo.control;


public interface Control<T extends ControlTO> {
		
	public void build( T to );
	
	public void init( T to );
		
}
