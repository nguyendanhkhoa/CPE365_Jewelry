import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame {
	private JFrame frame;
	public LandingPage() {
		frame = new JFrame();
		JButton newCustomer = new JButton("New Customer");
		JButton login = new JButton("Login");
		JButton logout = new JButton("Logout");
		final JTextField usernameText = new JTextField(0);
		JLabel username = new JLabel("Username:");
		
		

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String saveUsername = usernameText.getText();
                new HomePage();
                frame.setVisible(false); // close current window
                frame.dispose();
                System.out.println("username: " + saveUsername);
            }
        });
        newCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	new CustomerRegistrationPage();
                frame.setVisible(false); // close current window
                frame.dispose();
            }
        });
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	new LandingPage();
                frame.setVisible(false); // close current window
                frame.dispose();
            }
        });
		
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

	public void setFrameVisible(boolean isVisible){
		frame.setVisible(isVisible);

	}

}
