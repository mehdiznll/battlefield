package org.example.game.characters;

public class Lancer extends Warrior implements DamageDone {

    public Lancer() {
        super(50, 6);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {

        int finalDamage = damageDealt(opponent);
        if (opponent instanceof ArmyWarrior armyUnit) {

            final Warrior warriorBehind = armyUnit.getWarriorBehind();
            if (warriorBehind != null) {
                int reducedDamage = finalDamage / 2;
                warriorBehind.receiveDamage(() -> reducedDamage);
            }
        }

    }
}
