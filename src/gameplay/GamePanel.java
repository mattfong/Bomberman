package gameplay;

import gameplay.gameobject.GameActor;
import gameplay.input.InputListener;
import gameplay.overlays.Camera;
import gameplay.overlays.CountdownTimer;
import gameplay.overlays.HUD;
import gameplay.pauseMenu.PauseMenuView;
import gameplay.statemanagers.GameStateManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * GamePanel acts as the game engine. A Java thread throws an event every 40ms
 * which is caught by the run method. The run method then runs the gameUpdate
 * method which updates all the game elements and then runs the gameRender
 * method which gets all the gameObjects to draw themselves on a graphics object
 * and finally the paintScreen method displays the screens to the user.
 * 
 * @author MF
 *
 */
public class GamePanel extends JPanel implements Runnable {

    int xCoord;
    int yCoord;
    PauseMenuView pauseMenu;

    CountdownTimer timer;

    private long period = 40 * 1000000;
    // Double buffering
    private Image dbImage;
    private Graphics dbg;
    private Camera camera;

    // Jpanel Variables
    static final int GWIDTH = 992, GHEIGHT = 416;

    static final Dimension gameDim = new Dimension(GWIDTH, GHEIGHT);

    // Game variables

    private Thread game;
    private volatile boolean running = false;
    private GameStateManager gameStateManager;

    // GameObjects
    World world;
    ArrayList<GameActor> actorList;

    /**
     * Open the game at the level specified.
     * 
     * @param level
     *            level that is to be loaded.
     */

    public GamePanel(Level level) {
	// panel registration for use by pause system
	gameStateManager = GameStateManager.getInstance();
	gameStateManager.registerGamePanel(this);

	// jpanel stuff
	setPreferredSize(gameDim);
	setFocusable(true);
	requestFocus();

	// set world to a new world
	world = new World(31, 13, level);

	// set the camera, get the actor lists and add a key listener
	camera = new Camera(0, world.getBomberman());
	actorList = world.getActorList();
	addKeyListener(InputListener.getInstance());

	InputListener.setGamePanel(this);
	setLayout(null);

    }

    public GamePanel(World world) {
	// panel registration for use by pause system
	gameStateManager = GameStateManager.getInstance();
	gameStateManager.registerGamePanel(this);

	// jpanel stuff
	setPreferredSize(gameDim);
	setFocusable(true);
	requestFocus();

	// set world to a given room
	this.world = world;

	// set the camera, get actor list from the loaded world and add a key
	// listener
	camera = new Camera(0, world.getBomberman());
	actorList = world.getActorList();
	addKeyListener(InputListener.getInstance());

	InputListener.setGamePanel(this);
	setLayout(null);
    }

    @Override
    public void run() {
	long beforeTime, afterTime, diff, sleepTime, overSleepTime = 0;
	while (running) {
	    beforeTime = System.nanoTime();
	    gameUpdate();
	    gameRender();
	    paintScreen();
	    afterTime = System.nanoTime();
	    diff = afterTime - beforeTime;
	    sleepTime = (period - diff);
	    if ((sleepTime < period) && (sleepTime > 0)) {

		try {
		    game.sleep(sleepTime / 1000000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    } else {
		overSleepTime = diff - period;
	    }
	}
    }

    private void gameUpdate() {
	if (running && (game != null)) {
	    gameStateManager.openScorePoll();

	    for (GameActor actor : actorList) {
		actor.update();
	    }
	    removeDeadActors(actorList);
	    world.update();
	    camera.update();

	    gameStateManager.closeScorePoll();
	}

    }

    private void removeDeadActors(ArrayList<GameActor> actorList) {
	for (int i = 0; i < actorList.size(); i++) {
	    if (actorList.get(i).isDead()) {
		actorList.remove(i);
	    }
	}

    }

    private void gameRender() {
	if (dbImage == null) {// create the buffer
	    dbImage = createImage(GWIDTH, GHEIGHT);
	    if (dbImage == null) {
		System.err.println("dbImage is still null!");
		return;
	    } else {
		dbg = dbImage.getGraphics();
	    }
	}
	// clear the screen
	dbg.setColor(Color.WHITE);
	dbg.fillRect(0, 0, GWIDTH, GHEIGHT);
	// Draw game elements
	draw(dbg);
    }

    /* draw all game stuff in here */
    public void draw(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;

	g2d.translate(camera.getX(), camera.getY());
	world.draw(g);
	for (GameActor actor : actorList) {
	    actor.draw(g);
	}
	g2d.translate(-camera.getX(), camera.getY());
	HUD.draw(g, world.getTimer());

    }

    private void paintScreen() {
	Graphics g;
	try {
	    g = this.getGraphics();
	    if ((dbImage != null) && (g != null)) {
		g.drawImage(dbImage, 0, 0, null);
	    }
	    Toolkit.getDefaultToolkit().sync();// for linux
	    g.dispose();

	} catch (Exception e) {
	    System.err.println(e);
	}

    }

    @Override
    public void addNotify() {
	super.addNotify();
	startGame();

    }

    private void startGame() {
	if ((game == null) || !running) {
	    game = new Thread(this);
	    game.start();
	    running = true;
	}
    }

    public void stopGame() {
	if (running) {
	    running = false;
	}

    }

    private void resumeGame() {
	startGame();
	requestFocus();
    }

    public void closePauseMenu() {
	remove(pauseMenu);
	this.revalidate();
	this.repaint();
	this.resumeGame();

    }

    public void openPauseMenu() {
	stopGame();
	pauseMenu = new PauseMenuView(this);
	this.add(pauseMenu);
	pauseMenu.setBounds((GWIDTH / 7) / 2, 30, 311, 358);

	this.revalidate();
	this.repaint();

    }

    public World getWorld() {
	return world;
    }
}
