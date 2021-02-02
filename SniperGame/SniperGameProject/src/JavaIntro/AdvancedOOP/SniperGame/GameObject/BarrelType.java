package JavaIntro.AdvancedOOP.SniperGame.GameObject;

public enum BarrelType {

    PLASTIC,
    WOOD,
    METAL;

    public static BarrelType getRandomBarrelType(){
        int randomNum = (int) ((Math.random() * 3));
        return fromIntToBarrelType(randomNum);
    }

    public static BarrelType fromIntToBarrelType(int num){
        return BarrelType.values()[num];
    }



}
