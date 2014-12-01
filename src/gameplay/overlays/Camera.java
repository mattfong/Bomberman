package gameplay.overlays;

import gameplay.gameobject.GameActor;

/**
 * Class which controls what portion of the game world is viewed, the camera is
 * 15 blocks wide and pans when bomberman gets to the middle of the view.
 * 
 * @author MF
 *
 */
public class Camera {
    private int x;
    private final int y = 0;
    private GameActor bomberman;

    public Camera(int x, GameActor bomberman) {
	this.bomberman = bomberman;
	this.x = x;
    }

    /**
     * @return the x value of where the camer is currently looking
     */
    public int getX() {
	return x;
    }

    /**
     * Updates the camera location based on the location of bomberman, and stops
     * the camera from panning when either side walls enters the frame.
     */
    public void update() {

	if (bomberman.getXCoordinate() > (6 * 32) && bomberman.getXCoordinate() < (24 * 32)) {
	    x = -bomberman.getXCoordinate() + (7 * 32);
	}
	if (bomberman.getXCoordinate() < 6 * 32) {
	    x = 0;
	}
    }

    /**
     * @return the y value of where the top left corner of the camera should be
     */
    public int getY() {
	return y; // method is only here for consistency, the game does not pan
		  // up or down because the grid is as tall as the camera, if
		  // the grid gets larger in the future this code is set up to
		  // accomodate this change.
    }
}