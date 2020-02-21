import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tournament {

Match match = new Match();
Scanner scanner = new Scanner(System.in);


public void fight() {
        match.SQL();

        do {

            for (int i = 0; i < match.getTotalFighters(); i++) {
                System.out.println("\n" + match.fighters.get(i).getName() + " " + match.fighters.get(i).getHealth());
            }

            for (int i = 0; i < match.getTotalFighters(); i = i + 2) {

                //Fighter fighter1 = match.ran(match.getTotalFighters());
                //Fighter fighter2 = match.ran(match.getTotalFighters());
                Fighter fighter1 = match.fighters.get(i);
                Fighter fighter2 = match.fighters.get(i + 1);

                System.out.println("\nThe Battle is between " + fighter1.getName() + " And " + fighter2.getName());
                scanner.nextLine();

                while (fighter2.getHealth() > 0 && fighter1.getHealth() > 0) {

                    System.out.println(fighter1.getName() + " Attacks with " + fighter1.getAttack());
                    fighter2.loseHealth(fighter1.getAttack());
                    System.out.println(fighter2.getName() + " lost " + fighter1.getAttack() + " Hp, " + fighter2.getHealth() + "Hp Left");


                    if (fighter2.getHealth() < 1) {
                        break;
                    }

                    System.out.println(fighter2.getName() + " Attacks with " + fighter2.getAttack());
                    fighter1.loseHealth(fighter2.getAttack());
                    System.out.println(fighter1.getName() + " lost " + fighter2.getAttack() + " Hp, " + fighter1.getHealth() + "Hp Left");

                    System.out.println();


                }


            }


            System.out.println(match.fighters.size());
            List<Fighter> remainingFighters = new ArrayList<>();

            for (int i = 0; i < match.getTotalFighters(); i++) {
                if (match.fighters.get(i).getHealth() <= 0) {
                    System.out.println(match.fighters.get(i).getName() + " " + match.fighters.get(i).getHealth());
                } else {
                    match.fighters.get(i).setHealth(100);
                    remainingFighters.add(match.fighters.get(i));
                }
            }
            match.fighters = remainingFighters;
            System.out.println(match.fighters.size());
            for (int i = 0; i < match.getTotalFighters(); i++) {
                System.out.println("\n" + match.fighters.get(i).getName() + " " + match.fighters.get(i).getHealth());
            }

        }while(match.fighters.size() > 1);


        }

    }


