package gameplay;

import gameplay.gameobject.Bomberman;
import gameplay.gameobject.GameActor;
import gameplay.input.InputListener;
import gameplay.pauseMenu.PauseMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    int xCoord;
    int yCoord;
    PauseMenuView pauseMenu;

    private long period = 40 * 1000000;
    // Double buffering
    private Image dbImage;
    private Graphics dbg;

    // Jpanel Variables
    static final int GWIDTH = 992, GHEIGHT = 448;

    static final Dimension gameDim = new Dimension(GWIDTH, GHEIGHT);

    // Game variables

    private Thread game;
    private volatile boolean running = false;

    // GameObjects
    World world;
    ArrayList<GameActor> actorList;

    public GamePanel() {

	setPreferredSize(gameDim);
	setFocusable(true);
	requestFocus();
	loadGameLevel();

	addKeyListener(InputListener.getInstance());
	InputListener.setGamePanel(this);
	setLayout(null);

    }

    private void loadGameLevel() {
	world = new World(31, 13);
	actorList = new ArrayList<GameActor>();
	actorList.add(new Bomberman(world, new Rectangle(32, 32, 32, 32)));
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
	    sleepTime = (period - diff) - overSleepTime;
	    if ((sleepTime < period) && (sleepTime > 0)) {

		try {
		    game.sleep(sleepTime / 1000000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    } else {
		overSleepTime = diff - period;
	    }

	}
    }

    private void gameUpdate() {
	if (running && (game != null)) {

	    for (GameActor actor : actorList) {
		actor.update();
	    }

	    world.update();
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
	world.draw(g);

	for (GameActor actor : actorList) {
	    actor.draw(g);
	}
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
	pauseMenu.setBounds(GWIDTH / 3, 30, 311, 358);

	this.revalidate();
	this.repaint();

    }

}
