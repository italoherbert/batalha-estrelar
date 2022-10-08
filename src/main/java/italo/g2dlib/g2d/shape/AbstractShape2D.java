package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.G2DUtilities;
import italo.g2dlib.g2d.painter.PainterShape2D;
import italo.g2dlib.g2d.painter.Proj2D;
import italo.g2dlib.g2d.shape.geom.Geom2DBuilder;
import italo.g2dlib.g2d.shape.geom.GeomColorizer2D;
import italo.g2dlib.g2d.shape.geom.GeomVisibility2D;
import italo.g2dlib.g2d.shape.struct.InitStruct2D;
import italo.g2dlib.g2d.shape.struct.StructColorizer2D;
import italo.g2dlib.g2d.shape.struct.StructVisibility2D;
import italo.g2dlib.g2d.shape.struct.ViewStruct2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;
import italo.g2dlib.g2d.transform.Transform2D;
import italo.g2dlib.g2d.transform.TransformVectors2D;
import italo.g2dlib.g2d.vector.Vector2D;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShape2D implements Shape2D, PainterShape2D {

	private BaseShape2D parent = null;
	private G2DUtilities utils = null;
	
	private InitStruct2D initStruct = new InitStruct2D( this );
	private ViewStruct2D viewStruct = new ViewStruct2D( this );
	
	private List<Transform2D> initTransforms = new ArrayList<Transform2D>();
	private List<Transform2D> viewTransforms = new ArrayList<Transform2D>();
	
	private TransformVectors2D initTVectors = new TransformVectors2D();
	private TransformVectors2D viewTVectors = new TransformVectors2D();
	
	private StructColorizer2D colorizer = new GeomColorizer2D();
	private StructVisibility2D visibility = new GeomVisibility2D();
	
	private boolean active = true;
	private boolean vertexesVisible = false;
	private boolean edgesVisible = true;
	private boolean facesVisible = true;
	
	private boolean building = false;
		
	private BuildInitShape2DListener buildInitListener = new BuildInitShape2DAdapter() {};
	private BuildViewShape2DListener buildViewListener = new BuildViewShape2DAdapter() {};	
	private PainterShape2DListener painterListener = new PainterShape2DAdapter() {};
	
	public abstract void buildShape( Geom2DBuilder gb );
	
	public void beforePaint(Graph2D g2D, Graph g, Proj2D proj) {}
	public void afterPaint(Graph2D g2D, Graph g, Proj2D proj) {}
	public boolean activeCondition() { return true; }

	public boolean activeVerify() {
		return active && activeCondition();
	}

	public void buildInit() {
		building = true;
		initStruct.lock();

		buildInitListener.beforeBuildInit( this );
		
		this.buildShape( utils.getGBuilder() );
		
		initTVectors.reinit();						
		utils.getTransformer().buildTransformVectors( initTVectors, initTransforms );
		for( Vertex2D v : initStruct.getVertexes() ) {
			utils.getTransformer().getRotator().transform( initTVectors.getRotation(), v );
			utils.getTransformer().getScaller().transform( initTVectors.getScale(), v );
			utils.getTransformer().getTranslator().transform( initTVectors.getTranslation(), v );
		}
		
		buildInitListener.afterBuildInit( this );		

		initStruct.unlock();
		building = false;
	}
	
	public void buildView() {		
		buildViewListener.beforeBuildView( this );
		
		viewStruct = initStruct.newViewStruct();
		
		viewTVectors.reinit();
		utils.getTransformer().buildTransformVectors( viewTVectors, viewTransforms );
				
		if( parent != null ) {
			utils.getTransformer().getRotator().transform( parent.getViewTVectors().getRotation(), viewTVectors.getTranslation() );
			utils.getTransformer().getScaller().transform( parent.getViewTVectors().getScale(), viewTVectors.getTranslation() );
			utils.getVMath().add( viewTVectors.getTranslation(), parent.getViewTVectors().getTranslation() );
			utils.getVMath().mul( viewTVectors.getScale(), parent.getViewTVectors().getScale() );
		}
		
		for( Vertex2D v : viewStruct.getVertexes() ) {
			utils.getTransformer().getRotator().transform( viewTVectors.getRotation(), v );
			utils.getTransformer().getScaller().transform( viewTVectors.getScale(), v );
			utils.getTransformer().getTranslator().transform( viewTVectors.getTranslation(), v );
		}
		
		buildViewListener.afterBuildView( this );
	}
	
	public boolean isBuilding() {
		return building;
	}

	public void addInitTransform( Transform2D transform ) {
		initTransforms.add( transform );
	}
	
	public void addViewTransform( Transform2D transform ) {
		viewTransforms.add( transform );
	}
	
	public PainterShape2DListener getPainterShape2DListener() {
		return painterListener;
	}
	
	public void setBuildInitShape2DListener( BuildInitShape2DListener listener ) {
		this.buildInitListener = listener;
	}
	
	public void setBuildViewShape2DListener( BuildViewShape2DListener listener ) {
		this.buildViewListener = listener;
	}	
		
	public void setPainterShape2DListener( PainterShape2DListener listener ) {
		this.painterListener = listener;
	}
	
	public Vector2D getViewPosition() {
		return viewTVectors.getTranslation(); 
	}

	public TransformVectors2D getInitTVectors() {
		return initTVectors;
	}
	
	public TransformVectors2D getViewTVectors() {
		return viewTVectors;
	}
	
	public List<Transform2D> getInitTransforms() {
		return initTransforms;
	}

	public List<Transform2D> getViewTransforms() {
		return viewTransforms;
	}

	public G2DUtilities getG2DUtilities() {
		return utils;
	}

	public void setG2DUtilities( G2DUtilities utils ) {
		this.utils = utils;
	}

	public BaseShape2D getParent() {
		return parent;
	}

	public void setParent( BaseShape2D parent ) {
		this.parent = parent;
	}

	public InitStruct2D getInitStruct2D() {
		return initStruct;
	}

	public ViewStruct2D getViewStruct2D() {
		return viewStruct;
	}
	
	public StructColorizer2D getColorizer2D() {
		return colorizer;
	}

	public StructVisibility2D getVisibility2D() {
		return visibility;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean visible) {
		this.active = visible;
	}

	public boolean isVertexesVisible() {
		return vertexesVisible;
	}

	public void setVertexesVisible(boolean vertexesVisible) {
		this.vertexesVisible = vertexesVisible;
	}

	public boolean isEdgesVisible() {
		return edgesVisible;
	}

	public void setEdgesVisible(boolean edgesVisible) {
		this.edgesVisible = edgesVisible;
	}

	public boolean isFacesVisible() {
		return facesVisible;
	}

	public void setFacesVisible(boolean facesVisible) {
		this.facesVisible = facesVisible;
	}

}
