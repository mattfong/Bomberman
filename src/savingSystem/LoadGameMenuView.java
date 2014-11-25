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
	private final JTextField deleteGame= new JTextField(30);
	private LoadGameMenuController controller = new LoadGameMenuController();
	
	public void LoadGameMenuView(){
		frame.setVisible(true);
	    frame.setSize(992,448);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    panel.setLayout(new GridLayout(7,1,5,10));
	    
//	    JLabel loadGame = new JLabel("Load Game");
	    JButton loadGame = new JButton("Load Game");
	    JLabel delete = new JLabel("Delete saved game");

	    JButton deleteSavedGame = new JButton("Delete Saved Game");
	    JButton goBack = new JButton("Go Back");
	    JButton closeMenu = new JButton("Close Menu");
	    
	    loadGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				controller.loadGame();
				frame.dispose();
			}
			
		});

	    deleteSavedGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteSavedGame(deleteGame.getText());
				System.out.println("Deleted Saved Game: " + deleteGame.getText());
		//		frame.dispose();	
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

	    panel.add(loadGame);
	    panel.add(delete);
	    panel.add(deleteGame);
	    panel.add(deleteSavedGame);
	    panel.add(goBack);
	    panel.add(closeMenu);
	    frame.add(panel);
	    
	}
	
}
