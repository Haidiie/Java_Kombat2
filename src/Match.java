import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Match {
    List<Fighter> fighters = new ArrayList<>();


    public void SQL() {

        Connection myConn;
        Statement myStmt;
        ResultSet myRs;

        String dbUrl = "jdbc:mysql://localhost:3306/java_kombat";
        String user = "root";
        String pass = "haidarbb";

        try {

            myConn = DriverManager.getConnection(dbUrl, user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from fighters");

            while (myRs.next()) {
                fighters.add(new Fighter(myRs.getString("name"), myRs.getString("motto")));
            }

            Collections.shuffle(fighters);
            System.out.println("The Java Kombat beginns with " + fighters.size() + " fighters!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalFighters() {
        return fighters.size();
    }
}
