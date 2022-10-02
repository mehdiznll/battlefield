package org.example.game;


import org.example.game.characters.Army;
import org.example.game.characters.Warrior;

public class Battle {

    private Battle() {
        throw new IllegalStateException("Utility class");
    }

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
     * @param army1
     * @param army2
     * @return next warrior in the army.
     */
    public static boolean armyFight(Army army1, Army army2) {

        var it1 = army1.firstAlive();
        var it2 = army2.firstAlive();

        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();

    }


    public static boolean straightFight(Army army1, Army army2) {

        while (true) {
            var army1Iterator = army1.iterator();
            var army2Iterator = army2.iterator();

            if (!army1Iterator.hasNext()) return false;
            if (!army2Iterator.hasNext()) return true;

            while (army1Iterator.hasNext() && army2Iterator.hasNext()) {
                fight(army1Iterator.next(), army2Iterator.next());

            }

            army1.removeDeadUnits();
            army2.removeDeadUnits();
        }
    }
}