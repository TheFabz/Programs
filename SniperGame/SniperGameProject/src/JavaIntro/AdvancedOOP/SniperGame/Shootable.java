package JavaIntro.AdvancedOOP.SniperGame;

public interface Shootable {


    //shootable obj functions
    public abstract void healthAfterHit(int damageTaken);
    public abstract boolean isDestroyed();
    public abstract int getHealth();

}
