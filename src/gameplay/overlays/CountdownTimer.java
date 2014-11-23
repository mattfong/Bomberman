	package gameplay.overlays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class CountdownTimer implements ActionListener {

    Timer timer;
    int countdown;

    public static void main(String[] args) {
	CountdownTimer count = new CountdownTimer();
	while (count.getcountdown() > 0) {
	    System.out.println(count.getcountdown());
	}
    }

    public int getcountdown() {
	return countdown;
    }

    public CountdownTimer() {
	countdown = 200;
	timer = new Timer(1000, this);
	timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	countdown--;
	if (countdown == 0) {
	    countdown = 200;
	}
    }

}
