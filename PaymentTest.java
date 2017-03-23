import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;


/**
 * Created by khoanguyen1 on 3/22/17.
 */
public class Payment {
    private JFrame frame;
    ArrayList<Jew> Jew = new ArrayList<>();
    ArrayList<Gem> Gem = new ArrayList<>();
    ArrayList<Metal> Metal = new ArrayList<>();

    public Payment(String user) {
        frame = new JFrame();
        JButton logout = new JButton("Logout");
        JButton payNow = new JButton("Pay now and return to Home Page");

        JRadioButton creditCard = new JRadioButton("Credit Card");
        JRadioButton cash = new JRadioButton("Cash");
        JRadioButton check = new JRadioButton("Check");
        final String[] paymentType = {""};

        ButtonGroup group = new ButtonGroup();
        group.add(creditCard);
        group.add(cash);
        group.add(check);

        creditCard.setBounds(350,380,250,70);  //***
        cash.setBounds(350,380,250,70);  //***
        check.setBounds(350,380,250,70);  //***
        frame.add(creditCard);
        frame.add(cash);
        frame.add(check);

        creditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                paymentType[0] = "Credit Card";
             }
        });
        cash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                paymentType[0] = "Credit Card";
            }
        });
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                paymentType[0] = "Credit Card";
            }
        });

        ArrayList<Order> orders = new ArrayList<Order>();
        String orderTable = "<html>";
        String[] orderCategories = {"Order ID", "Jewelry", "Metal", "Gem", "Price"};

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamond");
            Statement stmt=con.createStatement();
            ResultSet rsOrder = stmt.executeQuery("select O.o_id, O.jewelry, O.metal, O.gem, O.price from Orders O where O.paid = FALSE AND O.login_name = '" + user + "'");
            while(rsOrder.next())
                orders.add(new Order(rsOrder.getInt(1), rsOrder.getInt(2), rsOrder.getInt(3), rsOrder.getInt(4), rsOrder.getDouble(5)));
            ResultSet rsJew = stmt.executeQuery("select * from Jewelry");
            while(rsJew.next())
                Jew.add(new Jew(rsJew.getInt(1), rsJew.getString(2), rsJew.getDouble(3)));

            ResultSet rsGem = stmt.executeQuery("select * from Gems");
            while(rsGem.next())
                Gem.add(new Gem(rsGem.getInt(1), rsGem.getString(2), rsGem.getDouble(3)));

            ResultSet rsMetals = stmt.executeQuery("select * from Metals");
            while(rsMetals.next())
                Metal.add(new Metal(rsMetals.getInt(1), rsMetals.getString(2), rsMetals.getDouble(3)));

            stmt.close();
            con.close();

        }catch(Exception e){ System.out.println(e);}

        for (int i = 0; i < orders.size(); i++) {
            orderTable += String.format("$%.2f - %s, %s, %s<br>", orders.get(i).price,
                    getMetalByID(orders.get(i).metal), getGemByID(orders.get(i).gem), getJewByID(orders.get(i).jewelry));
        }
        orderTable += "-------------------------------------------------<br>";
        orderTable += String.format("$%.2f - Total</html>", calcTotalPrice(orders));
        System.out.println(orderTable);

        JLabel unpaidOrders = new JLabel("Unpaid Orders for " + user);
        JLabel dottedLine = new JLabel("<html>-------------------------------------------------<br></html>");
        JLabel displayOrders = new JLabel(orderTable);

        unpaidOrders.setBounds(300, -40, 300, 300);
        dottedLine.setBounds(300, -20, 300, 300);
        displayOrders.setBounds(300, 80, 300, 300);
        frame.add(unpaidOrders);
        frame.add(dottedLine);
        frame.add(displayOrders);

        logout.setBounds(740, 0, 50, 20);
        frame.add(logout);

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                frame.dispose();
                new LandingPage();
            }
        });

        payNow.setBounds(270,350,250,70);  //***
        frame.add(payNow);

        payNow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202", "knguy202", "diamond");
                    Statement stmt = con.createStatement();

                    for (int i = 0; i < orders.size(); i++) {
                        stmt.executeUpdate("update Orders set paid = TRUE where o_id = " + orders.get(i).o_id);
                        stmt.executeUpdate("insert into Payment(login_name, type, amount, date) values('"+
                                user+"', '"+paymentType[0]+"', "+orders.get(i).price+", '"+LocalDate.now()+"')");
                    }

                    stmt.close();
                    con.close();

                }catch(Exception ex){ System.out.println(ex);}
                new HomePage(user);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        frame.setTitle("Payment");

        frame.setSize(800,600);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class Order{
        private int o_id;
        private int jewelry;
        private int metal;
        private int gem;
        private double price;
        public Order(int o_id, int jewelry, int metal, int gem, double price){
            this.o_id = o_id;
            this.jewelry = jewelry;
            this.metal = metal;
            this.gem = gem;
            this.price = price;
        }
    }

    public double calcTotalPrice(ArrayList<Order> orders) {
        double total = 0;
        for (int i = 0; i < orders.size(); i++) {
            total += orders.get(i).price;
        }
        return total;
    }

    public String getJewByID(int id) {
        for (int i = 0; i < Jew.size(); i++) {
            if (Jew.get(i).id == id) {
                return Jew.get(i).jew;
            }
        }
        return "doesn't exist";
    }

    public String getGemByID(int id) {
        for (int i = 0; i < Gem.size(); i++) {
            if (Gem.get(i).id == id) {
                return Gem.get(i).gem;
            }
        }
        return "doesn't exist";
    }

    public String getMetalByID(int id) {
        for (int i = 0; i < Metal.size(); i++) {
            if (Metal.get(i).id == id) {
                return Metal.get(i).metal;
            }
        }
        return "doesn't exist";
    }

    public String[] getGems(ArrayList<Gem> gemarr){
        String[] gems = new String[gemarr.size()];
        for (int i = 0; i< gemarr.size(); i++) {
            gems[i] = gemarr.get(i).gem;
        }
        return gems;
    }

    public String[] getJews(ArrayList<Jew> jewarr){
        String[] jew = new String[jewarr.size()];
        for (int i = 0; i< jewarr.size(); i++) {
            jew[i] = jewarr.get(i).jew;
        }
        return jew;
    }

    public String[] getMetals(ArrayList<Metal> metalArr){
        String[] metal = new String[metalArr.size()];
        for (int i = 0; i< metalArr.size(); i++) {
            metal[i] = metalArr.get(i).metal;
        }
        return metal;
    }

    private class Gem{
        private String gem;
        private Double price;
        private int id;
        public Gem(int id, String gem, Double price){
            this.gem = gem;
            this.price = price;
            this.id = id;
        }
    }

    private class Metal{
        private String metal;
        private Double price;
        private int id;
        public Metal(int id, String metal, Double price){
            this.metal = metal;
            this.price = price;
            this.id = id;
        }
    }

    private class Jew{
        private String jew;
        private Double price;
        private int id;
        public Jew(int id, String jew, Double price){
            this.jew = jew;
            this.price = price;
            this.id = id;
        }
    }
}
