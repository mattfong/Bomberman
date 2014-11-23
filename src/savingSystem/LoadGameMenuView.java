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
	private SavedGameManager saveManager = new SavedGameManager();
	private JPanel panel = new JPanel();
	private JTextField jt= new JTextField(30);

	public void LoadGameMenuView(){
		jt.setText(null);
		frame.setVisible(true);
	    frame.setSize(992,448);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel loadGame = new JLabel("Saved Game List");
	    JLabel delete = new JLabel("Enter the saved game name to delete");
	    JButton deleteSavedGame = new JButton("Delete Saved Game");
	    JButton goBack = new JButton("Go Back");
	    JButton closeMenu = new JButton("Close Menu");
	    
	    
	    deleteSavedGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				saveManager.removeSavedGame("userName", jt.getText());
				System.out.println("Removed Saved Game: " + jt.getText());
			}
			
		});
	    
	    goBack.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				SaveLoadView saveLoadMenu = new SaveLoadView();
				saveLoadMenu.SaveLoadView();
				frame.dispose();	
			}
			
		});	

	    closeMenu.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
			}
			
		});

	    panel.setLayout(new GridLayout(7,1,5,10));
	    panel.add(loadGame);
	    panel.add(delete);
	    panel.add(jt);
	    panel.add(deleteSavedGame);
	    panel.add(goBack);
	    panel.add(closeMenu);
	    frame.add(panel);
	    
	}
	
}
