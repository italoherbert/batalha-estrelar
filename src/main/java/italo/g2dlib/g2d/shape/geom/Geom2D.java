package italo.g2dlib.g2d.shape.geom;


public class Geom2D {

	private float[][] vertexes;
	private int[][] edges;
	private int[][] faces;

	public Geom2D() {}
	
	public Geom2D( float[][] vertexes, int[][] edges, int[][] faces ) {
		this.vertexes = vertexes;
		this.edges = edges;
		this.faces = faces;
	}

	public float[][] getVertexes() {
		return vertexes;
	}

	public void setVertexes(float[][] vertexes) {
		this.vertexes = vertexes;
	}

	public int[][] getEdges() {
		return edges;
	}

	public void setEdges(int[][] edges) {
		this.edges = edges;
	}

	public int[][] getFaces() {
		return faces;
	}

	public void setFaces(int[][] faces) {
		this.faces = faces;
	}
	
}
