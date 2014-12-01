package menuView;

//import gameplay.Level;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import savingSystem.SaveLoadController;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class LevelSelectPanel extends JPanel {

	LevelSelectPanelLogic LSPL = new LevelSelectPanelLogic();

	private PanelTransitionManager manager = PanelTransitionManager
			.getInstance();
	SaveLoadController SLC = new SaveLoadController();

	/**
	 * This calls the initUI method
	 */
	public LevelSelectPanel() {
		initUI();
	}

	/**
	 * This creates the panel for the select level menu
	 */
	private void initUI() {
		setLayout(new GridLayout(5, 1, 5, 10));

		int i = 3;

		// i = SLC.maxLevelReachedByUser();
		// THIS LINES GIVES ERRORS!

		int counter, counterPlusOne;
		JButton[] buttons = new JButton[25];
		for (counter = 0; counter < (buttons.length); counter++) {
			counterPlusOne = (counter + 1);
			final int realLevel = counterPlusOne;
			buttons[counter] = new JButton("Lvl " + (counterPlusOne));
			if (LSPL.visable(i, counterPlusOne)) {
				buttons[counter].setContentAreaFilled(true);
				buttons[counter].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("it's good");
						// NEED TO FIX THIS
						LSPL.play(realLevel);
					}
				});

			} else {
				buttons[counter].setContentAreaFilled(false);
				buttons[counter].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						LSPL.locked();
					}
				});
			}

			add(buttons[counter]);

		}

		JButton goBack = new JButton("Go back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = "if you see this there is a serious error.";
				manager.displayPlayGameMenu();
			}
		});
		add(goBack);

	}
}
