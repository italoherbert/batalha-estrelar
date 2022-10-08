package italo.g2dlib.g2d.shape.struct;

import italo.g2dlib.g2d.shape.struct.edge.EdgeVisibility2D;
import italo.g2dlib.g2d.shape.struct.face.FaceVisibility2D;
import italo.g2dlib.g2d.shape.struct.vertex.VertexVisibility2D;

public interface StructVisibility2D extends VertexVisibility2D, EdgeVisibility2D, FaceVisibility2D {
	
	public void setDrawVertex(boolean drawVertex);

	public void setDrawEdge(boolean drawEdge);

	public void setDrawFace(boolean drawFace);

	public void setFillFace(boolean fillFace);
}
