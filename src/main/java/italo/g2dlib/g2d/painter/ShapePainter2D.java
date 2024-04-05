package italo.g2dlib.g2d.painter;

import italo.g2dlib.g2d.G2DUtilities;
import italo.g2dlib.g2d.shape.BaseShape2D;
import italo.g2dlib.g2d.shape.Shape2D;
import italo.g2dlib.g2d.shape.struct.edge.Edge2D;
import italo.g2dlib.g2d.shape.struct.face.Face2D;
import italo.g2dlib.g2d.shape.struct.vertex.Vertex2D;
import italo.g2dlib.graph.Graph2D;
import italo.g2dlib.graph.Graph2DImpl;
import italo.swingx.Graph;
import italo.swingx.Painter;

import java.util.Collection;
import java.util.List;

public class ShapePainter2D implements Painter {

	private Graph2D graph2D = new Graph2DImpl();
	private Proj2D proj;
	
	private Shape2D shape = null;
	
	public ShapePainter2D( G2DUtilities utils ) {
		this.proj = new Proj2D( utils );
	}
	
	public void configure( Shape2D shape ) {
		this.shape = shape;
	}
	 
	@Override
	public void paint( Graph g ) {
		if( shape != null )
			this.paintShape( g, shape );
	}
	
	private void paintShape( Graph g, Shape2D s ) {
		if( !s.activeVerify() )
			return;
		
		s.buildView();
		
		((PainterShape2D)s).getPainterShape2DListener().beforePaint( s, graph2D, g, proj );
		((PainterShape2D)s).beforePaint( graph2D, g, proj );
		
		if( s.isFacesVisible() )
			this.paintFaces( g, s.getViewStruct2D().getFaces() );
		if( s.isEdgesVisible() )
			this.paintEdges( g, s.getViewStruct2D().getEdges() );
		if( s.isVertexesVisible() )
			this.paintVertexes( g, s.getViewStruct2D().getVertexes() );
                
                graph2D.clipRect( g ); 
		
		if( s instanceof BaseShape2D ) {
			((PainterBaseShape2D)s).getPainterBaseShape2DListener().beforeChildsPaint( (BaseShape2D)shape, graph2D, g, proj );
			((PainterBaseShape2D)s).beforeChildsPaint( graph2D, g, proj );
						
			Collection<Shape2D> childs = ((BaseShape2D)s).getChildsForPaint();
			for( Shape2D child : childs )
				this.paintShape( g, child );
		}                                
		
		((PainterShape2D)s).afterPaint( graph2D, g, proj );		
		((PainterShape2D)s).getPainterShape2DListener().afterPaint( s, graph2D, g, proj );
	}
	
	private void paintVertexes( Graph g, List<Vertex2D> vertexes ) {
		for( Vertex2D v : vertexes ) {
			if( !v.isDraw() )
				continue;
			int[] p = proj.calculatePoint( v.getX(), v.getY() );
			graph2D.putPixel( g, p[0], p[1], v.getColor() );
		}
	}
	
	private void paintEdges( Graph g, List<Edge2D> edges ) {
		for( Edge2D e : edges ) {
			if( !e.isDraw() )
				continue;
			int[] p1 = proj.calculatePoint( e.getVertex1().getX(), e.getVertex1().getY() );
			int[] p2 = proj.calculatePoint( e.getVertex2().getX(), e.getVertex2().getY() );
			graph2D.setColor( g, e.getColor() );
			graph2D.drawLine( g, p1[0], p1[1], p2[0], p2[1] );
		}
	}
	
	private void paintFaces( Graph g, List<Face2D> faces ) {		
		for( Face2D f : faces ) {
			if( !f.isDraw() && !f.isFill() )
				continue;
			int len = f.getVertexes().size();
			int[] vx = new int[ len ];
			int[] vy = new int[ len ];
			for( int i = 0; i < len; i++ ) {
				Vertex2D v = f.getVertexes().get( i );
				int[] p = proj.calculatePoint( v.getX(), v.getY() );
				vx[i] = p[0];
				vy[i] = p[1];
			}
			if( f.isFill() ) {
				graph2D.setColor( g, f.getFillColor() );
				graph2D.fillPolygon( g, vx, vy, len );
			}
			if( f.isDraw() ) {
				graph2D.setColor( g, f.getDrawColor() );
				graph2D.drawPolygon( g, vx, vy, len );
			}
		}
	}

}
