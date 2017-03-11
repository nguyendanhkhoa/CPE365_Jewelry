import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
	private JFrame frame = new JFrame();
	public LandingPage() {
		JButton newCustomer = new JButton("New Customer");
		JButton login = new JButton("Login");
		JButton logout = new JButton("Logout");
		JTextField usernameText = new JTextField(50);
		JLabel username = new JLabel("Username:");
		
		username.setBounds(255,180,100,35);
		frame.add(username);
		usernameText.setBounds(325,180,200,35);
		frame.add(usernameText);

		login.setBounds(325,240,132,35);
		frame.add(login);
		
		newCustomer.setBounds(325,350,132,35);
		frame.add(newCustomer);
		
		logout.setBounds(740,10,50,20);
		frame.add(logout);
		
		frame.setTitle("Customized Jewelry");
		
		frame.setSize(800,600);
		frame.setLocation(600,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}
