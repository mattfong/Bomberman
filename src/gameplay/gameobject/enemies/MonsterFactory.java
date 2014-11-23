package gameplay.gameobject.enemies;

import java.util.ArrayList;

public class MonsterFactory {

    private static MonsterFactory singleton = null;

    protected MonsterFactory() {

    }

    public static MonsterFactory getInstance() {
	if (singleton == null) {
	    return new MonsterFactory();
	}
	return singleton;
    }

    private ArrayList<Class> createClassList(ArrayList<String> enemyTypes) {

	ArrayList<Class> classList = new ArrayList<Class>();

	for (String s : enemyTypes) {
	    try {
		classList.add(Class.forName(s));
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    }

	}

	return classList;
    }

}
