package players;

import boss.Boss;
import game.Ability;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        if (boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - boss.getDamage());
        }
    }
}
