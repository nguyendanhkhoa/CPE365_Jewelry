import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by khoanguyen1 on 3/7/17.
 * needs to have execute update
 *
 */
public class CustomerRegistrationPage {
    private JFrame f;
    public CustomerRegistrationPage() {
        f = new JFrame();//creating instance of JFrame



        JLabel pageTitle = new JLabel("Customer Registration Page\n");
        pageTitle.setBounds(300,20,300,50);
        f.add(pageTitle);


        JLabel nameTxt = new JLabel("Fist and Last name:");
        nameTxt.setBounds(200,65,400,50); //x, y, width, height
        f.add(nameTxt);

        JTextField nameField = new JTextField(0);
        nameField.setBounds(200,100,400,30);
        f.add(nameField);

        // User name is:
        JLabel usernameTxt = new JLabel("Username:");
        usernameTxt.setBounds(200,125,400,50); //x, y, width, height
        f.add(usernameTxt);

        JTextField userField = new JTextField(0);
        userField.setBounds(200,160,400,30);
        f.add(userField);

        //Address
        JLabel addressTxt = new JLabel("Address:");
        addressTxt.setBounds(200,185,400,50); //x, y, width, height
        f.add(addressTxt);

        JTextField addressField = new JTextField(0);
        addressField.setBounds(200,220,400,30);
        f.add(addressField);


        //Phone Number
        JLabel numberTxt = new JLabel("Phone Number:");
        numberTxt.setBounds(200,245,400,50); //x, y, width, height
        f.add(numberTxt);

        JTextField numberField = new JTextField(0);
        numberField.setBounds(200,280,400,30);
        f.add(numberField);


        //back Button
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new LandingPage();
                f.setVisible(false);
                f.dispose();
            }
        });
        back.setBounds(250,375,100,50); //x, y, width, height
        f.add(back);

        //Register Button
        JButton register = new JButton("Register");
        register.setBounds(450,375,100,50); //x, y, width, height

        register.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String nameFieldText = nameField.getText();
                String userFieldText = userField.getText();
                String addressFieldText = addressField.getText();
                String numberFieldText = numberField.getText();

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection(
                            "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamond");
                    Statement stmt=con.createStatement();
                    stmt.executeUpdate("Insert into Customers (login_name, name, address, phone) Values ('"+ userFieldText + "', '" +
                            nameFieldText +"', '"+ addressFieldText +"', '"+ numberFieldText +"')");
                    stmt.close();
                    con.commit();
                    con.close();
                }catch(Exception e){ System.out.println(e);}

                System.out.println(nameFieldText + "\n" + userFieldText + "\n" +
                                    addressFieldText + "\n" + numberFieldText + "\n");

                new HomePage(userFieldText);
                f.setVisible(false);
                f.dispose();

            }
        });

        f.add(register);

        f.setSize(800,600);
        f.setLocation(600,200);
        f.setLayout(null);

        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public void closeFrame(){
        f.setVisible(false);
        f.dispose();
    }
}
