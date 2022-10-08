package italo.g2dlib.g2d.shape.struct.face;

import italo.g2dlib.g2d.shape.struct.StructShape2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Face2D {

	private List<Vertex2D> vertexes = new ArrayList<Vertex2D>();
	private StructShape2D shape;
	private FaceColorizer2D colorizer = null;
	private FaceVisibility2D visibility = null;
	
	public Face2D( StructShape2D shape ) {
		this.shape = shape;
	}
		
	public boolean isDraw() {
		return visibility == null ? shape.getVisibility2D().isDrawFace() : visibility.isDrawFace();
	}
	
	public boolean isFill() {
		return visibility == null ? shape.getVisibility2D().isFillFace() : visibility.isFillFace();
	}
	
	public Color getDrawColor() {
		return colorizer == null ? shape.getColorizer2D().getFaceDrawColor() : colorizer.getFaceDrawColor();
	}

	public Color getFillColor() {
		return colorizer == null ? shape.getColorizer2D().getFaceFillColor() : colorizer.getFaceFillColor();
	}
	
	public FaceColorizer2D getColorizer() {
		return colorizer;
	}
	
	public void setColorizer( FaceColorizer2D colorizer ) {
		this.colorizer = colorizer;
	}
	
	public FaceVisibility2D getVisibility() {
		return visibility;
	}

	public void setVisibility( FaceVisibility2D visibility ) {
		this.visibility = visibility;
	}

	public StructShape2D getShape() {
		return shape;
	}
	
	public List<Vertex2D> getVertexes() {
		return vertexes;
	}

	public void setVertexes( List<Vertex2D> vertexes ) {
		this.vertexes = vertexes;
	}
	
}
