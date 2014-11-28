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
import javax.swing.SwingUtilities;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.6 (current version number of program)
 * @since 2014-11-28 (the version of the package this class was first added to)
 */
public class EditNameView {
	
	public JTextField jt = new JTextField(30);

	public void editNameMenu() {
		
		final JFrame frame = new JFrame("edit name");
		jt.setText(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 5, 10));
		
		JLabel enterName = new JLabel("Enter your desierd name here");
		
		
		JButton editName = new JButton("Once you have entered your new name, click here to change it");
		editName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String newName = jt.getText();
				//DO SOMETHING WITH THIS
				frame.dispose();
				EditNameView.main(null);
			}
		});
		
		JButton goBack = new JButton("Click here to go back one menu");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				EditAccountView.main(null);
			}
		});
		
		panel.add(enterName);
		panel.add(jt);
		panel.add(editName);
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
				EditNameView ENV = new EditNameView();

				ENV.editNameMenu();
			}
		});
	}
}
