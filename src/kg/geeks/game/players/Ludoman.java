package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero{
    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.PLAYING_DICE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int gameDice1 = RPG_Game.random.nextInt(6) + 1;
        int gameDice2 = RPG_Game.random.nextInt(6) + 1;

        if(gameDice1 == gameDice2) {
            int damageToBoss = gameDice1 * gameDice2;
            boss.setHealth(boss.getHealth() - damageToBoss);
            System.out.println("Dice matched!!! and boss loss: " + damageToBoss + "HP");
        } else {
            boolean foundHero = false;
            int damageToHeroes = gameDice1 + gameDice2;
            while (!foundHero) {
                int randomIndex = RPG_Game.random.nextInt(heroes.length);
                Hero randomHero = heroes[randomIndex];
                if (randomHero.getHealth() > 0 && randomHero != this) {
                    randomHero.setHealth(randomHero.getHealth() - damageToHeroes);
                    System.out.println("Dice not matched :( and " + randomHero.getName() + " loss " + damageToHeroes + "HP");
                    foundHero = true;
                }
            }
        }
    }
}
