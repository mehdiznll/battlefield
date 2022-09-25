package org.example.game.characters;

public class Defender extends Warrior {

    private static final int DEFENCE = 2;

    public Defender() {

        super(60, 3);
    }

    protected int getDefence() {
        return DEFENCE;
    }

    @Override
    public void receiveDamage(HasAttack damager) {
        int reducedDamage = Math.max(0, damager.getAttack() - getDefence());
        super.receiveDamage(() -> reducedDamage);

    }


//    } int receiveDamage(int damage) {
//        int finalDamage = damage - DEFENCE;
//
//        if (damage < DEFENCE) {
//            super.receiveDamage(0);
//        } else {
//            super.receiveDamage(finalDamage);
//        }
//        return finalDamage;
//    }

}
