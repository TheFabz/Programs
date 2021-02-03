package JavaIntro.AdvancedOOP.SniperGame;

public interface Shootable {


    //shootable obj functions
    void healthAfterHit(int damageTaken);
    boolean isDestroyed();
    int getHealth();

}
