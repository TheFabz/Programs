package JavaIntro.AdvancedOOP.SniperGame;

public class Sniper {

    private int bulletDamage = (int) ((Math.random() * 50));

    public int shoot() {
        double randomizer = Math.random();

        if (randomizer > 0.2) {
            System.out.println("You shot him!");
            return bulletDamage;
        } else {
            System.out.println("You missed :/");
            return 0;
        }
    }

}
