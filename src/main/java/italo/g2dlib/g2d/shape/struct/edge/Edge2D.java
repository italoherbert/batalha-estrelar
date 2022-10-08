package italo.g2dlib.g2d.shape.struct.edge;

import italo.g2dlib.g2d.shape.struct.StructShape2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;

import java.awt.Color;

public class Edge2D {

	private Vertex2D vertex1;
	private Vertex2D vertex2;
	private StructShape2D shape;
	private EdgeColorizer2D colorizer = null;
	private EdgeVisibility2D visibility = null;
	
	public Edge2D( StructShape2D shape ) {
		this( shape, null, null );
	}
	
	public Edge2D( StructShape2D shape, Vertex2D vertex1, Vertex2D vertex2 ) {
		this.shape = shape;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	public boolean isDraw() {
		return visibility == null ? shape.getVisibility2D().isDrawEdge() : visibility.isDrawEdge();
	}
	
	public Color getColor() {
		return ( colorizer == null ? shape.getColorizer2D().getEdgeColor() : colorizer.getEdgeColor() );
	}
	
	public EdgeColorizer2D getColorizer() {
		return colorizer;
	}
	
	public void setColorizer( EdgeColorizer2D colorizer ) {
		this.colorizer = colorizer;
	}

	public EdgeVisibility2D getVisibility() {
		return visibility;
	}

	public void setVisibility( EdgeVisibility2D visibility ) {
		this.visibility = visibility;
	}

	public StructShape2D getShape() {
		return shape;
	}
	
	public Vertex2D getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex2D vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex2D getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex2D vertex2) {
		this.vertex2 = vertex2;
	}
	
}
