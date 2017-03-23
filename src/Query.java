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
        JButton mostOrderedJew = new JButton("Most Popular Jewelry");
        JButton mostOrderedMetal = new JButton("Most Popular Metal");
        JButton mostOrderedGem = new JButton("Most Popular Gem");

        JButton mostValueableCustomer = new JButton("Most Valuable Customer");


        JButton back = new JButton("Back");

        mostOrderedJew.setBounds(100,300,180,35);
        frame.add(mostOrderedJew);

        mostOrderedMetal.setBounds(100,380,180,35);
        frame.add(mostOrderedMetal);

        mostOrderedGem.setBounds(100,460,180,35);
        frame.add(mostOrderedGem);

        mostValueableCustomer.setBounds(325,380,200,35);
        frame.add(mostValueableCustomer);

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
                        stmt.execute("DROP VIEW IF EXISTS payType;");
                        stmt.execute(
                                "CREATE VIEW payType AS\n" +
                                "(SELECT\n" +
                                "  P.type,\n" +
                                "  count(*) AS cnt\n" +
                                "FROM Payments AS P\n" +
                                "GROUP BY P.type);");

                        ResultSet rsJew = stmt.executeQuery("SELECT type\n" +
                                "FROM payType\n" +
                                "WHERE cnt = (SELECT MAX(cnt) FROM payType);");
                        while(rsJew.next()){
                            facts.setText(rsJew.getString(1) + " is the most frequent payment type.");
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            mostValueableCustomer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        stmt.execute("DROP VIEW IF EXISTS X;");
                        stmt.execute("CREATE VIEW X AS (SELECT\n" +
                                "                    login_name,\n" +
                                "                    sum(amount) AS spent\n" +
                                "                  FROM Payments AS P\n" +
                                "                  GROUP BY P.login_name);");

                        ResultSet rsJew = stmt.executeQuery("SELECT\n" +
                                "  login_name,\n" +
                                "  spent\n" +
                                "FROM X\n" +
                                "WHERE spent = (SELECT max(spent)\n" +
                                "               FROM X);");
                        while(rsJew.next()){
                            facts.setText(rsJew.getString(1) + " is our most valuable customer.");
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            mostOrderedGem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
//                        Statement stmt=con.createStatement();
                        stmt.execute("DROP VIEW IF EXISTS Y;");
                        stmt.execute("DROP VIEW IF EXISTS M;");

                        stmt.execute("CREATE VIEW Y AS (\n" +
                                "  SELECT\n" +
                                "    gem,\n" +
                                "    count(*) AS cnt\n" +
                                "  FROM Orders\n" +
                                "  GROUP BY gem);");
                        stmt.execute("CREATE VIEW M AS (\n" +
                                "  SELECT max(cnt) AS max\n" +
                                "  FROM Y\n" +
                                ");");

                        ResultSet rsJew = stmt.executeQuery("SELECT name\n" +
                                "FROM M, Gems, Y\n" +
                                "WHERE Gems.g_id = Y.gem AND Y.cnt = M.max;");
                        while(rsJew.next()){
                            facts.setText(rsJew.getString(1) + " is our most popular gem.");
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            mostOrderedJew.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
//                        Statement stmt=con.createStatement();
                        stmt.execute("DROP VIEW IF EXISTS Y3;");
                        stmt.execute("DROP VIEW IF EXISTS M3;");

                        stmt.execute("CREATE VIEW Y3 AS (\n" +
                                "  SELECT\n" +
                                "    jewelry,\n" +
                                "    count(*) AS cnt\n" +
                                "  FROM Orders\n" +
                                "  GROUP BY jewelry);");

                        stmt.execute("CREATE VIEW M3 AS (\n" +
                                "  SELECT max(cnt) AS max\n" +
                                "  FROM Y3\n" +
                                ");");
                        ResultSet rsJew = stmt.executeQuery("SELECT name\n" +
                                "FROM M3, Jewelry, Y3\n" +
                                "WHERE Jewelry.j_id = Y3.jewelry AND Y3.cnt = M3.max;");
                        while(rsJew.next()){
                            facts.setText(rsJew.getString(1) + " is our most popular Jewelry.");
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            mostOrderedMetal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
//                        Statement stmt=con.createStatement();
                        stmt.execute("DROP VIEW IF EXISTS Y2;");
                        stmt.execute("DROP VIEW IF EXISTS M2;");
                        stmt.execute("CREATE VIEW Y2 AS (\n" +
                                "  SELECT\n" +
                                "    metal,\n" +
                                "    count(*) AS cnt\n" +
                                "  FROM Orders\n" +
                                "  GROUP BY metal);\n" +
                                "\n");
                        stmt.execute("CREATE VIEW M2 AS (\n" +
                                "  SELECT max(cnt) AS max\n" +
                                "  FROM Y2\n" +
                                ");");
                        ResultSet rsJew = stmt.executeQuery("SELECT name\n" +
                                "FROM M2, Metals, Y2\n" +
                                "WHERE Metals.m_id = Y2.metal AND Y2.cnt = M2.max;");
                        while(rsJew.next()){
                            facts.setText(rsJew.getString(1) + " is our most popular metal.");
                        }

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
