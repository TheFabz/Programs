package JavaIntro.AdvancedOOP.SniperGame.GameObject;

public enum BarrelType {

    PLASTIC(25),
    WOOD(70),
    METAL(120);

    private int barrelHealth;

    BarrelType(int barrelHealth){
        this.barrelHealth = barrelHealth;
    }

    public int getBarrelHealth(){
        return barrelHealth;
    }


}
