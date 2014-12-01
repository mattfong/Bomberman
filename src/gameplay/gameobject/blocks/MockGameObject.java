package gameplay.gameobject.blocks;

import gameplay.World;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;

/**
 * Class is an implementation of abstract GameObject class meant to use for
 * testing.
 * 
 * @author mfong8
 */
public class MockGameObject extends GameObject {

    public MockGameObject(Rectangle location, World world) {
	super(location, world);

    }

}
