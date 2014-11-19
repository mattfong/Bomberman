package savingSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoadGameMenuView {

	private List<SavedGame> savedGames = new ArrayList<SavedGame>();
	
	public static void LoadGameMenuView(){
		final JFrame frame = new JFrame("Load Game Menu");
		frame.setVisible(true);
	    frame.setSize(992,448);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JButton loadGame = new JButton("Load Game");
	    JButton deleteSavedGame = new JButton("Delete Saved Game");
	    JButton closeMenu = new JButton("Close Menu");
	    
	    closeMenu.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
			}
			
		});

	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(3,1,5,10));
	    panel.add(loadGame);
	    panel.add(deleteSavedGame);
	    panel.add(closeMenu);
	    frame.add(panel);
	    
	}
	
	public static void main(String[] args) {

		LoadGameMenuView();
	}
}
