package batalhaestrelar.kernel.bonus;

import batalhaestrelar.kernel.GCShape;
import batalhaestrelar.kernel.game.GameConfig;

public interface BonusShape extends GCShape, BonusConstants {

	public void initialize( GameConfig config, BonusShapeDriver driver );

}
