import java.util.Random;
import java.util.Scanner;
// fixa en controller klass med metoden show() som tar emot allt i sysout(x)<--
public class Battle {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void battle(Fighter one, Fighter two) {

        int pwr1 = one.getAttack() + one.getDefence();
        int pwr2 = two.getAttack() + two.getDefence();

        System.out.println("\nThe Battle is between\n"+ C_BLUE + one.getName() + " with attack " + one.getAttack() + " and " +
                one.getDefence() + " defence, Power("+pwr1+")\n"+ C_RESET + C_RED +  two.getName() + " with attack " + two.getAttack() + " and " +
                two.getDefence() + " defence, Power("+ pwr2+")\n" + C_RESET);
        scanner.nextLine();

        while (two.getHealth() > 0 && one.getHealth() > 0) {

            int dmg, blc, res, cou;

            System.out.println(C_BLUE +one.getName() + " Attacks with " + (dmg = random.nextInt(one.getAttack()))+C_RESET);
            blc = random.nextInt(two.getDefence());
            res = (dmg - blc);
            if (res > 0) {

                two.loseHealth(res);
                System.out.println(C_RED + two.getName() + " lost " + res + " Hp, " + two.getHealth() + "Hp Left" + C_RESET);
            } else if (res == 0) {
                System.out.println(C_RED + two.getName() + " Blocks the Attack!" + C_RESET);
            } else {
                cou = Math.abs(res);
                System.out.println(C_RED + two.getName() + " Counter attacks with " + cou + C_RESET);
                one.loseHealth(cou);
                System.out.println(C_BLUE + one.getName() + " lost " + cou + " Hp, " + one.getHealth() + " Hp Left" + C_RESET);

            }

            if (two.getHealth() < 1 || one.getHealth() < 1) {
                break;
            }
            System.out.println(C_RED + two.getName() + " Attacks with " + (dmg = random.nextInt(two.getAttack()))+ C_RESET);
            blc = random.nextInt(one.getDefence());
            res = (dmg - blc);
            if (res > 0) {

                one.loseHealth(res);
                System.out.println(C_BLUE + one.getName() + " lost " + res + " Hp, " + one.getHealth() + "Hp Left" + C_RESET);
            } else if (res == 0) {
                System.out.println(C_BLUE + one.getName() + " Blocks the Attack!"+ C_RESET);
            } else {
                cou = Math.abs(res);
                System.out.println(C_BLUE + one.getName() + " Counter attacks with " + cou+C_RESET);
                two.loseHealth(cou);
                System.out.println(C_RED + two.getName() + " lost " + cou + " Hp, " + two.getHealth() + " Hp Left"+C_RESET);
            }

            System.out.println();
        }

        if(one.getHealth() < 1){

            System.out.println(C_RED + "\nThe Winner is " + two.getName() + " with " + two.getHealth() + "Hp left");
            System.out.println(two.getName() + " Says " + two.getMotto()+C_RESET + "\n");
        }else {
            System.out.println(C_BLUE + "\nThe Winner is " + one.getName() + " with " + one.getHealth() + "Hp left");
            System.out.println(one.getName() + " Says " + one.getMotto()+C_RESET + "\n");
        }


    }

    public static final String C_RESET = "\u001B[0m";
//    public static final String C_BLACK = "\u001B[30m";
    public static final String C_RED = "\u001B[31m";
//    public static final String C_GREEN = "\u001B[32m";
    public static final String C_YELLOW = "\u001B[33m";
    public static final String C_BLUE = "\u001B[34m";
//    public static final String C_PURPLE = "\u001B[35m";
//    public static final String C_CYAN = "\u001B[36m";
//    public static final String C_WHITE = "\u001B[37m";



}
