package JavaIntro.AdvancedOOP.SniperGame;

public class Sniper {

    private int bulletDamage = (int) ((Math.random() * 50));


    public int shoot(){
        return bulletDamage;
    }

}
