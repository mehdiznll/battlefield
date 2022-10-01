package org.example.game;

import org.example.game.characters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VapmirismTest {

    @Test
    void smokeTest() {

        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();

        assert Battle.fight(chuck, bruce);
        assert !Battle.fight(dave, carl);
        assert chuck.isAlive();
        assert !bruce.isAlive();
        assert carl.isAlive();
        assert !dave.isAlive();
        assert !Battle.fight(carl, mark);
        assert !carl.isAlive();
        assert !Battle.fight(bob, mike);
        assert Battle.fight(lancelot, rog);
        assert !Battle.fight(eric, richard);
        assert Battle.fight(ogre, adam);

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 4);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 2);

        assert !Battle.armyFight(myArmy, enemyArmy);
        assert Battle.armyFight(army3, army4);

    }

    @Test
    @DisplayName("11. BattleWithVampire")
    void test11() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 5);
        army1.addUnits(Vampire::new, 6);
        army1.addUnits(Warrior::new, 7);
        army2.addUnits(Warrior::new, 6);
        army2.addUnits(Defender::new, 6);
        army2.addUnits(Vampire::new, 6);


        assertFalse(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("12. BattleWithVampire")
    void test12() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 2);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 3);


        assertFalse(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("13. BattleWithVampire")
    void test13() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 11);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 13);


        assertTrue(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("14. BattleWithVampire")
    void test14() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 9);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 8);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 13);


        assertTrue(Battle.armyFight(army1, army2));

    }
}
