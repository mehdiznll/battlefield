package org.example.game;

import org.example.game.characters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

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

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 1);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 2);

//        assert !Battle.armyFight(myArmy, enemyArmy);
//        assert Battle.armyFight(army3, army4);

        assertFalse(Battle.armyFight(myArmy,enemyArmy));
        assertTrue(Battle.armyFight(army3,army4));


    }

    @Test
    @DisplayName("7. Battle")
    void test07() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 4);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 4);

        assertTrue(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("8. Battle")
    void test08() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 5);
        army1.addUnits(Warrior::new, 20);
        army1.addUnits(Warrior::new, 21);
        army2.addUnits(Defender::new, 4);

        assertTrue(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("9. Battle")
    void test09() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Warrior::new, 10);
        army1.addUnits(Defender::new, 5);
        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Defender::new, 10);

        assertTrue(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("10. Battle")
    void test10() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Defender::new, 2);
        army1.addUnits(Warrior::new, 1);
        army1.addUnits(Defender::new, 1);
        army2.addUnits(Warrior::new, 5);

        assertFalse(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("8. Fight")
    void testFight08() {

        var unit1 = new Defender();
        var unit2 = new Rookie();

        Battle.fight(unit1, unit2);

        assertEquals(60, unit1.getHealth());


    }

    @Test
    @DisplayName("9. Fight")
    void testFight09() {

        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = new Warrior();

        Battle.fight(unit1, unit2);
        boolean fightResult = Battle.fight(unit1, unit3);

        assertTrue(fightResult);


    }
}
