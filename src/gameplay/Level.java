package gameplay;

import gameplay.gameobject.enemies.Balloon;
import gameplay.gameobject.enemies.Oneal;

public enum Level {
    L1(Balloon.class, Balloon.class, Balloon.class, Balloon.class, Balloon.class, Balloon.class), L2(Balloon.class, Balloon.class, Balloon.class, Oneal.class, Oneal.class, Oneal.class);

    private Class[] classArray;

    Level(Class... clz) {
	classArray = clz;
    }

    public Class[] getClassList() {
	return classArray;
    }

}
