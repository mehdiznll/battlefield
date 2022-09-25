package org.example.game.characters;


@FunctionalInterface  // SAM (Single abstract method)
interface HasAttack {
    int getAttack();
}


interface HasHealth {
    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }
}

interface HasWarriorBehind {
    Warrior getNextWarrior();

    void setNextWarrior(Warrior nextWarrior);

    boolean hasWarriorBehind();

}

interface CanReceiveDamage extends HasHealth, HasWarriorBehind {
    public void receiveDamage(HasAttack damager);
}


public class Warrior implements HasAttack, HasHealth, CanReceiveDamage {

    private int attack;
    protected int health;
    protected int initialHealth;
    protected Warrior nextWarrior;

    public Warrior() {
        this.attack = 5;
        this.health = 50;
        this.initialHealth = health;
    }

    protected Warrior(int health, int attack) {

        initialHealth = this.health = health;
        this.attack = attack;
    }


    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public Warrior getNextWarrior() {
        return nextWarrior;
    }

    @Override
    public void setNextWarrior(Warrior nextWarrior) {

    }

    @Override
    public boolean hasWarriorBehind() {
        return false;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public void hit(CanReceiveDamage opponent) {

        opponent.receiveDamage(this);

    }

    @Override
    public void receiveDamage(HasAttack damager) {
        setHealth(getHealth() - damager.getAttack());
    }

}
