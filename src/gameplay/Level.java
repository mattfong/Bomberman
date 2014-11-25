package gameplay;

import gameplay.gameobject.enemies.Balloon;
import gameplay.gameobject.enemies.Doll;
import gameplay.gameobject.enemies.Kondoria;
import gameplay.gameobject.enemies.Minvo;
import gameplay.gameobject.enemies.Oneal;
import gameplay.gameobject.enemies.Ovapi;

public enum Level {
    L1(Balloon.class, Balloon.class, Balloon.class, Balloon.class, Balloon.class, Balloon.class), L2(Balloon.class, Balloon.class, Balloon.class, Oneal.class, Oneal.class, Oneal.class), L11(
	    Oneal.class, Doll.class, Doll.class, Minvo.class, Minvo.class, Minvo.class, Kondoria.class, Ovapi.class);
    private Class[] classArray;

    Level(Class... clz) {
	classArray = clz;
    }

    public Class[] getClassList() {
	return classArray;
    }

}
