package gameplay;

import gameplay.gameobject.enemies.Balloon;
import gameplay.gameobject.enemies.Doll;
import gameplay.gameobject.enemies.Kondoria;
import gameplay.gameobject.enemies.Minvo;
import gameplay.gameobject.enemies.Oneal;
import gameplay.gameobject.enemies.Ovapi;
import gameplay.gameobject.enemies.Pass;

import java.util.Map;

public enum Level {
    L1(1, Balloon.class, Balloon.class, Balloon.class, Balloon.class, Balloon.class, Balloon.class), L2(2, Balloon.class, Balloon.class, Balloon.class, Oneal.class, Oneal.class, Oneal.class), L3(
	    3,
	    Balloon.class,
	    Balloon.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class), L4(4, Balloon.class, Oneal.class, Doll.class, Doll.class, Minvo.class, Minvo.class), L5(
	    5,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Doll.class), L6(6, Oneal.class, Oneal.class, Doll.class, Doll.class, Doll.class, Minvo.class, Minvo.class), L7(
	    7,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Kondoria.class,
	    Kondoria.class), L8(8, Oneal.class, Doll.class, Doll.class, Minvo.class, Minvo.class, Minvo.class, Minvo.class), L9(
	    9,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class), L10(10, Oneal.class, Doll.class, Minvo.class, Kondoria.class, Kondoria.class, Kondoria.class, Ovapi.class), L11(
	    11,
	    Oneal.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Ovapi.class), L12(12, Doll.class, Doll.class, Doll.class, Minvo.class, Minvo.class, Minvo.class, Kondoria.class, Kondoria.class, Kondoria.class), L13(
	    13,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class), L14(14, Doll.class, Minvo.class, Minvo.class, Minvo.class, Kondoria.class, Kondoria.class, Kondoria.class, Pass.class), L15(
	    15,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Pass.class), L16(16, Doll.class, Doll.class, Doll.class, Doll.class, Doll.class, Kondoria.class, Kondoria.class, Pass.class), L17(
	    17,
	    Balloon.class,
	    Balloon.class,
	    Balloon.class,
	    Oneal.class,
	    Oneal.class,
	    Oneal.class,
	    Pass.class,
	    Pass.class), L18(18, Balloon.class, Oneal.class, Doll.class, Doll.class, Doll.class, Ovapi.class, Pass.class, Pass.class), L19(
	    19,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Pass.class,
	    Pass.class), L20(20, Kondoria.class, Kondoria.class, Kondoria.class, Kondoria.class, Ovapi.class, Ovapi.class, Ovapi.class, Pass.class, Pass.class), L21(
	    21,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Doll.class,
	    Minvo.class,
	    Minvo.class,
	    Minvo.class,
	    Kondoria.class,
	    Pass.class), L22(22, Doll.class, Doll.class, Minvo.class, Minvo.class, Kondoria.class, Kondoria.class, Ovapi.class, Ovapi.class, Pass.class), L23(
	    23,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class), L24(24, Doll.class, Minvo.class, Kondoria.class, Kondoria.class, Kondoria.class, Kondoria.class, Ovapi.class, Ovapi.class, Pass.class), L25(
	    25,
	    Oneal.class,
	    Oneal.class,
	    Doll.class,
	    Minvo.class,
	    Kondoria.class,
	    Kondoria.class,
	    Ovapi.class,
	    Ovapi.class,
	    Pass.class);

    private Class[] classArray;
    private int levelNumber;

    private static Map<Integer, Level> numberToLevelMap;

    public static Level getLevelByNumber(int keyValue) {
	for (Level level : Level.values()) {
	    if (level.getLevelNumber() == keyValue) {
		return level;
	    }
	}
	return Level.L1;
    }

    public int getLevelNumber() {
	return levelNumber;
    }

    Level(int levelKey, Class... clz) {
	classArray = clz;
	levelNumber = levelKey;
    }

    public Class[] getClassList() {
	return classArray;
    }

}
