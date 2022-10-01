package org.example.game;

import org.example.game.characters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealerTest {

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

        var my_army = new Army();
        my_army.addUnits(Defender::new, 2);
        my_army.addUnits(Healer::new, 1);
        my_army.addUnits(Vampire::new, 2);
        my_army.addUnits(Lancer::new, 2);
        my_army.addUnits(Healer::new, 1);
        my_army.addUnits(Warrior::new, 1);

        var enemy_army = new Army();
        enemy_army.addUnits(Warrior::new, 2);
        enemy_army.addUnits(Lancer::new, 4);
        enemy_army.addUnits(Healer::new, 1);
        enemy_army.addUnits(Defender::new, 2);
        enemy_army.addUnits(Vampire::new, 3);
        enemy_army.addUnits(Healer::new, 1);

        var army_3 = new Army();
        army_3.addUnits(Warrior::new, 1);
        army_3.addUnits(Lancer::new, 1);
        army_3.addUnits(Healer::new, 1);
        army_3.addUnits(Defender::new, 2);

        var army_4 = new Army();
        army_4.addUnits(Vampire::new, 3);
        army_4.addUnits(Warrior::new, 1);
        army_4.addUnits(Healer::new, 1);
        army_4.addUnits(Lancer::new, 2);

        assert !Battle.armyFight(my_army, enemy_army);
        assert Battle.armyFight(army_3, army_4);
    }


    @Test
    @DisplayName("17. BattleTestWithHealer ")
    void test17() {

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

        assertTrue(Battle.armyFight(army1, army2));


    }

    @Test
    @DisplayName("18. BattleTestWithHealer ")
    void test18() {

        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(Lancer::new, 1);
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

        assertFalse(Battle.armyFight(army1, army2));


    }
}
