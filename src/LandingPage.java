import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
	private JFrame frame = new JFrame();
	public LandingPage() {
		JButton newCustomer = new JButton("New Customer");
		JButton login = new JButton("Login");
		JButton logout = new JButton("Logout");
		
		newCustomer.setBounds(50,50,150,50);
		newCustomer.setLocation(175,65);
		frame.add(newCustomer);
		
		login.setBounds(50,50,150,50);
		login.setLocation(175,140);
		frame.add(login);
		
		logout.setBounds(20,20,50,20);
		logout.setLocation(440, 10);
		frame.add(logout);
		
		frame.setTitle("Customized Jewelry");
		
		frame.setSize(500,300);
		frame.setLocation(600,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}
