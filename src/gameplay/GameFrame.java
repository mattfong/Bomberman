package gameplay;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
	initUI();

    }

    private void initUI() {
	add(new GamePanel());
	setSize(480, 440);
	setTitle("Bomberman");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
    }

    public static void main(String[] args) {

	GameStateManager manager = GameStateManager.getInstance();
	manager.setCurrentGameState(new GameState(100));

	GameFrame gameFrame = new GameFrame();
	gameFrame.setVisible(true);

    }

}
