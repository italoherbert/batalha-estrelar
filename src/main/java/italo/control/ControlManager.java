package italo.control;

import java.util.ArrayList;
import java.util.List;

public class ControlManager<T extends ControlTO> {

	private Control<T> control;
	private List<ControlManager<? extends ControlTO>> childs = new ArrayList<ControlManager<? extends ControlTO>>();

	private BuildControlListener buildListener = new BuildControlAdapter() {};
	private InitControlListener initListener = new InitControlAdapter() {};
	
	private T to;
	
	private boolean initializing;
	private boolean building;
	
	private boolean initialized;
	private boolean builded;
	
	public ControlManager( Control<T> control, T to ) { 
		this.control = control;
		this.to = to;
	}
	
	protected void beforeBuild() {}
	protected void afterBuild() {}
	
	protected void beforeInit() {}
	protected void afterInit() {}
	
	public void build( boolean recursive ) {		
		buildListener.beforeBuild( control );		
		this.beforeBuild();		
		building = true;
		
		control.build( to );
		if( recursive )
			for( ControlManager<? extends ControlTO> child : childs )
				child.build( true );
		
		building = false;
		builded = true;
		this.afterBuild();		
		buildListener.afterBuild( control );
	}

	public void init( boolean recursive ) {		
		initListener.beforeInit( control );		
		this.beforeInit();		
		initializing = true;
		
		control.init( to );
		if( recursive )
			for( ControlManager<? extends ControlTO> child : childs )
				child.init( true );
		
		initializing = false;
		initialized = true;		
		this.afterInit();				
		initListener.afterInit( control );
	}	
	
	public boolean isInitializing() {
		return initializing;
	}

	public boolean isBuilding() {
		return building;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public boolean isBuilded() {
		return builded;
	}

	public void addChild( ControlManager<? extends ControlTO> child ) {
		childs.add( child );
	}
	
	public List<ControlManager<? extends ControlTO>> getChilds() {
		return childs;
	}
		
	public void setInitControlListener( InitControlListener listener ) {
		this.initListener = listener;
	}
	
	public void setBuildControlListener( BuildControlListener listener ) {
		this.buildListener = listener;
	}	

	public Control<T> getControl() {
		return control;
	}

	public void setControl(Control<T> control) {
		this.control = control;
	}
		
}
