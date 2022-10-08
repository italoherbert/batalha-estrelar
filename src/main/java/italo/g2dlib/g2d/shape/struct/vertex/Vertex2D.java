package italo.g2dlib.g2d.shape.struct.vertex;

import italo.g2dlib.g2d.shape.struct.StructShape2D;
import italo.g2dlib.g2d.shape.struct.edge.Edge2D;
import italo.g2dlib.g2d.shape.struct.face.Face2D;
import italo.g2dlib.g2d.vector.Vector2D;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Vertex2D extends Vector2D {
	
	private List<Edge2D> edges = new ArrayList<Edge2D>();
	private List<Face2D> faces = new ArrayList<Face2D>();
	private StructShape2D shape = null;
	private VertexColorizer2D colorizer = null;
	private VertexVisibility2D visibility = null;
	
	public Vertex2D( StructShape2D shape ) {
		this( shape, 0, 0 );
	}
	
	public Vertex2D( StructShape2D shape, float x, float y ) {		
		this.shape = shape;
		super.setX( x );
		super.setY( y );
	}
		
	public boolean isDraw() {
		return visibility == null ? shape.getVisibility2D().isDrawVertex() : visibility.isDrawVertex();
	}

	public Color getColor() {
		return colorizer == null ? shape.getColorizer2D().getVertexColor() : colorizer.getVertexColor();
	}
	
	public VertexColorizer2D getColorizer() {
		return colorizer;
	}

	public void setColorizer( VertexColorizer2D vcolor ) {
		this.colorizer = vcolor;
	}

	public VertexVisibility2D getVisibility() {
		return visibility;
	}

	public void setVisibility( VertexVisibility2D visibility ) {
		this.visibility = visibility;
	}

	public StructShape2D getShape() {
		return shape;
	}

	public List<Edge2D> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge2D> edges) {
		this.edges = edges;
	}

	public List<Face2D> getFaces() {
		return faces;
	}

	public void setFaces(List<Face2D> faces) {
		this.faces = faces;
	}
	
}
