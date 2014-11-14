package gameplay;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;



public class GameObjectTest {

	@Test
	public void testHasCollided() {
		MockGameObject center=new MockGameObject(new Rectangle(32,32,32,32));
		MockGameObject left=new MockGameObject(new Rectangle(0,32,32,32));
		MockGameObject right=new MockGameObject(new Rectangle(64,32,32,32));
		MockGameObject up=new MockGameObject(new Rectangle(32,0,32,32));
		MockGameObject down=new MockGameObject(new Rectangle(32,64,32,32));
		MockGameObject upperLeft=new MockGameObject(new Rectangle(0,0,32,32));
		MockGameObject upperRight=new MockGameObject(new Rectangle(64,0,32,32));
		MockGameObject lowerLeft=new MockGameObject(new Rectangle(0,64,32,32));
		MockGameObject lowerRight=new MockGameObject(new Rectangle(64,64,32,32));
		MockGameObject coincident=new MockGameObject(new Rectangle(32,32,32,32));

		
		//tests collision along all edges and tips around a central box
		assertFalse(center.hasCollided(up));
		assertFalse(center.hasCollided(down));
		assertFalse(center.hasCollided(left));
		assertFalse(center.hasCollided(right));
		assertFalse(center.hasCollided(upperLeft));
		assertFalse(center.hasCollided(upperRight));
		assertFalse(center.hasCollided(lowerLeft));
		assertFalse(center.hasCollided(lowerRight));
		
		
		//tests collisions with itself and an coinciding box
		assertTrue(center.hasCollided(center));
		assertTrue(center.hasCollided(coincident));
		
	}

}
