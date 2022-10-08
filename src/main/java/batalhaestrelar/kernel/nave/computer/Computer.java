package batalhaestrelar.kernel.nave.computer;

import batalhaestrelar.kernel.nave.Nave;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.modules.gunrot.GunRotatorTO;
import batalhaestrelar.modules.nave.move.NaveMoverTO;
import batalhaestrelar.modules.nave.shot.ShotTO;
import batalhaestrelar.modules.positionator.single.SinglePositionatorTO;

public interface Computer extends Nave {
				
	public ComputerGroup getGroup();
	
	public boolean isShotOnlyIfSelected();
		
	public int getSinglePositionatorType();

	public int getMoverType();
	
	public int getShotType();
	
	public int getGunRotatorType();
	
	public SinglePositionatorTO getSinglePositionatorTO();
	
	public NaveMoverTO getMoverTO();
	
	public GunRotatorTO getGunRotatorTO();
	
	public ShotTO getShotTO();
	
	public void setMoverType( int moverType );
	
	public void setShotType( int gunshootType );
	
	public void setGunRotatorType( int gunRotatorType );
	
	public void setSinglePositionatorTO( SinglePositionatorTO to );

	public void setMoverTO( NaveMoverTO to );
	
	public void setGunRotatorTO( GunRotatorTO to );
	
	public void setGroup( ComputerGroup group );
	
}
