import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by khoanguyen1 on 3/21/17.
 */
public class MakeJewelry {
    private JFrame frame;
    ArrayList<Jew> Jew = new ArrayList<>();
    ArrayList<Gem> Gem = new ArrayList<>();
    ArrayList<Metal> Metal = new ArrayList<>();

    public MakeJewelry(String user) {
        frame = new JFrame();
        JButton logout = new JButton("Logout");
        JButton finalize = new JButton("Finalize");
        JButton back = new JButton("Back");
        back.setBounds(10,10,50,20);
        frame.add(back);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new HomePage(user);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
//                        "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamonxd");
                    "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamond");
            Statement stmt=con.createStatement();
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


        JComboBox JewList = new JComboBox(getJews(Jew));
        JewList.setBounds(20,20,150,150);
        JewList.setLocation(550, 50);

        frame.add(JewList);

        JComboBox GemList = new JComboBox(getGems(Gem));
        GemList.setBounds(20,20,150,150);
        GemList.setLocation(150, 50);

        frame.add(GemList);

        JComboBox MetalList = new JComboBox(getMetals(Metal));
        MetalList.setBounds(20,20,150,150);
        MetalList.setLocation(350, 50);

        frame.add(MetalList);

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

        finalize.setBounds(20,20,250,70);
        finalize.setLocation(270, 350);

        frame.add(finalize);

        finalize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection(
//                        "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamonxd");
                            "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamond");
                    Statement stmt=con.createStatement();
                    int gemindex = GemList.getSelectedIndex();
                    int jewindex = JewList.getSelectedIndex();
                    int metalindex = MetalList.getSelectedIndex();

                    System.out.println("Jew id is:" + Jew.get(jewindex).id);

                    stmt.executeUpdate("insert into Orders(login_name, gem, metal, jewelry, price, paid) values ('"+
                        user +"', " + (Gem.get(gemindex).id) +", " + (Metal.get(metalindex).id) +", " + (Jew.get(jewindex).id) +", " + (Jew.get(jewindex).price +
                            Gem.get(gemindex).price + Metal.get(metalindex).price) + ", false);");

                    stmt.close();
                    con.close();

                }catch(Exception ex){ System.out.println(ex);}

                new HomePage(user);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        frame.setTitle("Make Jewelry");

        frame.setSize(800,600);
        frame.setLocation(600,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

