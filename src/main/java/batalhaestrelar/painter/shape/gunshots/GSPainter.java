package batalhaestrelar.painter.shape.gunshots;

import italo.g2dlib.g2d.G2DUtilities;
import italo.g2dlib.g2d.painter.Proj2D;
import italo.g2dlib.g2d.shape.PainterShape2DListener;
import italo.g2dlib.g2d.shape.Shape2D;
import italo.g2dlib.graph.Graph2D;
import italo.swingx.Graph;

import java.awt.Color;

import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.gun.Gun;
import batalhaestrelar.kernel.gun.GunConstants;
import batalhaestrelar.kernel.gun.GunKernel;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.math.Math2D;

public class GSPainter implements PainterShape2DListener {
	
	private int gscount = 0;
	private int gsmultiple = 5;

	private GSPainterDriver driver;
	
	public GSPainter( GSPainterDriver driver ) {
		this.driver = driver;
	}

	public void beforePaint(Shape2D shape, Graph2D g2D, Graph g, Proj2D proj) {}

	public void afterPaint(Shape2D shape, Graph2D g2D, Graph g, Proj2D proj) {
		Game game = driver.getKernel().getGame();		
		Fase fase = driver.getKernel().getGameKernel().getCurrentFase( game ); 				
				
		G2DUtilities utils = shape.getG2DUtilities();
		for( Gunshot gunshot : fase.getComputerGunshots() )
			if( gunshot.isActive() )
				this.paintGunshots( utils, gunshot, g2D, g, proj );
		
		if( fase.getPlayer().isGunOn() ) {
			for( Gunshot gunshot : fase.getPlayerGunshots() ) {
				if( gunshot.isActive() ) {
					this.paintGunshots( utils, gunshot, g2D, g, proj );
					gscount++;
				}
			}
			gscount += (int)Math.ceil( Math.random() * gsmultiple ); 
		}				
	}
	
	private void paintGunshots( G2DUtilities utils, Gunshot gunshot, Graph2D g2D, Graph g, Proj2D proj ) {
		if( gunshot.getGun().isRepeat() ) {
			if( gunshot.getGun().getGraphType() == GunConstants.POLYGON_GRAPH )
				this.paintPolygonRepeatGS( utils, gunshot, g2D, g, proj );
			else this.paintOvalRepeatGS( utils, gunshot, g2D, g, proj );
		} else {
			this.paintNoRepeatGunshot( utils, gunshot, g2D, g, proj );			
		}
	}
	
	private void paintPolygonRepeatGS( G2DUtilities utils, Gunshot gunshot, Graph2D g2D, Graph g, Proj2D proj ) {
		Gun gun = gunshot.getGun();
		GunKernel gunKernel = driver.getKernel().getGunKernel();
		Math2D math = driver.getMath();
							
		Color color = gun.getGunshotColor();

		float gunshotAngle = gunKernel.getGunshotAngle( gunshot ); 		
		float gsR = gunKernel.getGunshotRadial( gun );
		float distR = gunKernel.getGunshotDist( gun ); 

		float[] isp = gunKernel.interceptScreenPoint( gunshot );
		float[][] tpolyg = gunKernel.gunshotPolygon( gunshot );
		
		isp[0] -= gun.getCamX();
		isp[1] -= gun.getCamY();
		float feixeR = math.cumpriment( isp );
		
		float[] gsV = math.coordinate( gsR, gunshotAngle );		
		float[] distV = math.coordinate( distR, gunshotAngle );
		
		int quantGunshots = (int) Math.ceil( feixeR / ( gsR + distR ) );								
		
		float initialIncF = (float)( gscount % gsmultiple ) / ( gsmultiple - 1 ); 
		for( float[] p : tpolyg ) { 
			p[0] += gsV[0] * initialIncF;
			p[1] += gsV[1] * initialIncF;
		}
		
		for( int i = 0; i < quantGunshots; i++ ) {																	
			this.paintGunshotPolygon( g2D, g, proj, tpolyg, color );
			
			for( float[] p : tpolyg ) { 
				p[0] += gsV[0] + distV[0];
				p[1] += gsV[1] + distV[1];
			}				
		}
	}
		
