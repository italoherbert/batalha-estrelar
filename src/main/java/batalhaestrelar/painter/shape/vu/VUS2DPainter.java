package batalhaestrelar.painter.shape.vu;

import italo.g2dlib.g2d.painter.Proj2D;
import italo.g2dlib.g2d.shape.PainterShape2DListener;
import italo.g2dlib.g2d.shape.Shape2D;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import batalhaestrelar.painter.PainterConstants;
import batalhaestrelar.painter.text.TextPainter;

public class VUS2DPainter implements PainterShape2DListener {

	private String scoreFontName = PainterConstants.SCORE_FONT_NAME;
	private int scoreFontStyle = PainterConstants.SCORE_FONT_STYLE;
	private int scoreFontSize = PainterConstants.SCORE_FONT_SIZE;
	
	private Color scoreLabelColor = PainterConstants.SCORE_LABEL_COLOR;
	private Color scoreValueColor = PainterConstants.SCORE_VALUE_COLOR;	
	private Color scoreTextBGColor = PainterConstants.SCORE_TEXT_BG_COLOR;
		
	private int scoreY = PainterConstants.SCORE_Y;
	private int scoreTextBGXY = PainterConstants.SCORE_TEXT_BG_XY;
	
	private TextPainter textPainter = new TextPainter();
	private VU2DTextGraphic textGraphic = new VU2DTextGraphic();
	
	private VUS2DPainterDriver driver;

	public VUS2DPainter( VUS2DPainterDriver driver ) {
		this.driver = driver;
	}

	public void beforePaint( Shape2D shape, Graph2D g2D, Graph g, Proj2D proj ) {}

	public void afterPaint( Shape2D shape, Graph2D g2D, Graph g, Proj2D proj ) {
		String lifeValue = String.valueOf( driver.getScore().getLifeQuantity() );
		String lifeLabel = " Vida(s)   ";
		
		String nFaseValue = String.valueOf( driver.getScore().getCurrentFaseIndex() + 1 );
		String nFaseLabel = " ª Fase   ";
		
		String scoreCountValue = String.valueOf( driver.getScore().getScoreCount() );
		String scoreCountLabel = " Pontos   ";
		
		String energyLabel = "Energia=";
		String energyValue = String.valueOf( driver.getScore().getPlayerEnergy() );
		
		String scoreText = lifeValue+lifeLabel+nFaseValue+nFaseLabel+scoreCountValue+scoreCountLabel+energyLabel+energyValue;
		Font scoreFont = new Font( scoreFontName, scoreFontStyle, scoreFontSize );
		int[] scoreDin = this.textDim( g2D, g, scoreText, scoreFont );
		int sw = driver.getScreen().getWidth();
		
		int[] p = { 
			( sw - scoreDin[0] ) / 2, 
			scoreY + scoreDin[1] 
		};
		this.paintScoreValue( g2D, g, p, lifeLabel, lifeValue, scoreFont, true );
		this.paintScoreValue( g2D, g, p, nFaseLabel, nFaseValue, scoreFont, true );
		this.paintScoreValue( g2D, g, p, scoreCountLabel, scoreCountValue, scoreFont, true );
		this.paintScoreValue( g2D, g, p, energyLabel, energyValue, scoreFont, false );
	
		if( driver.isCenterMessageFlag() ) {
			if( driver.getCenterMessage() == PainterConstants.BLOCK_INIT_FASE_RUM )
				this.paintCenterMessage( g2D, g );
			else this.paintCenterMessage( g2D, g );
			
			driver.centerMSGPainted();
		}
	}
	
	private void paintCenterMessage( Graph2D g2D, Graph g ) {		
		String centerMsg = driver.getCenterMessage();
		
		int screenW = driver.getScreen().getWidth();
		int screenH = driver.getScreen().getHeight();
		
		textGraphic.configure( g2D, g );
		textPainter.paintCenterMessage( textGraphic, centerMsg, screenW, screenH );				
	}
	
	private void paintScoreValue( Graph2D g2D, Graph g, int[] p, String label, String value, Font font, boolean invert ) {
		if( invert ) {
			this.paintText( g2D, g, p, value, font, scoreValueColor );
			this.paintText( g2D, g, p, label, font, scoreLabelColor );
		} else {
			this.paintText( g2D, g, p, label, font, scoreLabelColor );
			this.paintText( g2D, g, p, value, font, scoreValueColor );
		}
	}
	
	private void paintText( Graph2D g2D, Graph g, int[] p, String str, Font font, Color color ) {
		FontRenderContext context = g2D.getFontMetrics( g, font ).getFontRenderContext();
		Rectangle2D rect = font.getStringBounds( str, context ); 
		int w = (int)rect.getWidth(); 
		
		g2D.setFont( g, font );

		g2D.setColor( g, scoreTextBGColor );
		g2D.drawString( g, str, p[0] + scoreTextBGXY, p[1] + scoreTextBGXY );
		
		g2D.setColor( g, color );
		g2D.drawString( g, str, p[0], p[1] );				
		p[0] += w;	
	}		
	
	private int[] textDim( Graph2D g2D, Graph g, String text, Font font) {
		FontRenderContext context = g2D.getFontMetrics( g, font ).getFontRenderContext();
		Rectangle2D rect = font.getStringBounds( text, context );
		return new int[]{				
			(int)Math.floor( rect.getWidth() ),
			(int)Math.floor( rect.getHeight() ) 	
		};
	}
	
}
