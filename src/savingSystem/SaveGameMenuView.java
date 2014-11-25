package savingSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SaveGameMenuView {
	private JTextField jt= new JTextField(30);
	private String savedGameName = ""; 
	private SaveGameMenuController saveController = new SaveGameMenuController();
	private final JFrame frame = new JFrame("Save Game Menu");

	public void SaveGameMenuView(){
		JPanel panel = new JPanel();
		frame.setVisible(true);
	    frame.setSize(480, 440);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel gameName = new JLabel("Enter a name to save your game");
	    JButton saveGame = new JButton("Save Game");
	    JButton goBack = new JButton("Go Back");
	    JButton closeMenu = new JButton("Close Menu");
		
	    saveGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				savedGameName = jt.getText();
				saveController.saveGame(savedGameName);
			}
		});

	    goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				SaveLoadView saveLoadView = new SaveLoadView();
				saveLoadView.SaveLoadView();
				frame.dispose();	
			}
		});

	    closeMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
			}
		});	

	    panel.setLayout(new GridLayout(5,1,5,10));
	    panel.add(gameName);
	    panel.add(jt);
	    panel.add(saveGame);
	    panel.add(goBack);
	    panel.add(closeMenu);
	    frame.add(panel);
	
	}
	
}