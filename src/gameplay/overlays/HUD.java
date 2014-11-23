package gameplay.overlays;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

    public static void draw(Graphics g) {
	g.setFont(new Font("Arial", Font.BOLD, 24));
	g.setColor(Color.YELLOW);
	// int score = player.getScore();
	g.drawString("Score: ", 10, 30);
    }

}
