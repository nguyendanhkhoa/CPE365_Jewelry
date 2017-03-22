import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by khoanguyen1 on 3/22/17.
 */
public class Payment {
    private JFrame frame;
    public Payment(String user) {
        frame = new JFrame();
        JButton logout = new JButton("Logout");


        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
//                        "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamonxd");
                    "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamond");
            Statement stmt=con.createStatement();
/*            ResultSet rsJew = stmt.executeQuery("select * from Jewelry");
            while(rsJew.next())
                Jew.add(new Jew(rsJew.getInt(1), rsJew.getString(2), rsJew.getDouble(3)));

            ResultSet rsGem = stmt.executeQuery("select * from Gems");
            while(rsGem.next())
                Gem.add(new Gem(rsGem.getInt(1), rsGem.getString(2), rsGem.getDouble(3)));

            ResultSet rsMetals = stmt.executeQuery("select * from Metals");
            while(rsMetals.next())
                Metal.add(new Metal(rsMetals.getInt(1), rsMetals.getString(2), rsMetals.getDouble(3)));*/

            stmt.close();
            con.close();

        }catch(Exception e){ System.out.println(e);}


        /*String[] columnNames = {"Order ID",
                "Jewelry",
                "Metal",
                "Gem",
                "Price"};

        Object[][] data = {
                {"1", "ring",
                        "gold", "diamond", 1000},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };*/

        String[] s = {"Order ID", "Jewelry", "Metal", "Gem", "Price",
                "1", "ring", "gold", "diamond", "1000",
                "2", "necklace", "silver", "diamond", "500"};
        String newS = "";
        for (int i = 0; i < s.length; i++) {
            if (i%5 == 0) {
                newS += s[i] + "\n";
            }
            else {
                newS += s[i] + "\t";
            }
        }

        System.out.println("newS: \n" + newS);

        //JTable table = new JTable(data, columnNames);
        /*JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);*/
        javax.swing.table.TableColumn column = null;
        /*for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 2) {
                column.setPreferredWidth(100); //third column is bigger
            } else {
                column.setPreferredWidth(50);
            }
        }

        table.setBounds(10,10, 400, 300);
        frame.add(table);*/



        logout.setBounds(20, 20, 50, 20);
        logout.setLocation(740, 10);
        frame.add(logout);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                frame.dispose();
                new LandingPage();
            }
        });

        frame.setTitle("Payment");

        frame.setSize(800,600);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
