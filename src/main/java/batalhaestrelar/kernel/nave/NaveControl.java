package batalhaestrelar.kernel.nave;

import batalhaestrelar.kernel.AbstractShapeControl;

public abstract class NaveControl<T extends NaveControlTO> extends AbstractShapeControl<T> {
		
	protected abstract void buildNave( T to );
	
	protected abstract void initNave( T to );
		
	public void buildSCtrl( T to ) {
		NaveImpl nave = (NaveImpl)to.getNave();
		nave.setGunshotBuffer( to.getGunshotBuffer() );
		nave.setFase( to.getFase() );
		nave.setShape( to.getShape() );
		
		this.buildNave( to );					
	}

	public void initSCtrl( T to ) {
		NaveImpl nave = (NaveImpl)to.getNave();
		nave.setEnergy( to.getNaveConfig().getEnergy() );		
		nave.setShotedITQuantity( to.getNaveConfig().getShotedInterval() );
		nave.setDestroyedITQuantity( to.getNaveConfig().getDestroyedInterval() );		
		
		nave.getSession().getStateCounter().setCount( 0 );
		nave.getSession().getDistributeGunsAngleCounter().setCount( 0 );
		
		nave.getShape().configureByShapeType( to.getNaveConfig().getColorStyle() );
				
		nave.setState( Nave.NORMAL_NAVE_STATE );
		nave.setInScreen( false );
		nave.setShoting( false );

		this.initNave( to );
	}

}