import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
	private JFrame frame = new JFrame();
	public HomePage(String user) {
		JButton createJewelry = new JButton("Create Jewelry");
		JButton makePayment = new JButton("Make Payment");
		JButton logout = new JButton("Logout");
		
		createJewelry.setBounds(275,160,260,70);
		frame.add(createJewelry);

		createJewelry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new MakeJewelry(user);
				frame.setVisible(false); // close current window
				frame.dispose();
			}
		});

		makePayment.setBounds(275,290,260,70);
		frame.add(makePayment);
		
		logout.setBounds(20,20,50,20);
		logout.setLocation(740, 10);
		frame.add(logout);
		
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	frame.setVisible(false);
				frame.dispose();
				new LandingPage();
            }
        });
		
		frame.setTitle("Home");
		
		frame.setSize(800,600);
		frame.setLocation(600,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
