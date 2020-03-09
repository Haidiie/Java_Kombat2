import java.util.ArrayList;
import java.util.List;

public class Tournament {

    Fighter fighter1;
    Fighter fighter2;

    Match match = new Match();
    Battle battle = new Battle();


    public void fight() {

        match.SQL();

        do {
            System.out.println("\nName: Hp : Pwr");
            for (int i = 0; i < match.getTotalFighters(); i++) {
                System.out.println("\n" + match.fighters.get(i).getName() + " " + match.fighters.get(i).getHealth() +
                        " " + (match.fighters.get(i).getAttack() + match.fighters.get(i).getDefence()));
            }

            for (int i = 0; i < match.getTotalFighters(); i = i + 2) {

                this.fighter1 = match.fighters.get(i);
                this.fighter2 = match.fighters.get(i + 1);

                battle.battle(this.fighter1, this.fighter2);
            }


            System.out.println("The LOSERS!\n");
            List<Fighter> remainingFighters = new ArrayList<>();

            for (int i = 0; i < match.getTotalFighters(); i++) {
                if (match.fighters.get(i).getHealth() <= 0) {
                    System.out.println(match.fighters.get(i).getName() + " " + match.fighters.get(i).getHealth());
                } else {
                    match.fighters.get(i).setHealth(20);
                    remainingFighters.add(match.fighters.get(i));
                }
            }
            System.out.println("-------------------\n");
            match.fighters = remainingFighters;

        }
        while (match.fighters.size() > 1);

        System.out.println("THE CHAMPION IS NOBODY BUT " +
                match.fighters.get(0).getName().toUpperCase() + "!!!!!!!!!!!!!!!");

    }

}



