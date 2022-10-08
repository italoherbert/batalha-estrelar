package batalhaestrelar.kernel.nave.computer;

import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.gun.GunRotatorConfig;
import batalhaestrelar.kernel.gun.ShotConfig;
import batalhaestrelar.kernel.nave.NaveControl;
import batalhaestrelar.kernel.nave.NaveMoverConfig;
import batalhaestrelar.modules.gunrot.GunRotatorVO;
import batalhaestrelar.modules.nave.move.NaveMoverVO;
import batalhaestrelar.modules.nave.shot.ShotVO;
import batalhaestrelar.modules.positionator.single.SinglePositionatorVO;

public class ComputerControl extends NaveControl<ComputerControlTO> {					
		
	private ComputerImpl computer;
	
	public void buildNave( ComputerControlTO to ) {
		computer = (ComputerImpl)to.getNave();
		
		ComputerConfig naveConfig = (ComputerConfig)to.getNaveConfig();
		
		computer.setGroup( to.getGroup() );
		to.getGroup().getComputers().add( computer );
		
		to.getFase().getComputerNaves().add( computer );
		if( naveConfig.getType() == Computer.MOTHER ) {
			to.getFase().getMotherNaves().add( computer );
		} else {
			to.getFase().getChildNaves().add( computer );
		}
	}

	public void initNave( ComputerControlTO to ) {
		ComputerConfig naveConfig = (ComputerConfig)to.getNaveConfig();
		
		computer.setShotOnlyIfSelected( naveConfig.isShotOnlyIfSelected() );
		computer.setMoverType( naveConfig.getMoverType() );
		computer.setShotType( naveConfig.getShotType() );
		computer.setGunRotatorType( naveConfig.getGunRotatorType() );
		computer.setSinglePositionatorType( naveConfig.getSinglePositionatorType() );
	
		SinglePositionatorVO posVO = new SinglePositionatorVO();
		posVO.setCellNumber( naveConfig.getSinglePosCellNumber() );
		computer.setSinglePositionatorTO( posVO );
		
		NaveMoverConfig moverConf = naveConfig.getMoverConfig();
		if( moverConf != null ) {
			NaveMoverVO vo = new NaveMoverVO();
			vo.setInterval( moverConf.getInterval() );
			vo.setIncrement( moverConf.getIncrement() );
			vo.setExecIfShoting( moverConf.isExecIFShoting() );
			computer.setMoverTO( vo );
		}
		
		ShotConfig shotConf = naveConfig.getShotConfig();
		if( shotConf != null ) {
			ShotVO vo = new ShotVO();
			vo.setQuantityBySequence( shotConf.getQuantityBySequence() );
			vo.setShotInterval( shotConf.getShotInterval() );
			vo.setStopInterval( shotConf.getStopInterval() );
			vo.toShotState();
			computer.setShotTO( vo );
		}
				
		GunRotatorConfig gunRotConf = naveConfig.getGunRotatorConfig();
		if( gunRotConf != null ) {
			GunRotatorVO vo = new GunRotatorVO();
			vo.setAngle( gunRotConf.getAngle() );
			vo.setAngleIncrement( gunRotConf.getAngleIncrement() );		
			vo.setAngleLimit( gunRotConf.getAngleLimit() );
			vo.setCycle( gunRotConf.isCycle() );
			vo.setInterval( gunRotConf.getInterval() );
			vo.setRandomDirectionInterval( gunRotConf.getRandomDirectionInterval() );
			vo.setExecIfShoting( gunRotConf.isExecIfShoting() );
			computer.setGunRotatorTO( vo );
		}
		
	}

	public ShapeGC getShapeGC() {
		return computer;
	}
	
}


