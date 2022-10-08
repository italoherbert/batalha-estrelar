package italo.g2dlib.g2d.shape.geom;

import italo.g2dlib.g2d.shape.struct.StructColorizer2D;

import java.awt.Color;

public class GeomColorizer2D implements StructColorizer2D{

	private Color vertexColor = Color.WHITE;
	private Color edgeColor = Color.BLUE;
	private Color faceDrawColor = Color.GREEN;
	private Color faceFillColor = Color.RED;

	public GeomColorizer2D() {}
	
	public GeomColorizer2D( Color vertexColor, Color edgeColor, Color faceDrawColor, Color faceFillColor ) {
		this.vertexColor = vertexColor;
		this.edgeColor = edgeColor;
		this.faceDrawColor = faceDrawColor;
		this.faceFillColor = faceFillColor;
	}

	public Color getVertexColor() {
		return vertexColor;
	}

	public void setVertexColor(Color vertexColor) {
		this.vertexColor = vertexColor;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getFaceDrawColor() {
		return faceDrawColor;
	}

	public void setFaceDrawColor(Color faceDrawColor) {
		this.faceDrawColor = faceDrawColor;
	}

	public Color getFaceFillColor() {
		return faceFillColor;
	}

	public void setFaceFillColor(Color faceFillColor) {
		this.faceFillColor = faceFillColor;
	}
	
}
