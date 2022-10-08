package italo.g2dlib.g2d.shape.struct;

import java.awt.Color;

import italo.g2dlib.g2d.shape.struct.edge.EdgeColorizer2D;
import italo.g2dlib.g2d.shape.struct.face.FaceColorizer2D;
import italo.g2dlib.g2d.shape.struct.vertex.VertexColorizer2D;

public interface StructColorizer2D extends VertexColorizer2D, EdgeColorizer2D, FaceColorizer2D {

	public void setVertexColor(Color vertexColor);

	public void setEdgeColor(Color edgeColor);

	public void setFaceDrawColor(Color faceDrawColor);

	public void setFaceFillColor(Color faceFillColor);
	
}
