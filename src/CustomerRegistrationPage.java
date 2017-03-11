import javax.swing.*;
import java.awt.*;

/**
 * Created by khoanguyen1 on 3/7/17.
 * needs to have execute update
 *
 */
public class CustomerRegistrationPage {
    private JFrame f;
    public CustomerRegistrationPage() {
        f = new JFrame();//creating instance of JFrame
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.PAGE_AXIS));
        top.add(new JLabel("Customer Registration Page\n"){{
            setForeground(Color.BLACK);
        }});
        top.add( new JLabel("What is your name"){{
            setForeground(Color.BLACK);
        }});
        top.add( new JTextField(10) );

        top.add( new JLabel("Enter an username:"){{
            setForeground(Color.BLACK);
        }});
        top.add( new JTextField(10) );

        top.add( new JLabel("Address:"){{
            setForeground(Color.BLACK);
        }});
        top.add( new JTextField(10) );

        top.add( new JLabel("Phone Number:"){{
            setForeground(Color.BLACK);
        }});
        top.add( new JTextField(10) );

        JButton back = new JButton("Back");
        JButton confirm = new JButton("Confirm");

        top.add(back);
        top.add(confirm);


        f.add( top );

        f.setSize(1400,800);//400 width and 500 height
//        f.pack();

        f.setVisible(true);//making the frame visible
    }

    public void closeFrame(){
        f.setVisible(false);
        f.dispose();
    }
}
