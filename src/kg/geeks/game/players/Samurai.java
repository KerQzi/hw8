package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Samurai extends Hero {
    public Samurai(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SHURIKEN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        int damageOrHealBoss = RPG_Game.random.nextInt(10) + 5;

        Shurikens[] shurikenType = Shurikens.values();
        int randomIndex = RPG_Game.random.nextInt(shurikenType.length);
        Shurikens selectedVariant = shurikenType[randomIndex];

        if (selectedVariant == Shurikens.VIRUS) {
            boss.setHealth(boss.getHealth() - damageOrHealBoss);
            System.out.println(selectedVariant + "-shuriken hit boss and boss loss " + damageOrHealBoss + " HP");
        } else if (selectedVariant == Shurikens.VACCINE){
            boss.setHealth(boss.getHealth() + damageOrHealBoss);
            System.out.println(selectedVariant + "-shuriken hit boss and boss heal " + damageOrHealBoss + " HP");
        }
    }
}
