package italo.control;




public class ControlManagerInitializer<T extends ControlTO> {

	public void initialize( ControlSource source, Control<T> control, T to ) {
		this.initialize( null, source, control, to );
	}
	
	public void initialize( ControlSource base, ControlSource source, Control<T> control, T to ) {
		ControlManager<T> controlCM = new ControlManager<T>( control, to );
		
		source.setControl( controlCM );	
		if( base != null )
			base.getControl().addChild( controlCM );
	}
	
}
