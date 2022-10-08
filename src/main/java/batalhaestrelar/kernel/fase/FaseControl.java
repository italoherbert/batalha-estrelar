package batalhaestrelar.kernel.fase;

import java.util.ArrayList;

import batalhaestrelar.kernel.AbstractShapeControl;
import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.ComputerConfig;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;

public class FaseControl extends AbstractShapeControl<FaseControlTO> {
	
	private FaseImpl fase;
	
	public void buildSCtrl( FaseControlTO to ) {
		fase = (FaseImpl)to.getFase();
		fase.setShape( to.getShape() );
		fase.setIndex( to.getIndex() );
		fase.setGame( to.getGame() );
		fase.setComputerNaves( new ArrayList<Computer>() ); 
		fase.setMotherNaves( new ArrayList<Computer>() );
		fase.setChildNaves( new ArrayList<Computer>() );
		fase.setBonusList( new ArrayList<Bonus>() );
		
		fase.setComputerGroups( new ArrayList<ComputerGroup>() );
		fase.setBonusGroups( new ArrayList<BonusGroup>() );
		
		ComputerConfig[] compConfigs = to.getFaseConfig().getComputerConfigs();
		int quant = 0;
		for( ComputerConfig conf : compConfigs )
			quant += conf.getQuantity();		
		fase.getSession().setInScreenComputers( new Computer[ quant ] );
		
		int size = to.getFaseConfig().getPlayerGunshotBufferLength();
		Gunshot[] gunshots = new Gunshot[ size ];
		for( int i = 0; i < size; i++ )
			gunshots[ i ] = new Gunshot();		
		fase.setPlayerGunshots( gunshots );
		
		size = to.getFaseConfig().getComputerGunshotBufferLength();
		gunshots = new Gunshot[ size ];
		for( int i = 0; i < size; i++ )
			gunshots[ i ] = new Gunshot();
		fase.setComputerGunshots( gunshots );
		
		fase.setComputerGroups( to.getComputerGroups() );
		fase.setBonusGroups( to.getBonusGroups() );
				
		to.getGame().getFases().add( fase );		
	}

	@Override
	public void initSCtrl( FaseControlTO to ) {
		fase.setCellQuantity( to.getFaseConfig().getCellQuantity() );
		fase.setStarQuantity( to.getFaseConfig().getStarQuantity() );
		
		for( int i = 0; i < fase.getPlayerGunshots().length; i++ )
			fase.getPlayerGunshots()[ i ].setActive( false );		
		for( int i = 0; i < fase.getComputerGunshots().length; i++ )
			fase.getComputerGunshots()[ i ].setActive( false );
								
		fase.getSession().getCounter().setCount( 0 );
		fase.getSession().setInScreenNaveQuantity( 0 );
		fase.getSession().setState( FaseState.EXECUTING );
		fase.getSession().setNaveForShot( null );
		
		fase.getGame().getCam().getControl().init( true );
	}

	public ShapeGC getShapeGC() {
		return fase;
	}

}
