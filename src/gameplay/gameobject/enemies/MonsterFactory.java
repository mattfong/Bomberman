package gameplay.gameobject.enemies;

import gameplay.Level;
import gameplay.World;
import gameplay.gameobject.GameActor;

import java.util.ArrayList;

/**
 * @author MF Credit to TA Dominique for telling me how to implment this black
 *         magic with meta classes.
 */
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
	    if (c == Kondoria.class) {
		actorList.add(new Kondoria(world));

	    }
	    if (c == Doll.class) {
		actorList.add(new Doll(world));
	    }
	    if (c == Minvo.class) {
		actorList.add(new Minvo(world));
	    }
	    if (c == Ovapi.class) {
		actorList.add(new Ovapi(world));
	    }
	    if (c == Pass.class) {
		actorList.add(new Pass(world));
	    }
	    if (c == Pontan.class) {
		actorList.add(new Pontan(world));
	    }
	}
	return actorList;

    }

}
