import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Created by khoanguyen1 on 3/22/17.
 */
public class Query {

    private JFrame frame;
    public Query() {
        frame = new JFrame();
        JLabel facts = new JLabel("Facts:");
        JButton freqPayType = new JButton("Most Frequent Payment Type");
        JButton mostOrderedItem = new JButton("Most Ordered Item");
        JButton back = new JButton("Back");

        mostOrderedItem.setBounds(100,300,132,35);
        frame.add(mostOrderedItem);

        freqPayType.setBounds(325,300,200,35);
        frame.add(freqPayType);

        back.setBounds(10,10,50,20);
        frame.add(back);

        facts.setBounds(100,100,300,35);
        frame.add(facts);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamond");
            Statement stmt=con.createStatement();
            freqPayType.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ResultSet rsJew = stmt.executeQuery("SELECT type\n" +
                                "FROM payType\n" +
                                "WHERE cnt = (SELECT MAX(cnt) FROM payType);");
                        while(rsJew.next()){
                            System.out.println(rsJew.getString(1) + "   " + rsJew.getInt(2));
                        }

                        stmt.close();
                        con.close();

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

        }catch(Exception e){ System.out.println(e);}

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new LandingPage();
                frame.setVisible(false);
                frame.dispose();
            }
        });

        frame.setTitle("Interesting Query");

        frame.setSize(800,600);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
