package loginSystem;

import gameplay.GameFrame;
import gameplay.Level;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LevelSelectView {
    JTextField jt = new JTextField(30);

    public int intoInt(String number) {
	return Integer.parseInt(number);
    }

    public LevelSelectView() {
	jt.setText(null);
	final JFrame f = new JFrame("Enter Level");
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2, 1, 5, 10));
	f.setVisible(true);

	JButton goToLevel = new JButton("Enter your desired level and click here. Only enter numbers.");
	goToLevel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		String toInt;
		int levelSelected = 0;
		toInt = jt.getText();
		levelSelected = intoInt(toInt);
		if (levelSelected == 11) {
		    GameStateManager manager = GameStateManager.getInstance();
		    GameState state = manager.getCurrentGameState();
		    state.setLevel(Level.L11);
		}
		GameFrame gameplay = new GameFrame();
		gameplay.setVisible(true);
		f.dispose();

	    }
	});
	panel.add(jt);
	panel.add(goToLevel);
	f.add(panel);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(480, 440);
	f.setLocationRelativeTo(null);
	f.setResizable(false);
	f.setVisible(true);

    }

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(new Runnable() {
    // @Override
    // public void run() {
    // LevelSelectView PMV = new LevelSelectView();
    //
    // PMV.levelSelectMenu();
    // }
    // });
    // }
}
