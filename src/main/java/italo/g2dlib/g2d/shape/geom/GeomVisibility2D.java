package italo.g2dlib.g2d.shape.geom;

import italo.g2dlib.g2d.shape.struct.StructVisibility2D;

public class GeomVisibility2D implements StructVisibility2D {

	private boolean drawVertex = true;
	private boolean drawEdge = true;
	private boolean drawFace = true;
	private boolean fillFace = true;

	public GeomVisibility2D() {}
	
	public GeomVisibility2D( boolean drawVertex, boolean drawEdge,	boolean drawFace, boolean fillFace ) {
		this.drawVertex = drawVertex;
		this.drawEdge = drawEdge;
		this.drawFace = drawFace;
		this.fillFace = fillFace;
	}

	public boolean isDrawVertex() {
		return drawVertex;
	}

	public void setDrawVertex(boolean drawVertex) {
		this.drawVertex = drawVertex;
	}

	public boolean isDrawEdge() {
		return drawEdge;
	}

	public void setDrawEdge(boolean drawEdge) {
		this.drawEdge = drawEdge;
	}

	public boolean isDrawFace() {
		return drawFace;
	}

	public void setDrawFace(boolean drawFace) {
		this.drawFace = drawFace;
	}

	public boolean isFillFace() {
		return fillFace;
	}

	public void setFillFace(boolean fillFace) {
		this.fillFace = fillFace;
	}

}
