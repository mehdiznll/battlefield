package org.example.game;

import org.example.game.characters.Knight;
import org.example.game.characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleTest {

    @Test
    void smokeTest() {

        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();

        assert Battle.fight(chuck, bruce);
        assert !Battle.fight(dave, carl);
        assert chuck.isAlive();
        assert !bruce.isAlive();
        assert carl.isAlive();
        assert !dave.isAlive();
        assert !Battle.fight(carl, mark);
        assert !carl.isAlive();

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);

        assert Battle.armyFight(myArmy, enemyArmy);
        assert !Battle.armyFight(army3, army4);

    }

    @Test
    @DisplayName("1. Battle")
    void test01() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 1);
        army2.addUnits(Warrior::new, 2);

        assertFalse(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("2. Battle")
    void test02() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 2);
        army2.addUnits(Warrior::new, 3);

        assertFalse(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("3. Battle")
    void test03() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Warrior::new, 7);

        assertFalse(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("4. Battle")
    void test04() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);

        assertTrue(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("5. Battle")
    void test05() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Warrior::new, 11);

        assertTrue(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("6. Battle")
    void test06() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 11);
        army2.addUnits(Warrior::new, 7);

        assertTrue(Battle.armyFight(army1, army2));


    }
}
