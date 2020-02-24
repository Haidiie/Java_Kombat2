import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Match {
    Random random = new Random();

    List<Fighter> fighters = new ArrayList<>();


    public void SQL(){

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/java_kombat";
        String user = "root";
        String pass = "haidarbb";


        try {


            myConn = DriverManager.getConnection(dbUrl,user,pass);
            System.out.println("Anslutning lyckades\n");


            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("select name from fighters");


            while (myRs.next()) {
                fighters.add(new Fighter(myRs.getString("name")));

            }

            Collections.shuffle(fighters);

            for (int i = 0; i < fighters.size(); i++) {
                System.out.println(fighters.get(i).getName());
                System.out.println(fighters.get(i).getAttack() + " " + fighters.get(i).getDefence());
            }


        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Fighter ran(int num){
        return fighters.get(random.nextInt(num));
    }


    public int getTotalFighters(){
        return fighters.size();
    }
}
