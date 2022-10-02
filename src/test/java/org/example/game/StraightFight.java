package org.example.game;

import org.example.game.characters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightFight {

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
        var freelancer = new Lancer();
        var vampire = new Vampire();
        var priest = new Healer();

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
        assert Battle.fight(freelancer, vampire);
        assert freelancer.isAlive();
        assert freelancer.getHealth() == 14;
        priest.heal(freelancer);
        assert freelancer.getHealth() == 16;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Lancer::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);
        enemyArmy.addUnits(Healer::new, 1);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Lancer::new, 1);
        army3.addUnits(Healer::new, 1);
        army3.addUnits(Defender::new, 2);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 1);
        army4.addUnits(Healer::new, 1);
        army4.addUnits(Lancer::new, 2);

        var army5 = new Army();
        army5.addUnits(Warrior::new, 10);

        var army6 = new Army();
        army6.addUnits(Warrior::new, 6);
        army6.addUnits(Lancer::new, 5);

        assertFalse(Battle.armyFight(myArmy, enemyArmy));
        assertTrue(Battle.armyFight(army3, army4));
        assertFalse(Battle.straightFight(army5, army6));
    }

    @Test
    @DisplayName("19. StraightFightTest")
    void test19() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 5);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 5);

        assertFalse(Battle.straightFight(army1, army2));


    }

    @Test
    @DisplayName("20. StraightFightTest")
    void test20() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assertTrue(Battle.straightFight(army1, army2));


    }

    @Test
    @DisplayName("21. StraightFightTest")
    void test21() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Healer::new, 1);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new, 4);

        assertFalse(Battle.straightFight(army1, army2));


    }

    @Test
    @DisplayName("22. StraightFightTest")
    void test22() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 4);
        army1.addUnits(Warrior::new, 3);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Healer::new, 1);
        army1.addUnits(Knight::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Healer::new, 1);
        army2.addUnits(Vampire::new, 4);
        army2.addUnits(Lancer::new, 2);

        assertTrue(Battle.straightFight(army1, army2));


    }
}
