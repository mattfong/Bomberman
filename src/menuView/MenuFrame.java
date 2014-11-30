package menuView;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MenuFrame extends JFrame {

	public MenuFrame(String title) {
		super(title);
		// WindowUtilities.setNativeLookAndFeel();
		//Container content = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//content.setSize(480, 440);
		setSize(480, 440);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new MenuFrame("This is a frame");
				frame.setVisible(true);
			}
		});

	}
}
