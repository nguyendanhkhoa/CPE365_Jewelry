import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CustomerRegistrationPage crp = new CustomerRegistrationPage();
		Thread.sleep(5000); //Sleep for 5 seconds
		crp.closeFrame(); // Close the registration window!
	}

}
