package boss;

import game.GameEntity;

public class Boss extends GameEntity {

    private int previousDamage;

    public Boss(int health, int damage){
        super(health, damage);
    }


    public int getPreviousDamage() {
        return previousDamage;
    }

    public void setPreviousDamage(int previousDamage) {
        this.previousDamage = previousDamage;
    }
}
