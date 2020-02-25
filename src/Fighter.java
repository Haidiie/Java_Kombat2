import java.util.Random;

public class Fighter {
    Random random = new Random();

    private int health;
    private int attack;
    private int defence;
    private String name;
    private String motto;

    public Fighter(String name, String motto) {
        this.health = 100;
        this.attack = random.nextInt(20)+10;
        this.defence = random.nextInt(20)+10;
        this.name = name;
        this.motto = motto;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health < 1) {
            System.out.println(this.name + " knocked out--------------------------");
        }
    }


        public int getAttack () {
            return attack;
        }

        public void setAttack ( int attack){
            this.attack = attack;
        }

        public int getDefence () {
            return defence;
        }

        public void setDefence ( int defence){
            this.defence = defence;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

    public String getMotto() {
        return motto;
    }
}
