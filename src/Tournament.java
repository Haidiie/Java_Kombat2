import java.util.List;
import java.util.Scanner;

public class Tournament {

Database database = new Database();
Scanner scanner = new Scanner(System.in);

    private int round = 1;
    private int totalFighter;
    private int getTotalFighter;
    private List<Fighter> allFighters;



    public void fight() {
        database.SQL();

        for (int i = 0; i < database.getTotalFighters() / 2; i++) {

            Fighter fighter1 = database.ran(database.getTotalFighters());
            Fighter fighter2 = database.ran(database.getTotalFighters());

            System.out.println("\nThe Battle is between " + fighter1.getName() + " And " + fighter2.getName());
            scanner.nextLine();

            while (fighter2.getHealth() > 0 && fighter1.getHealth() > 0) {

                System.out.println(fighter1.getName() + " Attacks with " + fighter1.getAttack());
                System.out.println(fighter2.getName() + " lost " + fighter1.getAttack() + " Hp, " + fighter2.getHealth() + "Hp Left");


                if (fighter2.getHealth() < 1 || fighter1.getHealth() < 1) {
                    break;
                }

                System.out.println(fighter2.getName() + " Attacks with " + fighter2.getAttack());
                System.out.println(fighter1.getName() + " lost " + fighter2.getAttack() + " Hp, " + fighter1.getHealth() + "Hp Left");

                System.out.println();


            }

        }


    }

}
