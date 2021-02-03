package JavaIntro.AdvancedOOP.SniperGame;

public interface Shootable {

    public abstract void healthAfterHit(int damageTaken);

    public abstract boolean isDestroyed();

    public abstract int getHealth();

}
