package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.G2DUtilities;
import italo.g2dlib.g2d.shape.struct.InitStruct2D;
import italo.g2dlib.g2d.shape.struct.Struct2DDriver;
import italo.g2dlib.g2d.shape.struct.StructColorizer2D;
import italo.g2dlib.g2d.shape.struct.StructVisibility2D;
import italo.g2dlib.g2d.shape.struct.ViewStruct2D;
import italo.g2dlib.g2d.transform.Transform2D;
import italo.g2dlib.g2d.transform.TransformVectors2D;
import italo.g2dlib.g2d.vector.Vector2D;

import java.util.List;

public interface Shape2D extends Struct2DDriver {
	
	public void buildInit();
	
	public void buildView();
	
	public boolean activeVerify();
	
	public void addInitTransform( Transform2D transform );
	
	public void addViewTransform( Transform2D transform );
			
	public Vector2D getViewPosition();
	
	public InitStruct2D getInitStruct2D();
	
	public ViewStruct2D getViewStruct2D();
	
	public StructColorizer2D getColorizer2D();
	
	public StructVisibility2D getVisibility2D();

	public List<Transform2D> getInitTransforms();

	public List<Transform2D> getViewTransforms();
	
	public TransformVectors2D getInitTVectors();

	public TransformVectors2D getViewTVectors();
	
	public G2DUtilities getG2DUtilities();
	
	public void setG2DUtilities( G2DUtilities utils );
	
	public BaseShape2D getParent();
	
	public void setParent( BaseShape2D parent );

	public boolean isActive();
	
	public void setActive( boolean active );

	public boolean isVertexesVisible();

	public void setVertexesVisible( boolean vertexesVisible );

	public boolean isEdgesVisible();

	public void setEdgesVisible( boolean edgesVisible );

	public boolean isFacesVisible();

	public void setFacesVisible( boolean facesVisible );
		
	public void setBuildInitShape2DListener( BuildInitShape2DListener listener );
		
	public void setBuildViewShape2DListener( BuildViewShape2DListener listener );
	
	public void setPainterShape2DListener( PainterShape2DListener listener );
	
	
}
