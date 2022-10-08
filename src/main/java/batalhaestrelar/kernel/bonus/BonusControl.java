package batalhaestrelar.kernel.bonus;

import batalhaestrelar.kernel.AbstractShapeControl;
import batalhaestrelar.kernel.MoverConfig;
import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.modules.move.MoverVO;
import batalhaestrelar.modules.positionator.single.SinglePositionatorVO;

public class BonusControl extends AbstractShapeControl<BonusControlTO> {

	private BonusImpl bonus;
	
	public void buildSCtrl( BonusControlTO to ) {
		bonus = (BonusImpl)to.getBonus();
		bonus.setShape( to.getShape() );
		bonus.setFase( to.getFase() );
		to.getFase().getBonusList().add( bonus );
		
		bonus.setGroup( to.getGroup() );
		to.getGroup().getBonusList().add( bonus );		
	}

	public void initSCtrl( BonusControlTO to ) {
		bonus.setMoverType( to.getBonusConfig().getMoverType() );
		bonus.setSinglePositionatorType( to.getBonusConfig().getSinglePositionatorType() );
		
		SinglePositionatorVO vo = new SinglePositionatorVO();
		vo.setCellNumber( to.getBonusConfig().getSinglePosCellNumber() );
		bonus.setSinglePositionatorTO( vo );
		
		MoverConfig moverConfig = to.getBonusConfig().getMoverConfig();
		if( moverConfig != null ) {
			MoverVO mvo = new MoverVO();
			mvo.setInterval( moverConfig.getInterval() );
			mvo.setIncrement( moverConfig.getIncrement() );
			bonus.setMoverTO( mvo );
		}
				
		bonus.setActive( true );
		bonus.setInScreen( false );
	}

	public ShapeGC getShapeGC() {
		return bonus;
	}

}
