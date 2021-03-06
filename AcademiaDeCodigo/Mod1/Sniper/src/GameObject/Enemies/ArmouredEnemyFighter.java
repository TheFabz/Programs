package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

public class ArmouredEnemyFighter extends EnemyAbstract {

    private int armour = 50;

    //subtracts health points if there is no armour
    @Override
    public void healthAfterHit(int damageTaken){
        System.out.println("Armour health is " + getArmour());
            if(armour > 0){
                armour -= damageTaken;
            }
            else {
                super.healthAfterHit(damageTaken);
            }
    }

    //returns current armour points and returns 0 if armour is a negative number
    public int getArmour() {
        if(armour > 0) {
            return armour;
        }
        else if(armour <0){
            armour = 0;
            return armour;
        }
        else{
            return armour;
        }
    }

    //prints msg
    public void printMessage(){
        System.out.println("AIM FOCUSED, you've found an armoured soldier ! ");
    }

}
