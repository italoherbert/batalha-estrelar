package italo.g2dlib.g2d.shape.struct;

import italo.g2dlib.g2d.shape.struct.edge.Edge2D;
import italo.g2dlib.g2d.shape.struct.face.Face2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;

import java.util.HashMap;
import java.util.Map;

public class InitStruct2D extends Struct2D {

	private Map<Vertex2D, Vertex2D> vertexesMap = new HashMap<Vertex2D, Vertex2D>();
	private boolean block = false;
	
	public InitStruct2D( Struct2DDriver shape ) {
		super( shape );
	}

	public ViewStruct2D newViewStruct() {
		while( block ) {
			synchronized( this ) {
				try {
					wait();
				} catch( InterruptedException e ) {
					
				}
			}
		}
		
		vertexesMap = new HashMap<Vertex2D, Vertex2D>();
				
		ViewStruct2D viewStruct = new ViewStruct2D( driver );
		
		for( Vertex2D vertex : vertexes ) {
			Vertex2D newV = new Vertex2D( vertex.getShape() );
			newV.setColorizer( vertex.getColorizer() );
			newV.setVisibility( vertex.getVisibility() );
			newV.setX( vertex.getX() );
			newV.setY( vertex.getY() );
			
			vertexesMap.put( vertex, newV );
			viewStruct.getVertexes().add( newV ); 
		}
		
		for( Edge2D edge : edges ) {
			Edge2D newE = new Edge2D( edge.getShape() );
			newE.setColorizer( edge.getColorizer() );
			newE.setVisibility( edge.getVisibility() );
			
			Vertex2D newV1 = vertexesMap.get( edge.getVertex1() );
			Vertex2D newV2 = vertexesMap.get( edge.getVertex2() );
			
			newE.setVertex1( newV1 );
			newE.setVertex2( newV2 );
			newV1.getEdges().add( newE );
			newV2.getEdges().add( newE );
			
			viewStruct.getEdges().add( newE );
		}
		
		for( Face2D face : faces ) {
			Face2D newF = new Face2D( face.getShape() );
			newF.setColorizer( face.getColorizer() );
			newF.setVisibility( face.getVisibility() );
			
			for( Vertex2D vertex : face.getVertexes() ) {
				Vertex2D newV = vertexesMap.get( vertex );
				
				newV.getFaces().add( newF );
				newF.getVertexes().add( newV );
			}
			
			viewStruct.getFaces().add( newF );
		}
		
		return viewStruct;
	}
	
	public Map<Vertex2D, Vertex2D> getVertexesMap() {
		return vertexesMap;
	}
	
	public void lock() {
		block = true;
	}
	
	public synchronized void unlock() {
		block = false;
		notify();
	}
	
}
