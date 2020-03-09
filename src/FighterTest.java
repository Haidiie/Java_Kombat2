import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    @org.junit.jupiter.api.Test
    void setHealth() {

    }

    @org.junit.jupiter.api.Test
    void loseHealth() {
        Fighter fighter = new Fighter("test","haha");
        fighter.loseHealth(5);
        assertEquals(fighter.getHealth(),15);
    }


    @org.junit.jupiter.api.Test
    void damege(){
        Fighter fighter1 = new Fighter("test1","");
        Fighter fighter2 = new Fighter("test2","");
        int dmg = fighter1.getAttack();
        fighter2.loseHealth(dmg);
        assertTrue(fighter2.getHealth() > 16 && fighter2.getHealth() < 20);
    }

    @org.junit.jupiter.api.Test
    void beforeMySQL(){
        List<Fighter> fighters = new ArrayList<>();
        assertTrue(fighters.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void AfterMySQL(){
        Match match = new Match();
        List<Fighter> fighters = new ArrayList<>();
        match.SQL();
        assertEquals(match.getTotalFighters(),16);
    }

    @org.junit.jupiter.api.Test
    void counterAttack(){
        Fighter one = new Fighter("test1","");
        Fighter two = new Fighter("test2","");
        one.setAttack(5);
        two.setDefence(10);

        int dmg, blc, res, cou;

        System.out.println(one.getName() + " Attacks with " + (dmg = one.getAttack()));
        blc = two.getDefence();
        res = (dmg - blc);
        if (res > 0) {
            two.loseHealth(res);
            System.out.println(two.getName() + " lost " + res + " Hp, " + two.getHealth() + "Hp Left");

            assertEquals(two.getHealth(),20-res);

        } else if (res == 0) {
            System.out.println(two.getName() + " Blocks the Attack!");

            assertEquals(two.getHealth(), 20);
            assertEquals(one.getHealth(), 20);
        } else {
            cou = Math.abs(res);
            System.out.println(two.getName() + " Counter attacks with " + cou);
            one.loseHealth(cou);
            System.out.println(one.getName() + " lost " + cou + " Hp, " + one.getHealth() + " Hp Left");

            assertNotEquals(two.getHealth(), 20-res);
            assertEquals(one.getHealth(), 20-cou);
        }

    }

    @org.junit.jupiter.api.Test
    void mottoNull(){
        Fighter one = new Fighter("test1",null);
        Fighter two = new Fighter("test2","");
        assertNull(one.getMotto());
        assertNotNull(two.getMotto());
    }



}

