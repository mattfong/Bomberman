package savingSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoadGameMenuView {

	private List<SavedGame> savedGames = new ArrayList<SavedGame>();
	private final JFrame frame = new JFrame("Load Game Menu");
	private JPanel panel = new JPanel();
	private final JTextField deleteGame = new JTextField(30);
	private SaveLoadController controller = new SaveLoadController();
	
	public void LoadGameMenuView(){
		frame.setVisible(true);
	    frame.setSize(480, 440);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    panel.setLayout(new GridLayout(7,1,5,10));
	    
	    JLabel loadGameLabel = new JLabel("Load Game");
	    JLabel deleteGameLabel = new JLabel("Delete saved game");
	    
	    JButton loadGameButton = new JButton("Load Game");
	    JButton deleteSavedGameButton = new JButton("Delete Saved Game");
	    JButton goBackButton = new JButton("Go Back");
	    JButton closeMenuButton = new JButton("Close Menu");
	    
	    loadGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.loadGame();
				frame.dispose();
			}
		});

	    deleteSavedGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteGame(deleteGame.getText());
				System.out.println("Deleted Saved Game: " + deleteGame.getText());
		//		frame.dispose();	
			}
		});

	    goBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				SaveLoadView saveLoadView = new SaveLoadView();
				saveLoadView.SaveLoadView();
				frame.dispose();	
			}
		});

	    closeMenuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
			}
		});

	    panel.add(loadGameLabel);
	    panel.add(deleteGameLabel);
	    panel.add(deleteGame);
	    panel.add(loadGameButton);
	    panel.add(deleteSavedGameButton);
	    panel.add(goBackButton);
	    panel.add(closeMenuButton);
	    frame.add(panel);
	    
	}
	
}
