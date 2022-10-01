package org.example.game.characters;


interface HasHealth {
    int getHealth();

    void setHealth(int health);

    default boolean isAlive() {
        return getHealth() > 0;
    }
}

@FunctionalInterface
// SAM (Single abstract method)
interface HasAttack {

    int getAttack();

    default void hit(CanReceiveDamage opponent) {

        opponent.receiveDamage(this);
    }

}

interface CanReceiveDamage extends HasHealth {
    void receiveDamage(HasAttack damager);
}

interface CanBeWeakened extends HasAttack {
    void setAttack(int attack);

    default void setWeakness() {

    }
}


public class Warrior implements HasAttack, HasHealth, CanReceiveDamage, CanBeWeakened {

    private int health;
    private int attack;
    private int initialHealth;

    public Warrior(int health, int attack) {
        initialHealth = this.health = health;
        this.attack = attack;
    }

    /**
     * Overloaded constructor for Warrior
     */
    public Warrior() {
        this(50, 5);
    }

    @Override
    public void receiveDamage(HasAttack damager) {

        setHealth(getHealth() - damager.getAttack());

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }


    @Override
    public void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

//    public void hit(CanReceiveDamage opponent) {
//
//        opponent.receiveDamage(this);
//
//    }


}
