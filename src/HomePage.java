import javax.swing.*;
import java.awt.*;

public class HomePage {
	private JFrame frame = new JFrame();
	public HomePage() {
		JButton createJewelry = new JButton("Create Jewelry");
		JButton makePayment = new JButton("Make Payment");
		JButton logout = new JButton("Logout");
		
		createJewelry.setBounds(275,160,260,70);
		frame.add(createJewelry);
		
		makePayment.setBounds(275,290,260,70);
		frame.add(makePayment);
		
		logout.setBounds(20,20,50,20);
		logout.setLocation(740, 10);
		frame.add(logout);
		
		frame.setTitle("Home");
		
		frame.setSize(800,600);
		frame.setLocation(600,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
