package gameplay.gameobject.enemies;

import gameplay.Level;
import gameplay.World;
import gameplay.gameobject.GameActor;

import java.util.ArrayList;

public class MonsterFactory {

    private World world;

    public MonsterFactory(World world) {
	this.world = world;
    }

    public ArrayList<GameActor> createClassList(Level level) {

	ArrayList<GameActor> actorList = new ArrayList<GameActor>();
	Class[] classArray = level.getClassList();

	for (Class c : classArray) {
	    if (c == Balloon.class) {
		actorList.add(new Balloon(world));
	    }
	    if (c == Oneal.class) {
		actorList.add(new Oneal(world));
	    }
	}
	return actorList;

    }

}
