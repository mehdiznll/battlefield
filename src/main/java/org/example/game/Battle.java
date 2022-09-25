package org.example.game;


import org.example.game.characters.Warrior;

public class Battle {

    /**
     * @param attacker
     * @param defender
     * @return if attacker isAlive true, otherwise false;
     */
    public static boolean fight(Warrior attacker, Warrior defender) {
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.hit(defender);
            if (defender.isAlive()) {
                defender.hit(attacker);
            }
        }

        return attacker.isAlive();
    }


    /**
     *
     * @param army1
     * @param army2
     * @return  next warrior in the army.
     */
    public static boolean armyFight(Army army1, Army army2) {

        var it1 = army1.firstAlive();
        var it2 = army2.firstAlive();

        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();

    }


}