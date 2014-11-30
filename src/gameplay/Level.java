package gameplay;

import gameplay.gameobject.enemies.Balloon;
import gameplay.gameobject.enemies.Doll;
import gameplay.gameobject.enemies.Kondoria;
import gameplay.gameobject.enemies.Minvo;
import gameplay.gameobject.enemies.Oneal;
import gameplay.gameobject.enemies.Ovapi;
import gameplay.gameobject.enemies.Pass;
import gameplay.gameobject.powerups.BombPassPowerup;
import gameplay.gameobject.powerups.BombPowerup;
import gameplay.gameobject.powerups.DetonatorPowerup;
import gameplay.gameobject.powerups.FlamePowerup;
import gameplay.gameobject.powerups.SpeedPowerup;
import gameplay.gameobject.powerups.WallPassPowerup;

/**
 * @author MF Level enum specifying config information for the bomberman levels.
 */
public enum Level {
    L1(
	    1,
	    FlamePowerup.class,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class),
    L2(
	    2,

	    BombPowerup.class,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class),
    L3(
	    3,
	    DetonatorPowerup.class,
	    Balloon.class,
	    Balloon.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class),
    L4(
	    4,
	    SpeedPowerup.class,
	    Balloon.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class),
    L5(
	    5,
	    BombPowerup.class,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Doll.class),
    L6(
	    6,
	    BombPowerup.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class),
    L7(
	    7,
	    FlamePowerup.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Kondoria.class,
	    Kondoria.class),
    L8(
	    8,
	    DetonatorPowerup.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class),
    L9(
	    9,
	    BombPassPowerup.class,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class),
    L10(
	    10,
	    WallPassPowerup.class,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class),
    L11(
	    11,
	    BombPowerup.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Ovapi.class),
    L12(
	    12,
	    BombPowerup.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class),
    L13(
	    13,
	    DetonatorPowerup.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class),
    L14(
	    14,
	    WallPassPowerup.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Pass.class),
    L15(
	    15,
	    FlamePowerup.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Pass.class),
    L16(
	    16,
	    WallPassPowerup.class,

	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Kondoria.class,
	    Kondoria.class,
	    Pass.class),
    L17(
	    17,
	    BombPowerup.class,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class,
	    Pass.class,
	    Pass.class),
    L18(
	    18,
	    BombPassPowerup.class,
	    Balloon.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Ovapi.class,
	    Pass.class,
	    Pass.class),
    L19(
	    19,
	    BombPowerup.class,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Pass.class,
	    Pass.class),
    L20(
	    20,
	    DetonatorPowerup.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class,
	    Pass.class),
    L21(
	    21,
	    WallPassPowerup.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Pass.class),
    L22(
	    22,
	    DetonatorPowerup.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class),
    L23(
	    23,
	    BombPowerup.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class),
    L24(
	    24,
	    DetonatorPowerup.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class),
    L25(
	    25,
	    WallPassPowerup.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class);

    private Class[] clazzArray;
    private int levelNumber;
    private Class powerup;

    Level(int levelKey, Class powerup, Class... clz) {
	this.powerup = powerup;
	clazzArray = clz;
	levelNumber = levelKey;
    }

    /**
     * Lookup a level by level number.
     * 
     * @param keyValue
     *            numeric value of the level dessired (24 returns Level.L24 and
     *            1 returns Level.L1)
     * @return a Level enum for the level number specified. If no valid levels
     *         for the key exists returns Level.L1
     */
    public static Level getLevelByNumber(int keyValue) {
	for (Level level : Level.values()) {
	    if (level.getLevelNumber() == keyValue) {
		return level;
	    }
	}
	return Level.L1;
    }

    /**
     * @return the level number of the level object.
     */
    public int getLevelNumber() {
	return levelNumber;
    }

    /**
     * @return a list of class objects containing the enemies for the level.
     */
    public Class[] getClassList() {
	return clazzArray;
    }

    /**
     * @return a class object which contains the class type fo the powerup for
     *         the level.
     */
    public Class getPowerupClass() {
	return powerup;
    }

}
