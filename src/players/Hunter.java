package players;

import boss.Boss;
import game.Ability;

import java.util.Random;

public class Hunter extends Hero {

    public Hunter(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        Random r = new Random();
        setDamage(getDamage() * (r.nextInt(2) + 2));
        /*for (Hero hero : heroes) {
            if (hero.getAbility() == Ability.CRITICAL_DAMAGE) {
                hero.setDamage(hero.getDamage()
                        * (r.nextInt(2) + 2));
            }
        }
        heroes[2].setDamage(heroes[2].getDamage()
                * (r.nextInt(2) + 2));*/
    }
}