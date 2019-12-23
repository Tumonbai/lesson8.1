package game;

import boss.Boss;
import players.*;

public class RpgGame {

    public static void startGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = getHeroesArray();
        showStatistics(heroes, boss);
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static Hero[] getHeroesArray() {
        Hero[] heroes = {
                new Warrior(100, 10),
                new Magical(100, 10),
                new Hunter(100, 10),
                new Medical(100, 10)};
        return heroes;
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        showStatistics(heroes, boss);
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            hero.setHealth(hero.getHealth() - boss.getDamage());
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - hero.getDamage());
                hero.useAbility(heroes, boss);
            }
        }
    }


    private static void showStatistics(Hero[] heroes, Boss boss) {
        System.out.println("_____________");
        System.out.println("Boss health = " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero " + heroes[i].getClass().getSimpleName() +
                    " health = " + heroes[i].getHealth());
        }
        System.out.println("_____________");
    }
}
