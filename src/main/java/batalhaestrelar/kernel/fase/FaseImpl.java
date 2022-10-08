package batalhaestrelar.kernel.fase;

import java.util.List;

import batalhaestrelar.kernel.AbstractShapeGC;
import batalhaestrelar.kernel.bonus.Bonus;
import batalhaestrelar.kernel.bonus.BonusGroup;
import batalhaestrelar.kernel.game.Game;
import batalhaestrelar.kernel.gun.Gunshot;
import batalhaestrelar.kernel.nave.computer.Computer;
import batalhaestrelar.kernel.nave.computer.group.ComputerGroup;
import batalhaestrelar.kernel.nave.player.Player;

public class FaseImpl extends AbstractShapeGC implements Fase {
	
	private int index;
	private FaseShape shape;	
	
	private Game game;
	private Player player;
	private List<Computer> motherNaves;
	private List<Computer> childNaves;
	private List<Computer> computerNaves;
	private List<Bonus> bonusList;
	private Gunshot[] computerGunshots = {};
	private Gunshot[] playerGunshots = {};
	
	private List<ComputerGroup> computerGroups;
	private List<BonusGroup> bonusGroups;
		
	private int cellQuantity;
	private int starQuantity;
				
	private FaseSession session = new FaseSession();
		
	public float getAbsX() {
		return super.getX();
	}

	public float getAbsY() {
		return super.getY();
	}

	public float getCamX() {
		return super.getX() - game.getCam().getX();
	}

	public float getCamY() {
		return super.getY() - game.getCam().getY();
	}

	public float getX1() {
		return shape.getX1();
	}

	public float getY1() {
		return shape.getY1();
	}

	public float getX2() {
		return shape.getX2();
	}

	public float getY2() {
		return shape.getY2();
	}

	public List<ComputerGroup> getComputerGroups() {
		return computerGroups;
	}

	public void setComputerGroups(List<ComputerGroup> computerGroups) {
		this.computerGroups = computerGroups;
	}

	public List<BonusGroup> getBonusGroups() {
		return bonusGroups;
	}

	public void setBonusGroups(List<BonusGroup> bonusGroups) {
		this.bonusGroups = bonusGroups;
	}

	public FaseSession getSession() {
		return session;
	}
	
	public FaseShape getShape() {
		return shape;
	}

	public void setShape( FaseShape shape ) {
		this.shape = shape;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Game getGame() {
		return game;
	}

	public void setGame( Game game ) {
		this.game = game;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer( Player player ) {
		this.player = player;
	}
	
	public List<Computer> getMotherNaves() {
		return motherNaves;
	}

	public void setMotherNaves(List<Computer> motherNaves) {
		this.motherNaves = motherNaves;
	}

	public List<Computer> getComputerNaves() {
		return computerNaves;
	}

	public void setComputerNaves(List<Computer> computerNaves) {
		this.computerNaves = computerNaves;
	}

	public List<Computer> getChildNaves() {
		return childNaves;
	}

	public void setChildNaves(List<Computer> childNaves) {
		this.childNaves = childNaves;
	}

	public List<Bonus> getBonusList() {
		return bonusList;
	}

	public void setBonusList(List<Bonus> bonusList) {
		this.bonusList = bonusList;
	}

	public Gunshot[] getComputerGunshots() {
		return computerGunshots;
	}
	
	public void setComputerGunshots(Gunshot[] computerGunshots) {
		this.computerGunshots = computerGunshots;
	}

	public Gunshot[] getPlayerGunshots() {
		return playerGunshots;
	}

	public void setPlayerGunshots(Gunshot[] playerGunshots) {
		this.playerGunshots = playerGunshots;
	}

	public int getCellQuantity() {
		return cellQuantity;
	}

	public void setCellQuantity(int cellQuantity) {
		this.cellQuantity = cellQuantity;
	}

	public int getStarQuantity() {
		return starQuantity;
	}

	public void setStarQuantity(int starQuantity) {
		this.starQuantity = starQuantity;
	}

}
