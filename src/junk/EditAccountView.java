package junk;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.6 (current version number of program)
 * @since 2014-11-28 (the version of the package this class was first added to)
 */
public class EditAccountView {
	/**
	 * This creates the editMenu Frame and panel                     (1)
	 * <p>
	 * It has three buttons. One to go to a menu that will allow the user to change their name, one that allows the user
	 * to change their password, and one button to go back to the playGameMenu
	 * <p>
	 * 
	 * <p>
	 * The purpose of this method is allow the user to chose what about their account they want to modify. Or they may chose not to. 
	 * <p>
	 */
	public void editMenu() {
		final JFrame frame = new JFrame("edit your account details");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 5, 10));
		
		
		JButton editName = new JButton("Click here to change your name");
		editName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				EditNameView.main(null);
			}
		});
		JButton editPass = new JButton("Click here to change your password");
		editPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				EditPasswordView.main(null);
			}
		});
		
		JButton goBack = new JButton("Click here to go back to the Login Menu");
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				PlayGameView.main(null);
			}
		});
		
		panel.add(editName);
		panel.add(editPass);
		panel.add(goBack);

		
		frame.add(panel);
		//These have to be after the panel add, so that the frame and panel display propely.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 440);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EditAccountView EAV = new EditAccountView();

				EAV.editMenu();
			}
		});
	}
}
