package JavaIntro.AdvancedOOP.SniperGame;

public class Sniper {

    private int bulletDamage = (int) ((Math.random() * 50));

    //sniper has an 80% accuracy of making a hit. Hit can be a random number between 0 and 49
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
