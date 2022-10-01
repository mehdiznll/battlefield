package org.example.game.characters;

public class Healer extends Warrior{

    private static final int HEALING = 2;

    public Healer() {
        super(60, 0);
    }

    public void heal(Warrior injuredWarrior){

        injuredWarrior.setHealth(injuredWarrior.getHealth() + HEALING);

    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        // healer dont have attack skills
    }
}
