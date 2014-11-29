package gameplay.overlays;

import gameplay.statemanagers.GameStateManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

    public static void draw(Graphics g, CountdownTimer timer) {
	GameStateManager stateManager = GameStateManager.getInstance();
	g.setFont(new Font("Arial", Font.BOLD, 24));
	g.setColor(Color.YELLOW);
	// int score = player.getScore();
	g.drawString("Score: " + stateManager.getScore(), 30, 23);
	g.drawString("Lives: " + stateManager.getCurrentGameState().getRemainingLives(), 240, 23);
	g.drawString("Time: " + timer.getcountdown(), 350, 23);
    }

}
