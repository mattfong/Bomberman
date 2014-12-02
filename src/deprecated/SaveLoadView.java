package deprecated;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import savingSystem.SaveLoadController;

public class SaveLoadView {

    private final JFrame frame = new JFrame("Save Load Game Menu");
    private SaveLoadController controller = new SaveLoadController();

    public void SaveLoadView() {
	frame.setVisible(true);
	frame.setSize(480, 440);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setLayout(new GridLayout(3, 1, 5, 10));

	JButton save = new JButton("Save Game");
	JButton load = new JButton("Load Game");
	JButton goBack = new JButton("Go back");

	save.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		controller.displaySaveGameMenu();
		frame.dispose();
	    }
	});

	load.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		controller.displayLoadGameMenu();
		frame.dispose();
	    }
	});

	goBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		PlayGameView playGameView = new PlayGameView();
		playGameView.playMenu();
	    }
	});

	/*
	 * panel.add(save); panel.add(load); panel.add(goBack);
	 * frame.add(panel);
	 */
	frame.add(save);
	frame.add(load);
	frame.add(goBack);
    }
}
