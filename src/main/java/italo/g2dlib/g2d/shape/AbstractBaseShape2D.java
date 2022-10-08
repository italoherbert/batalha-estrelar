package italo.g2dlib.g2d.shape;

import italo.g2dlib.g2d.painter.PainterBaseShape2D;
import italo.g2dlib.g2d.painter.Proj2D;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBaseShape2D extends AbstractShape2D implements BaseShape2D, PainterBaseShape2D {

	private List<Shape2D> childs = new ArrayList<Shape2D>();
	private PainterBaseShape2DListener basePainterListener = new PainterBaseShape2DAdapter() {};
	
	public void beforeChildsPaint(Graph2D g2D, Graph g, Proj2D proj) {}
		
	public void buildInit() {
		super.buildInit();
		
		for( Shape2D s : childs )
			s.buildInit();
	}

	protected void addChild( Shape2D s ) {
		s.setParent( this );
		s.setG2DUtilities( super.getG2DUtilities() );
		childs.add( s );
	}	
	
	public List<Shape2D> getAllChilds() {
		return childs;
	}

	public PainterBaseShape2DListener getPainterBaseShape2DListener() {
		return basePainterListener;
	}
	
	public void setPainterShape2DListener( PainterBaseShape2DListener listener ) {
		super.setPainterShape2DListener( listener );
		this.basePainterListener = listener;
	}
	
}
