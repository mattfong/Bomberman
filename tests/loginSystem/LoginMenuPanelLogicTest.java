package loginSystem;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import menuView.menuLogic.LoginMenuPanelLogic;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author philip
 * 
 */
public class LoginMenuPanelLogicTest {
    private LoginMenuPanelLogic system = new LoginMenuPanelLogic();

    @Before
    public void setUp() throws Exception {
	system = new LoginMenuPanelLogic();
    }

    /**
     * pass must be 8 characters long with 1 upper, one lower 1 number and one
     * special user must be 6 long and only numbers or letters
     * 
     * 
     */

    static Random rnd = new Random();
    // static final String pass =
    // "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()?";
    // static final String user =
    // "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()?";

    /*
     * String randomPass(int len) { StringBuilder sb = new StringBuilder(len);
     * for (int i = 0; i < len; i++)
     * sb.append(pass.charAt(rnd.nextInt(pass.length()))); return sb.toString();
     * }
     * 
     * String randomUser(int len) { StringBuilder sb = new StringBuilder(len);
     * for (int i = 0; i < len; i++)
     * sb.append(user.charAt(rnd.nextInt(user.length()))); return sb.toString();
     * }
     */
    static final String user = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()?";

    String randomString(int len) {
	StringBuilder sb = new StringBuilder(len);
	for (int i = 0; i < len; i++)
	    sb.append(user.charAt(rnd.nextInt(user.length())));
	return sb.toString();
    }

    /**
     * This is to test the vaild method. I calls a fake key press and mouse
     * click to close the controlling frame Please note that you must have and
     * uptodate JRE, as other wise it will not work
     * 
     * @throws HeadlessException
     * @throws IOException
     * @throws AWTException
     */
    @Test
    public void testValid() throws HeadlessException, IOException, AWTException {
	int k, i = 0, uLength, pLength, max = 20, min = 0;
	boolean userValid = false;
	boolean passValid = false;
	boolean ULcase = false, passUC = false, userUC = false;
	boolean passLC = false;
	boolean areThereNumbers;

	Robot bot = new Robot();

	for (k = 0; k < 1000; k++) {
	    uLength = rnd.nextInt((max - min) + 1) + min;
	    pLength = rnd.nextInt((max - min) + 1) + min;
	    String user = randomString(uLength);
	    String pass = randomString(pLength);
	    System.out.println(user + " " + pass);

	    userValid = user.matches("\\w+");
	    passValid = pass.matches("\\w+");
	    areThereNumbers = pass.matches(".*\\d+.*");

	    // ad in account manager test
	    // add in username with no non standard charircwrs.
	    bot.mouseMove(675, 400);
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	    // add time between press and release or the input event system may
	    // not think it is a click
	    try {
		Thread.sleep(250);
	    } catch (InterruptedException e) {
	    }
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);

	    if (uLength < 6) {
		assertFalse("this should be false", system.valid(user, pass));
		// bot.keyPress(KEY_ENTER);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);
	    }

	    if (pLength < 8) {
		assertFalse("this should be false", system.valid(user, pass));
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);

	    }

	    // user valid

	    for (i = 0; i < pLength - 1; i++) {
		ULcase = Character.isUpperCase(pass.charAt(i));
		if (ULcase) {
		    passUC = true;
		}// end else

	    }
	    if (!passUC) {
		assertFalse("this should be false", system.valid(user, pass));
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);

	    }
	    for (i = 0; i < pLength - 1; i++) {
		ULcase = Character.isLowerCase(pass.charAt(i));
		if (ULcase) {
		    passLC = true;
		}// end else
	    }
	    if (!passLC) {
		assertFalse("this should be false", system.valid(user, pass));
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);

	    }
	    // gets an upper or lower case

	    else if (!areThereNumbers) {
		assertFalse("this should be false", system.valid(user, pass));
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);

	    }

	    else if (passValid) {
		assertFalse("this should be false", system.valid(user, pass));
		bot.mousePress(InputEvent.BUTTON1_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);

	    }// password needs one speical case
	     // password must have one of each the following:upper case,
	     // lower case, number speical
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	    bot.keyPress(KeyEvent.VK_ENTER);
	    bot.keyRelease(KeyEvent.VK_ENTER);

	}

	// fail("Not yet implemented");
    }

    @Test
    public void test() {
	// fail("Not yet implemented");
    }

}