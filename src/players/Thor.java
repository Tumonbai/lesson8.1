package players;

import boss.Boss;
import game.Ability;

import java.util.Random;

public class Thor extends Hero {

    public Thor(int health, int damage) {
        super(health, damage, Ability.BUSH);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        Random r = new Random();
        if(r.nextInt(1) == 1) {
            System.out.println("Thor applied super ability");
            boss.setPreviousDamage(boss.getDamage());
            boss.setDamage(0);
        } else {
            boss.setDamage(boss.getPreviousDamage());
        }
    }
}