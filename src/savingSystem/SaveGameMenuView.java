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
	static JTextField jt= new JTextField(30);
	static String savedGameName = "";
	
	public static void SaveGameMenuView(){
		JPanel panel = new JPanel();
		final JFrame frame = new JFrame("Save Game Menu");
		frame.setVisible(true);
	    frame.setSize(400, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel gameName = new JLabel("Enter a name to save your game");
	    JButton saveGame = new JButton("Save Game");
	    JButton closeMenu = new JButton("Close Menu");
	    
	    savedGameName = jt.getText(); 
	    
	    closeMenu.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();	
			}
			
		});	

	    panel.setLayout(new GridLayout(4,1,5,10));
	    panel.add(gameName);
	    panel.add(jt);
	    panel.add(saveGame);
	    panel.add(closeMenu);
	    frame.add(panel);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaveGameMenuView();
	}
	
}
