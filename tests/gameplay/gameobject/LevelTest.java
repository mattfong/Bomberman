package gameplay.gameobject;

import static org.junit.Assert.assertEquals;
import gameplay.Level;

import org.junit.Test;

public class LevelTest {

    private Level level;

    @Test
    public void testGetLevelByNumber() {
	level = Level.getLevelByNumber(1);
	assertEquals(Level.L1, level);
	level = Level.getLevelByNumber(25);
	assertEquals(Level.L25, level);

    }

    @Test
    public void testGetLevelNumber() {
	assertEquals(1, Level.L1.getLevelNumber());
	assertEquals(14, Level.L14.getLevelNumber());
	assertEquals(25, Level.L25.getLevelNumber());

    }

}
