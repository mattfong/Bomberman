package loginSystem;

import static org.junit.Assert.*;

import java.util.Random;

import menuView.menuLogic.LevelSelectPanelLogic;
import menuView.menuLogic.LoginMenuPanelLogic;

import org.junit.Before;
import org.junit.Test;

public class LevelSelectPanelLogicTest {

	private LevelSelectPanelLogic system = new LevelSelectPanelLogic();

	@Before
	public void setUp() throws Exception {
		system = new LevelSelectPanelLogic();
	}

	/**
	 * If the number of the level is higher than the number of levels unlocked
	 * it should return false
	 */
	static Random rnd = new Random();

	@Test
	public void visableTest() {
		int max = 25, min = 1;

		int counter = 0;

		int unlocked;
		int level;

		for (counter = 0; counter < 1000; counter++) {

			unlocked = rnd.nextInt((max - min) + 1) + min;
			level = rnd.nextInt((max - min) + 1) + min;
			
			//System.out.println(unlocked+" "+level+" c: "+counter);

			if (level> unlocked) {
				
				assertFalse("this should be false",
						system.visable(unlocked, level));
			} else {
				assertTrue("This should be true",
						system.visable(unlocked, level));
			}
		}
		
		//fail("Not yet implemented");
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
