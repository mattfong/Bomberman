package gameplay.overlays;

import gameplay.World;
import gameplay.gameobject.Bomberman;

import java.io.Serializable;

/**
 * @author MF Class which runs the game timer whcih is displayed to the user.
 */
public class CountdownTimer implements Serializable {

    int countdown;
    private World world;
    private int frameRate = 25;// 25 frames per second, shoud match the frame
			       // rate in the gamepanel engine
    private int counter;

    public CountdownTimer(World world) {
	countdown = 200;
	this.world = world;

	counter = 0;
    }

    /**
     * @return the value of the countdown from when the game started.
     */
    public int getcountdown() {
	return countdown;
    }

    /**
     * drives the countdown, when called if 1 second has passed it will
     * decrement the countdown by 1. Kills bomberman when the countdown reaches
     * 0.
     */
    public void update() {
	counter++;
	if ((counter % frameRate) == 0) {
	    countdown--;
	    if (countdown == 0) {
		if (world != null) {
		    Bomberman bomberman = (Bomberman) world.getBomberman();
		    bomberman.die();
		}
		reset();
	    }
	    counter = 0;
	}
    }

    /**
     * Resets the gametimer back to 200 seconds
     */
    public void reset() {
	countdown = 200;
    }

}
