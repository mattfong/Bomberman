package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gameplay.Level;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.enemies.MonsterFactory;

import java.util.ArrayList;

import org.junit.Test;

public class MonsterFactoryTest {

    @Test
    public void testCreateClassListNotNull() {
	MonsterFactory factory = new MonsterFactory(null);
	ArrayList<GameActor> actorList = factory.createClassList(Level.L1);
	assertNotNull(actorList);
    }

    @Test
    public void testCountNumberOfGameActors() {
	MonsterFactory factory = new MonsterFactory(null);
	ArrayList<GameActor> actorList = factory.createClassList(Level.L1);
	int count = actorList.size();
	assertEquals("Should be 6 elements in Level 1", 6, count);
    }

}
