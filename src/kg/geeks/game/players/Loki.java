package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

// Герой ЛОКИ может создавать иллюзии, благодаря чему уклонятся от атак босса

public class Loki extends Hero {
    private boolean illusionActive;
    private int illusionAmount;

    public Loki(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.ILLUSION);
    }

    public boolean isIllusionActive() {
        return illusionActive;
    }

    public void setIllusionActive(boolean illusionActive) {
        this.illusionActive = illusionActive;
    }

    public int getIllusionAmount() {
        return illusionAmount;
    }

    public void setIllusionAmount(int illusionAmount) {
        this.illusionAmount = illusionAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        if (!illusionActive) { // если иллюзии неактивны метод создает их
            illusionAmount = RPG_Game.random.nextInt(2) + 1; // 1, 2, 3
            illusionActive = true;
            System.out.println(this.getName() + " create a "+ illusionAmount +" Illusions");
        }
    }

    public boolean tryChanceToDamage() { // используется для подсчета шанса на то что Босс попадет по Локи
        System.out.println("Chance = 1/" + (illusionAmount + 1)); // ПРИМЕР: если количество иллюзий 2
                                                                    // ,то шанс на то что босс нанесет урон равен 1 к 3 итд.
        return RPG_Game.random.nextInt(illusionAmount) == 0; //ПРИМЕР: если illusionAmount равен к 1 то шанс что будет 0 равен 1 к 2 итд.
    }
}
