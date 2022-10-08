package italo.g2dlib.g2d.shape.geom;

import italo.g2dlib.g2d.shape.struct.Struct2D;
import italo.g2dlib.g2d.shape.struct.StructColorizer2D;
import italo.g2dlib.g2d.shape.struct.StructVisibility2D;
import italo.g2dlib.g2d.shape.struct.edge.Edge2D;
import italo.g2dlib.g2d.shape.struct.face.Face2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;

public class Geom2DBuilder {

	public Geom2D buildLosangGeom( float x1, float y1, float x2, float y2 ) {
		float[][] verts = {
			{ x1 + (x2-x1)*.5f, y1 },
			{ x1 + (x2-x1), y1 + (y2-y1)*.5f },
			{ x1 + (x2-x1)*.5f, y1 + (y2-y1) },
			{ x1, y1 + (y2-y1)*.5f },
		};				
		return this.buildPolygonGeom( verts );
	}
	
	public Geom2D buildRegularPolygonGeom( float x, float y, float r, int nsides ) {
		float[][] verts = new float[ nsides ][ 2 ];
		double angle = ( 2.0d * Math.PI ) / nsides;
		for( int i = 0; i < nsides; i++ ) {
			verts[ i ][ 0 ] = (float)( r * Math.cos( angle * i ) );
			verts[ i ][ 1 ] = (float)( r * Math.sin( angle * i ) );
		}
		return this.buildPolygonGeom( verts );
	}
	
	public Geom2D buildRectGeom( float x1, float y1, float x2, float y2 ) {
		float[][] verts = {
			{ x1, y1 },
			{ x2, y1 },
			{ x2, y2 },
			{ x1, y2 },
		};				
		return this.buildPolygonGeom( verts ); 
	}
	
	public Geom2D buildPolygonGeom( float[][] verts ) {
		int[][] edges = new int[ verts.length ][ 2 ];
		int[][] faces = new int[ 1 ][ verts.length ];
		for( int i = 0; i < verts.length; i++ ) {
			edges[ i ][ 0 ] = i;
			edges[ i ][ 1 ] = (i+1) % verts.length;
			faces[ 0 ][ i ] = i;
		}
		return new Geom2D( verts, edges, faces );
	}

	public void addGeomToStruct( Struct2D struct, Geom2D geom ) {
		this.addGeomToStruct( struct, geom, null, null );
	}
	
	public void addGeomToStruct( Struct2D struct, Geom2D geom, StructColorizer2D colorizer ) {
		this.addGeomToStruct( struct, geom, colorizer, null );
	}
	
	public void addGeomToStruct( Struct2D struct, Geom2D geom, StructVisibility2D visibility ) {
		this.addGeomToStruct( struct, geom, null, visibility );
	}
	
	public void addGeomToStruct( Struct2D struct, Geom2D geom, StructColorizer2D colorizer, StructVisibility2D visibility ) {
		int vsize = struct.getVertexes().size();
		
		float[][] vertexes = geom.getVertexes();
		int[][] edges = geom.getEdges();
		int[][] faces =  geom.getFaces();
		
		for( float[] v : vertexes ) {
			Vertex2D vertex = new Vertex2D( struct.getShape(), v[0], v[1] );
			vertex.setColorizer( colorizer );
			vertex.setVisibility( visibility );
			struct.getVertexes().add( vertex );
		}
		
		for( int[] e : edges ) {		
			Vertex2D v1 = struct.getVertexes().get( vsize + e[0] );
			Vertex2D v2 = struct.getVertexes().get( vsize + e[1] );
			
			Edge2D edge = new Edge2D( struct.getShape() );
			edge.setColorizer( colorizer );
			edge.setVisibility( visibility );
			edge.setVertex1( v1 );
			edge.setVertex2( v2 );
			
			v1.getEdges().add( edge );
			v2.getEdges().add( edge );
			
			struct.getEdges().add( edge );
		}
		
		for( int[] f : faces ) {
			Face2D face = new Face2D( struct.getShape() );
			face.setColorizer( colorizer );
			face.setVisibility( visibility );
			for( int i : f ) {
				Vertex2D v = struct.getVertexes().get( vsize + i );
				v.getFaces().add( face );				
				face.getVertexes().add( v );
			}
			struct.getFaces().add( face );
		}		
	}
	
}
