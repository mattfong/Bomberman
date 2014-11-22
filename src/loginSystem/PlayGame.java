package loginSystem;
import gameplay.GameFrame;
import highscore.HighScoreController;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PlayGame {
	
	
	static JTextField jt= new JTextField(30);
	static JTextField ft =new JTextField(30);
	private final JFrame frame=new JFrame("not yet");
	//static JFrame frame= new LoginFrame();
	
	public void notYet() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(992,448);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel comingSoon = new JPanel();
		comingSoon.setLayout(new GridLayout(2,1,5,10));
		JLabel myLabel = new JLabel("This feature is not avalibe yet");
		myLabel.setVisible(true);
		JButton goBack = new JButton("Go back to the Play menu");
		goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				playMenu();	
			}
		});	
		comingSoon.add(myLabel);
		comingSoon.add(goBack);
		frame.add(comingSoon);
		
		
	}
	
	
	public void playMenu()
	{
		final JFrame frame=new JFrame("Bomberman");
		//JFrame frame=new LoginFrame.LoginFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(992,448);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		JPanel panel = new JPanel();
		//panel.setBackground(Color.RED);

		
		panel.setLayout(new GridLayout(4,1,5,10));
		JButton play =new JButton("Play Game");
		//play.setBackground(Color.green);
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("New Game Frame");
				GameFrame gameplay=new GameFrame();
				gameplay.setVisible(true);
				frame.dispose();
			}
		});		
		JButton saved =new JButton("Load Saved game"); 
		saved.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				notYet();	
			}
		});	
		JButton high =new JButton("High Scores");
		high.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//notYet();	
				HighScoreController.displayHighScore();
			}
		});	
		JButton logOut =new JButton("Log Out"); 
		logOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LoginMenu loginMenu = new LoginMenu();
				loginMenu.loginMenu();	
			
			}
		});	
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(play);
		panel.add(saved);
		panel.add(high);
		panel.add(logOut);
		frame.add(panel);
		
		
	}
	 
}
