package org.example.game.characters;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);

    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        int healthAfter = opponent.getHealth();
        int damageDealt = healthBefore - healthAfter;
        final int percents = 100;
        int healMyselfBy = damageDealt * VAMPIRISM/ percents;
        setHealth(getHealth() + healMyselfBy);
    }
}
