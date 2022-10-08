package batalhaestrelar.kernel.fase;

import java.util.List;

import batalhaestrelar.kernel.BoundShapeGC;
import batalhaestrelar.kernel.ShapeGC;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.kernel.nave.player.Player;

public interface Fase extends ShapeGC, BoundShapeGC {

	public FaseShape getShape();

	public int getIndex();
	
	public Game getGame();
	
	public Player getPlayer();
		
	public List<Computer> getMotherNaves();
	
	public List<Computer> getChildNaves();

	public List<Computer> getComputerNaves();
	
	public List<Bonus> getBonusList();
	
	public List<ComputerGroup> getComputerGroups();
		
	public List<BonusGroup> getBonusGroups();
	
	public Gunshot[] getPlayerGunshots();
	
	public Gunshot[] getComputerGunshots();
		
	public FaseSession getSession();
		
	public int getCellQuantity();

	public int getStarQuantity();
					
}
