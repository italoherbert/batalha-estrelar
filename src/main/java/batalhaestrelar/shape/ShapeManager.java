package batalhaestrelar.shape;

import italo.g2dlib.g2d.G2D;
import italo.g2dlib.g2d.G2DUtilities;
import italo.g2dlib.g2d.G2DVUBuilder;
import italo.g2dlib.g2d.shape.VirtualUniverse2D;
import italo.swingx.Graph;

import java.util.List;

import batalhaestrelar.kernel.CamScreen;
import batalhaestrelar.kernel.ShapeKernel;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusShape;
import batalhaestrelar.kernel.fase.Fase;
import batalhaestrelar.kernel.fase.FaseShape;
import batalhaestrelar.kernel.nave.NaveShape;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.player.Player;
import batalhaestrelar.shape.bonus.BonusFactory;
import batalhaestrelar.shape.bonus.BonusShape2D;
import batalhaestrelar.shape.fase.FaseShape2D;
import batalhaestrelar.shape.layers.LayerShape2D;
import batalhaestrelar.shape.nave.NaveS2DFactory;
import batalhaestrelar.shape.nave.NaveShape2D;

public class ShapeManager implements ShapeKernel, CamScreen {
	
	private final int layerByFaseQuantity = 5;
	private final int faseLayerIndex = 0;
	private final int bonusLayerIndex = 1;
	private final int naveLayerIndex = 2;
	private final int gunshotLayerIndex = 3;
	private final int messagesLayerIndex = 4;
	
	private G2D g2dlib = new G2D();
	private G2DUtilities utils;
	private G2DVUBuilder vubuilder;
	private boolean[] buildedVUFlags;
	
	private VirtualUniverse2D[] vus;
	private LayerShape2D[][] layersByFaseMap; 
	
	private ShapeManagerDriver driver;
		
	private NaveS2DFactory naveS2DFactory = new NaveS2DFactory();
	private BonusFactory bonusS2DFactory = new BonusFactory();
	
	public ShapeManager( ShapeManagerDriver driver ) {
		this.driver = driver;
	}
	
	public void configureAfterInit( Fase fase ) {
		VirtualUniverse2D vu = vus[ fase.getIndex() ];
		vu.configurePainterForThis();
		
		if( !buildedVUFlags[ fase.getIndex() ] ) {
			vu.buildInit();			
			
			buildedVUFlags[ fase.getIndex() ] = true;
		}
	}
	
	public void configureBeforeRepaint( Fase fase ) {		
		Player player = fase.getPlayer();
		List<Computer> computers = fase.getComputerNaves();
		List<Bonus> bonusList = fase.getBonusList();
				
		FaseShape2D faseShape = (FaseShape2D)fase.getShape();
		faseShape.setX( fase.getCamX() );
		faseShape.setY( fase.getCamY() );
		
		NaveShape2D playerShape = (NaveShape2D)player.getShape();
		playerShape.setX( player.getCamX() );
		playerShape.setY( player.getCamY() );
		playerShape.getCardS2D().setCurrentShape( player.currentState() );		
		
		for( Computer nave : computers ) {			
			NaveShape2D naveShape = (NaveShape2D)nave.getShape();				
			naveShape.setX( nave.getCamX() );
			naveShape.setY( nave.getCamY() );
			naveShape.getCardS2D().setCurrentShape( nave.currentState() );
		}		
		
		for( Bonus bonus : bonusList ) {
			BonusShape2D shape = (BonusShape2D)bonus.getShape();
			shape.setX( bonus.getCamX() );
			shape.setY( bonus.getCamY() );
		}
				
	}
		
	public FaseShape createAndAddFaseShape( int faseIndex ) {
		FaseShape2D shape = new FaseShape2D();		
		layersByFaseMap[ faseIndex ][ faseLayerIndex ].addShape( shape );
		
		return shape;
	}
	
	public BonusShape createAndAddBonusShape( int faseIndex, int type ) {
		BonusShape2D shape = bonusS2DFactory.create( type );		
		layersByFaseMap[ faseIndex ][ bonusLayerIndex ].addShape( shape );
		
		return shape;
	}
	
	public NaveShape createAndAddNaveShape( int faseIndex, int type, int style ) {
		NaveShape2D shape = naveS2DFactory.create( type, style );		
		layersByFaseMap[ faseIndex ][ naveLayerIndex ].addShape( shape );
		
		return shape;
	}
	
	public void initialize() {
		utils = g2dlib.createG2DUtilities( driver.getScreen() );
		vubuilder = g2dlib.createVUBuilder( utils );
						
		int fasesQuantity = driver.getGameConfig().getFaseConfigs().length;
		
		vus = new VirtualUniverse2D[ fasesQuantity ];
		buildedVUFlags = new boolean[ fasesQuantity ];
		layersByFaseMap = new LayerShape2D[ fasesQuantity ][ layerByFaseQuantity ];
		
		for( int i = 0; i < fasesQuantity; i++ ) {			
			vus[ i ] = vubuilder.createVU();
			for( int j = 0; j < layerByFaseQuantity; j++ ) {
				layersByFaseMap[ i ][ j ] = new LayerShape2D();
				vus[ i ].addShape( layersByFaseMap[ i ][ j ] );
			}
			
			layersByFaseMap[ i ][ gunshotLayerIndex ].setPainterShape2DListener( driver.getGunshotsS2DListener() );
			layersByFaseMap[ i ][ messagesLayerIndex ].setPainterShape2DListener( driver.getVUPainterS2DListener() );
			buildedVUFlags[ i ] = false;
		}
		
	}
		
	public float getScreenWidth() {
		if( utils == null )
			return 0;
		return utils.getNormalizer().normal( utils.getScreen().getWidth() );
	}

	public float getScreenHeight() {
		if( utils == null )
			return 0;
		return utils.getNormalizer().normal( utils.getScreen().getHeight() );
	}
	
	public CamScreen getCamScreen() {
		return this;
	}

	public void paint( Graph g ) {
		if( utils != null )	
			utils.getPainter().paint( g );		
	}
	
}
