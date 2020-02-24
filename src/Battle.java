import java.util.Scanner;

public class Battle {

    Scanner scanner = new Scanner(System.in);

    public void battle(Fighter one, Fighter two){

        System.out.println("\nThe Battle is between " + one.getName() + " And " + two.getName());
        scanner.nextLine();

        while (two.getHealth() > 0 && one.getHealth() > 0) {

            int dmg, blc, res, cou;

            System.out.println(one.getName() + " Attacks with " + (dmg = one.getAttack()));
            blc = two.getDefence();
            res = (dmg - blc);
            if (res > 0) {

                two.loseHealth(one.getAttack());
                System.out.println(two.getName() + " lost " + res + " Hp, " + two.getHealth() + "Hp Left");
            } else if (res == 0) {
                System.out.println(two.getName() + " Blocks the Attack!");
            } else {
                cou = Math.abs(res);
                System.out.println(two.getName() + " Counter attacks with " + cou);
                one.loseHealth(cou);
                System.out.println(one.getName() + " lost " + cou + " Hp, " + one.getHealth() + " Hp Left");

            }

            if (two.getHealth() < 1 || one.getHealth() < 1) {
                break;
            }
            System.out.println(two.getName() + " Attacks with " + (dmg = two.getAttack()));
            blc = one.getDefence();
            res = (dmg - blc);
            if (res > 0) {

                one.loseHealth(two.getAttack());
                System.out.println(one.getName() + " lost " + res + " Hp, " + one.getHealth() + "Hp Left");
            } else if (res == 0) {
                System.out.println(one.getName() + " Blocks the Attack!");
            } else {
                cou = Math.abs(res);
                System.out.println(one.getName() + " Counter attacks with " + cou);
                two.loseHealth(cou);
                System.out.println(two.getName() + " lost " + cou + " Hp, " + two.getHealth() + " Hp Left");
            }
            System.out.println();
        }

    }
}
