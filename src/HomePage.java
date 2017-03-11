import javax.swing.*;
import java.awt.*;

public class HomePage {
	private JFrame frame = new JFrame();
	public HomePage() {
		JButton createPiece = new JButton("Create Jewelry Piece");
		JButton makePayment = new JButton("Make Payment");
		JButton logout = new JButton("Logout");
		
		createPiece.setBounds(50,50,150,50);
		createPiece.setLocation(175,65);
		frame.add(createPiece);
		
		makePayment.setBounds(50,50,150,50);
		makePayment.setLocation(175,140);
		frame.add(makePayment);
		
		logout.setBounds(20,20,50,20);
		logout.setLocation(440, 10);
		frame.add(logout);
		
		frame.setTitle("Home");
		
		frame.setSize(500,300);
		frame.setLocation(600,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
