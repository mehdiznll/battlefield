package org.example.game.characters;

public class Lancer extends Warrior {

    public Lancer() {
        super(50, 6);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int healthBefore = opponent.getHealth();

        opponent.receiveDamage(this);

        if (opponent.hasWarriorBehind()) {
            double decreaseAttack = 0.5;
            int healthAfter = opponent.getHealth();
            int differenceHealth = healthBefore - healthAfter;

            Warrior nextOpponent = opponent.getNextWarrior();
            nextOpponent.receiveDamage(() -> (int) (differenceHealth * decreaseAttack));

        }
    }
}
