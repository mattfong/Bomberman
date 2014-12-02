package gameplay.world;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gameplay.gameobject.GameActor;
import gameplay.world.Factory;
import gameplay.world.Level;

import java.util.ArrayList;

import org.junit.Test;

public class FactoryTest {

    @Test
    public void testCreateClassListNotNull() {
	Factory factory = new Factory(null);
	ArrayList<GameActor> actorList = factory.getEnemyList(Level.L1);
	assertNotNull(actorList);
    }

    @Test
    public void testCountNumberOfGameActors() {
	Factory factory = new Factory(null);
	ArrayList<GameActor> actorList = factory.getEnemyList(Level.L1);
	int count = actorList.size();
	assertEquals("Should be 6 elements in Level 1", 6, count);
    }

}
