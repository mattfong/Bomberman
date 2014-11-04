package loginSystem;
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
	
	public static void notYet()
	{
		final JFrame frame2=new JFrame("not yet");
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(300, 400);
		JPanel comingSoon = new JPanel();
		comingSoon.setLayout(new GridLayout(2,1,5,10));
		JLabel myLabel = new JLabel("This feature is not avalibe yet");
		myLabel.setVisible(true);
		JButton goBack = new JButton("Go back to the Play menu");
		goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame2.dispose();
				playMenu();	
			}
		});	
		comingSoon.add(myLabel);
		comingSoon.add(goBack);
		frame2.add(comingSoon);
		
		
	}
	
	
	public static void playMenu()
	{
		final JFrame frame=new JFrame("Bomberman");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		
		JPanel panel = new JPanel();

		
		panel.setLayout(new GridLayout(4,1,5,10));
		JButton play =new JButton("Play Game");
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				notYet();	
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
				notYet();	
			}
		});	
		JButton logOut =new JButton("Log Out"); 
		logOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LoginMenu.loginMenu();	
			
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