	private void paintOvalRepeatGS( G2DUtilities utils, Gunshot gunshot, Graph2D g2D, Graph g, Proj2D proj ) {
		Gun gun = gunshot.getGun();
		GunKernel gunKernel = driver.getKernel().getGunKernel();
		Math2D math = driver.getMath();
			
		Color color = gun.getGunshotColor();

		float gunshotAngle = gunKernel.getGunshotAngle( gunshot ); 		
		float gsR = gunKernel.getGunshotRadial( gun );
		float distR = gunKernel.getGunshotDist( gun ); 
		float gunshotWidth = gunKernel.getGunshotWidth( gun );

		float[] isp = gunKernel.interceptScreenPoint( gunshot );		
		isp[0] -= gun.getCamX();
		isp[1] -= gun.getCamY();
		float feixeR = math.cumpriment( isp );
		
		float[] gsV = math.coordinate( gsR, gunshotAngle );		
		float[] distV = math.coordinate( distR, gunshotAngle );
		
		int quantGunshots = (int) ( feixeR / ( gsR + distR ) );								
						
		float ovalX = gunshot.getCamX();
		float ovalY = gunshot.getCamY();		

		float initialIncF = (float)( gscount % gsmultiple ) / ( gsmultiple - 1 ); 
		ovalX += gsV[0]*.5f * initialIncF;
		ovalY += gsV[1]*.5f * initialIncF;		
		
		for( int i = 0; i < quantGunshots; i++ ) {									
			float x = ovalX + ( i * ( gsV[0] + distV[0] ) );
			float y = ovalY + ( i * ( gsV[1] + distV[1] ) );
			this.paintGunshotOval( utils, g2D, g, proj, x, y, gunshotWidth, color );																		
		}
	}
	
	private void paintNoRepeatGunshot( G2DUtilities utils, Gunshot gunshot, Graph2D g2D, Graph g, Proj2D proj ) {
		Gun gun = gunshot.getGun();
		GunKernel gunKernel = driver.getKernel().getGunKernel();
		
		Color color = gun.getGunshotColor();
		int gtype = gun.getGraphType();		
		float gunshotWidth = gunKernel.getGunshotWidth( gun );
				
		if( gtype == GunConstants.OVAL_GRAPH ) {
			float ovalX = gunshot.getCamX();
			float ovalY = gunshot.getCamY();
			this.paintGunshotOval( utils, g2D, g, proj, ovalX, ovalY, gunshotWidth, color );
		} else {		
			float[][] tpolyg = gunKernel.gunshotPolygon( gunshot );
			for( float[] p : tpolyg ) {
				p[ 0 ] += gunshot.getCamX();
				p[ 1 ] += gunshot.getCamY();
			}
			this.paintGunshotPolygon( g2D, g, proj, tpolyg, color );				
		}																
	}
	
	public void paintGunshotPolygon( Graph2D g2D, Graph g, Proj2D proj, float[][] polyg, Color color ) {
		int len = polyg.length;
		int[] vx = new int[ len ];
		int[] vy = new int[ len ];
		for( int i = 0; i < len; i++ ) {
			int[] p = proj.calculatePoint( polyg[i][0], polyg[i][1] );
			vx[i] = p[0];
			vy[i] = p[1];			
		}
		g2D.setColor( g, color );
		g2D.fillPolygon( g, vx, vy, len );
	}
	
	private void paintGunshotOval( G2DUtilities utils, Graph2D g2D, Graph g, Proj2D proj, float x, float y, float radial, Color color ) {		
		int[] p = proj.calculatePoint( x, y );
		
		int r = (int)Math.ceil( utils.getNormalizer().value( radial ) ); 

		g2D.setColor( g, color );
		g2D.fillArc( g, p[0]-(r/2), p[1]-(r/2), r, r, 0, 360 );
	}
	
	public void drawCells( Fase fase, G2DUtilities utils, Graph2D g2D, Graph g, Proj2D proj ) {
		for( int i = 0; i < fase.getCellQuantity(); i++ ) {
			float cellW = fase.getShape().getCellWidth();
			float cellH = fase.getShape().getCellHeight();
			float x1 = fase.getShape().getX1() - fase.getGame().getCam().getX();
			float y1 = fase.getShape().getY1() - fase.getGame().getCam().getY();
						
			int[] p1 = proj.calculatePoint( x1, y1 + ( cellH * i ) );
			int w = (int)Math.ceil( utils.getNormalizer().value( cellW ) );
			int h = (int)Math.ceil( utils.getNormalizer().value( cellH ) );
					
			g2D.setColor( g, Color.BLUE );
			g2D.drawRect( g, p1[0], p1[1], w, h ); 
		}
	}
	
}
