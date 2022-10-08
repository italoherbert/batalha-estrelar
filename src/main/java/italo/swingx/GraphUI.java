package italo.swingx;


import java.awt.Graphics;
import java.awt.image.BufferedImage;


public interface GraphUI {	
	
	public void repaint();	

	public int getWidth();
	
	public int getHeight();
	
	public void newGraph();

	public void newImage( int w, int h );

	public BufferedImage getImage();

	public void setImage(BufferedImage image);

	public Painter getPainter();

	public void setPainter(Painter painter);

	public Graph getGraph();

	public void setGraph(Graph graph);
	
	public Graphics getPainterGraphics();
	
	public GraphUIListener getGraphUIListener();

	public void setGraphUIListener(GraphUIListener listener);
	
}
