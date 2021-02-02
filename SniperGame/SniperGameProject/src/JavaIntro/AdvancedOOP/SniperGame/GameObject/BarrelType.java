package JavaIntro.AdvancedOOP.SniperGame.GameObject;

public enum BarrelType {

    PLASTIC,
    WOOD,
    METAL;

   /*  int getBarrelDurability(){
        BarrelType barrel = getRandomBarrelType();
        switch(barrel){
            case WOOD:
                return 70;
            case METAL:
                return 150;
            case PLASTIC:
                return 25;
            default:
                return 100;
        }
    }*/


    public static BarrelType getRandomBarrelType(){
        int randomNum = (int) ((Math.random() * 3));
        return fromIntToBarrelType(randomNum);
    }

    public static BarrelType fromIntToBarrelType(int num){
        return BarrelType.values()[num];
    }


}
