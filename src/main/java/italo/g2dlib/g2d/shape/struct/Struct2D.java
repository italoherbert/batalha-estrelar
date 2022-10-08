package italo.g2dlib.g2d.shape.struct;

import italo.g2dlib.g2d.shape.struct.edge.Edge2D;
import italo.g2dlib.g2d.shape.struct.face.Face2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;

import java.util.ArrayList;
import java.util.List;

public abstract class Struct2D {

	protected List<Vertex2D> vertexes = new ArrayList<Vertex2D>();
	protected List<Edge2D> edges = new ArrayList<Edge2D>();
	protected List<Face2D> faces = new ArrayList<Face2D>();
	protected Struct2DDriver driver;
		
	public Struct2D( Struct2DDriver shape ) {
		this.driver = shape;
	}
	
	public StructShape2D getShape() {
		return driver;
	}

	public List<Vertex2D> getVertexes() {
		return vertexes;	
	}
	
	public List<Edge2D> getEdges() {
		return edges;
	}
	
	public List<Face2D> getFaces() {
		return faces;
	}
	
}
