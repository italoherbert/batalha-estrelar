package italo.swingx;

import italo.swingx.adapter.GraphicGUIScreen;
import italo.swingx.adapter.ImageScreen;
import italo.swingx.adapter.ImageSource;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

class GraphUIImpl implements GraphUI, ImageSource {

	private BufferedImage image;
	private Graph graph = null;
	private Graphics painterGraphics = null;
	private Painter painter = new Painter() {		
		public void paint( Graph g ) {}
	};
		
	private GraphicGUI gpanel;
	
	private GCScreen graphicGUIScreen;
	private GCScreen imageScreen;
	private GCScreen currentGCScreen;

	private boolean resized = false;

	private GraphUIListener listener = new GraphUIListener() {		
		public void resized(GraphUI graphUI) {}
	};

	public GraphUIImpl(GraphicGUI gpanel) {
		this.gpanel = gpanel;		
		this.graphicGUIScreen = new GraphicGUIScreen( gpanel );
		this.imageScreen = new ImageScreen( this );
		
		currentGCScreen = graphicGUIScreen;
	}

	public void screenForImage() {
		currentGCScreen = imageScreen;
	}
	
	public void repaint() {
		gpanel.getGraphicComponentGUI().repaint();
	}

	public int getWidth() {
		return currentGCScreen.getWidth();
	}

	public int getHeight() {
		return currentGCScreen.getHeight();
	}

	public void newImage( int w, int h ) {
		image = new BufferedImage( w, h, BufferedImage.TYPE_INT_RGB );
	}
	
	public void newGraph() {
		graph = new GraphImpl( this );
	}

	public Graphics getPainterGraphics() {
		return painterGraphics;
	}

	public void setPainterGraphics(Graphics painterGraphics) {
		this.painterGraphics = painterGraphics;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage( BufferedImage image ) {
		this.image = image;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Painter getPainter() {
		return painter;
	}

	public void setPainter(Painter painter) {
		this.painter = painter;
	}

	public GraphUIListener getGraphUIListener() {
		return listener;
	}

	public void setGraphUIListener(GraphUIListener listener) {
		this.listener = listener;
	}

	public boolean isResized() {
		return resized;
	}

	public void setResized(boolean resized) {
		this.resized = resized;
	}
	
}
