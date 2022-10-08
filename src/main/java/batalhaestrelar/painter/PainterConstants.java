package batalhaestrelar.painter;

import java.awt.Color;
import java.awt.Font;

public interface PainterConstants {

	public final static String DEFAULT_MSG_FONT_NAME = Font.SANS_SERIF;
	public final static String DEFAULT_MSG_COLOR = "blue";
	public final static String DEFAULT_MSG_BG_COLOR = "white"; 
	public final static int DEFAULT_MSG_FONT_STYLE = Font.BOLD;
	public final static int DEFAULT_MSG_FONT_SIZE = 40;
	public final static int DEFAULT_MSG_FONT_TX = -2;
	public final static int DEFAULT_MSG_FONT_TY = -2;
			
	public final static String INITIAL_MESSAGE = "@(size=20;tx=-1;ty=-1)Carregando...";
	
	public final static String PAUSE = "Parado!\n$(size=20;tx=-1;ty=-1)ESQ - para abortar";
	public final static String LOSE = "@(color=RED)Perdeu!";
	public final static String FASE_WINED = "Missão concluída!";
	public final static String GAMEOVER = "@(color=RED)Game Over.\nTente novamente!";
	public final static String ENDGAME = "Fim do jogo.\nParabéns!";
	public final static String BLOCK_INIT_FASE_RUM = "@(size=20;tx=-1;ty=-1)Pressione alguma\ntecla para\niniciar o jogo...";
			
	public final static int SCORE_TEXT_BG_XY = -1;
	public final static int SCORE_Y = 10;
	
	public final static Color SCORE_TEXT_BG_COLOR = Color.BLACK;
	public final static Color SCORE_LABEL_COLOR = Color.WHITE;
	public final static Color SCORE_VALUE_COLOR = Color.YELLOW;
		
	public final static String SCORE_FONT_NAME = Font.SANS_SERIF;
	public final static int SCORE_FONT_STYLE = Font.BOLD;
	public final static int SCORE_FONT_SIZE = 16;
	
}
