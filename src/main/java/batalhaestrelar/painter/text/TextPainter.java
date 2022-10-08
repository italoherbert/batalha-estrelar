package batalhaestrelar.painter.text;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.Map;

import batalhaestrelar.painter.PainterConstants;
import batalhaestrelar.painter.text.process.font.FontTextProcessor;
import batalhaestrelar.painter.text.process.font.TextFormat;

public class TextPainter {

	private FontTextProcessor fontTProc = new FontTextProcessor();
	
	public TextPainter() {
		fontTProc.setDefaultName( PainterConstants.DEFAULT_MSG_FONT_NAME );
		fontTProc.setDefaultColor( PainterConstants.DEFAULT_MSG_COLOR );
		fontTProc.setDefaultBGColor( PainterConstants.DEFAULT_MSG_BG_COLOR );
		fontTProc.setDefaultStyle( PainterConstants.DEFAULT_MSG_FONT_STYLE );
		fontTProc.setDefaultSize( PainterConstants.DEFAULT_MSG_FONT_SIZE );
		fontTProc.setDefaultTX( PainterConstants.DEFAULT_MSG_FONT_TX );
		fontTProc.setDefaultTY( PainterConstants.DEFAULT_MSG_FONT_TY );	
	}
	
	public void paintCenterMessage( TextGraphic g, String text, int screenW, int screenH ) {		
		Map<String, String> globalAttrs = fontTProc.globalAttrs( text );
		String globalMSG = fontTProc.globalTextContent( text );
		
		String[] msgs = globalMSG.split( "\n" );
		TextFormat[] tfs = new TextFormat[ msgs.length ];
		Font[] fonts = new Font[ msgs.length ];
		
		int height = 0;
		int[][] blocksDim = new int[ msgs.length ][2];
		for( int i = 0; i < msgs.length; i++ ) {
			tfs[ i ] = fontTProc.createTextFormat( globalAttrs, msgs[ i ] );
			fonts[ i ] = fontTProc.createFont( tfs[ i ] ); 
			msgs[ i ] = fontTProc.textContent( msgs[ i ] );
									
			FontRenderContext context = g.getFontMetrics( fonts[ i ] ).getFontRenderContext(); 
			Rectangle2D rect = fonts[ i ].getStringBounds( msgs[i], context );  			
			blocksDim[i][0] = (int)rect.getWidth();
			blocksDim[i][1] = (int)rect.getHeight();
			
			height += blocksDim[i][1];
		}						
			
		int blockY = ( screenH - height ) / 2;
		for( int i = 0; i < msgs.length; i++ ) {
			String message = msgs[ i ];
			int w = blocksDim[i][0];
			int h = blocksDim[i][1];
			
			int x = (screenW - w ) / 2;
			int y = blockY + h;
			
			g.setFont( fonts[ i ] );
			g.setColor( tfs[ i ].getBackgroundColor() );
			g.drawString( message, x + tfs[ i ].getTX(), y + tfs[ i ].getTY() );
			
			g.setColor( tfs[ i ].getColor() );			
			g.drawString( message, x, y ); 
			
			blockY += h;
		}	
	}
	
	public int[] paintText( TextGraphic g, String text, int x, int y, String varConfig, String... params ) {
		Map<String, String> globalAttrs = fontTProc.globalAttrs( text );
		String content = fontTProc.globalTextContent( text );
		
		TextFormat tf = fontTProc.createTextFormat( globalAttrs, content );
		Font font = fontTProc.createFont( tf ); 
		content = fontTProc.textContent( content );
									
		FontRenderContext context = g.getFontMetrics( font ).getFontRenderContext();
		Rectangle2D rect = font.getStringBounds( content, context );
		int w  = (int)Math.ceil( rect.getWidth()  );
		int h = (int)Math.ceil( rect.getHeight() );
						
		g.setFont( font );
		g.setColor( tf.getBackgroundColor() );
		g.drawString( text, x + tf.getTX(), y + tf.getTY() + h );
			
		g.setColor( tf.getColor() );			
		g.drawString( content, x, y ); 
				
		return new int[]{ w, h }; 
	}

	public FontTextProcessor getFTProc() {
		return fontTProc;
	}
	
}
