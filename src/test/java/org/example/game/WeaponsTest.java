package org.example.game;

import org.example.game.characters.*;
import org.example.game.characters.weapons.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.game.characters.weapons.Weapons.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponsTest {

    @Test
    @DisplayName("Smoke Test With Weapons")
    void smokeTest() {
        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();

        var sword = newSword();
        var shield = newShield();
        var axe = newGreatAxe();
        var katana = newKatana();
        var wand = newMagicWand();

        Weapon newSuperWeapon = newSuperWeapon();

        ogre.equipWeapon(sword);
        ogre.equipWeapon(shield);
        ogre.equipWeapon(newSuperWeapon);
        lancelot.equipWeapon(newSuperWeapon);
        richard.equipWeapon(shield);
        eric.equipWeapon(newSuperWeapon);
        freelancer.equipWeapon(axe);
        freelancer.equipWeapon(katana);
        priest.equipWeapon(wand);
        priest.equipWeapon(shield);

        assert ogre.getHealth() == 125;
        assert lancelot.getAttack() == 17;
        assert richard.getDefence() == 4;
        assert eric.getVampirism() == 200;
        assert freelancer.getHealth() == 15;
        assert priest.getHealing() == 5;

        assert !Battle.fight(ogre, eric);
        assert !Battle.fight(priest, richard);
        assert Battle.fight(lancelot, freelancer);

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, axe);
        myArmy.equipWarriorAtPosition(1, newSuperWeapon);

        enemyArmy.equipWarriorAtPosition(0, katana);
        enemyArmy.equipWarriorAtPosition(1, wand);

        assertTrue(Battle.armyFight(myArmy, enemyArmy));

    }

//        @Test
//    @DisplayName("01. Test Weapon")
//    void test01() {
//
//        var unit1 = new Warrior();
//        var unit2 = new Vampire();
//
//        var weapon1 = new Weapon(-10,5,0,40,0);
//        var weapon2 = newSword();
//
//        unit1.equipWeapon(weapon1);
//        unit2.equipWeapon(weapon2);
//
//        assertTrue(Battle.fight(unit1,unit2));
//
//
//    }

    @Test
    @DisplayName("02. Test Weapon")
    void test02() {

        var unit1 = new Defender();
        var unit2 = new Lancer();

        var weapon1 = newShield();
        var weapon2 = newGreatAxe();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);

        assertFalse(Battle.fight(unit1, unit2));


    }

    @Test
    @DisplayName("03. Test Weapon")
    void test03() {

        var unit1 = new Healer();
        var unit2 = new Knight();

        var weapon1 = newMagicWand();
        var weapon2 = newKatana();

        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);

        assertFalse(Battle.fight(unit1, unit2));


    }

    @Test
    @DisplayName("04. Test Weapon")
    void test04() {

        var unit1 = new Defender();
        var unit2 = new Vampire();

        var weapon1 = newShield();
        var weapon2 = newMagicWand();
        var weapon3 = newShield();
        var weapon4 = newKatana();

        unit1.equipWeapon(weapon1);
        unit1.equipWeapon(weapon2);
        unit2.equipWeapon(weapon3);
        unit2.equipWeapon(weapon4);

        assertFalse(Battle.fight(unit1, unit2));


    }

//    @Test
//    @DisplayName("05. Test Weapon")
//    void test05() {
//
//        var weapon1 = newMagicWand();
//        var weapon2 = newGreatAxe();
//
//        var myArmy = new Army();
//
//        myArmy.addUnits(Knight::new, 1);
//        myArmy.addUnits(Lancer::new, 1);
//
//        var enemyArmy = new Army();
//
//        enemyArmy.addUnits(Vampire::new, 1);
//        enemyArmy.addUnits(Healer::new, 1);
//
//        myArmy.equipWarriorAtPosition(0, weapon1);
//        myArmy.equipWarriorAtPosition(1, weapon2);
//        enemyArmy.equipWarriorAtPosition(0, weapon1);
//        enemyArmy.equipWarriorAtPosition(1, weapon2);
//
//        assertTrue(Battle.armyFight(myArmy, enemyArmy));
//
//
//    }

//    @Test
//    @DisplayName("06. Test Weapon")
//    void test06() {
//
//        var weapon1 = newSword();
//        var weapon2 = newGreatAxe();
//
//        var myArmy = new Army();
//
//        myArmy.addUnits(Defender::new, 1);
//        myArmy.addUnits(Warrior::new, 1);
//
//        var enemyArmy = new Army();
//
//        enemyArmy.addUnits(Knight::new, 1);
//        enemyArmy.addUnits(Healer::new, 1);
//
//        myArmy.equipWarriorAtPosition(0, weapon2);
//        myArmy.equipWarriorAtPosition(1, weapon2);
//        enemyArmy.equipWarriorAtPosition(0, weapon1);
//        enemyArmy.equipWarriorAtPosition(1, weapon1);
//
//        assertTrue(Battle.armyFight(myArmy, enemyArmy));
//
//
//    }

//    @Test
//    @DisplayName("07. Test Weapon")
//    void test07() {
//
//        var weapon1 = newKatana();
//        var weapon2 = newShield();
//
//        var myArmy = new Army();
//
//        myArmy.addUnits(Defender::new, 2);
//
//        var enemyArmy = new Army();
//
//        enemyArmy.addUnits(Knight::new, 1);
//        enemyArmy.addUnits(Vampire::new, 1);
//
//        myArmy.equipWarriorAtPosition(0, weapon1);
//        myArmy.equipWarriorAtPosition(1, weapon1);
//        enemyArmy.equipWarriorAtPosition(0, weapon1);
//        enemyArmy.equipWarriorAtPosition(1, weapon1);
//
//        assertFalse(Battle.armyFight(myArmy, enemyArmy));
//
//
//    }

    @Test
    @DisplayName("08. Test Weapon")
    void test08() {

        var weapon1 = new  Weapon(-20, 6, 1, 40, -2);
        var weapon2 = new  Weapon(20, -2, 2, -55, 3);

        var myArmy = new Army();

        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();

        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);

        assertFalse(Battle.armyFight(myArmy, enemyArmy));


    }

    @Test
    @DisplayName("09. Test Weapon")
    void test09() {

        var weapon1 = new  Weapon(-20, 1, 1, 40, -2);
        var weapon2 = new  Weapon(20, 2, 2, -55, 3);

        var myArmy = new Army();

        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();

        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 2);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon2);
        enemyArmy.equipWarriorAtPosition(2, weapon2);

        assertFalse(Battle.straightFight(myArmy, enemyArmy));


    }

//    @Test
//    @DisplayName("10. Test Weapon")
//    void test10() {
//
//
//        var weapon1 = newKatana();
//        var weapon2 = newShield();
//
//        var myArmy = new Army();
//
//        myArmy.addUnits(Vampire::new, 2);
//        myArmy.addUnits(Rookie::new, 2);
//
//        var enemyArmy = new Army();
//
//        enemyArmy.addUnits(Warrior::new, 1);
//        enemyArmy.addUnits(Defender::new, 2);
//
//        myArmy.equipWarriorAtPosition(0, weapon1);
//        myArmy.equipWarriorAtPosition(1, weapon1);
//        myArmy.equipWarriorAtPosition(2, weapon2);
//        enemyArmy.equipWarriorAtPosition(0, weapon1);
//        enemyArmy.equipWarriorAtPosition(1, weapon2);
//        enemyArmy.equipWarriorAtPosition(2, weapon2);
//
//        assertTrue(Battle.straightFight(myArmy, enemyArmy));
//
//
//    }

    @Test
    @DisplayName("11. Test Weapon")
    void test11() {

        var weapon1 = newSword();
        var weapon2 = newGreatAxe();

        var myArmy = new Army();

        myArmy.addUnits(Vampire::new, 3);

        var enemyArmy = new Army();

        enemyArmy.addUnits(Warrior::new, 1);
        enemyArmy.addUnits(Defender::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon2);
        myArmy.equipWarriorAtPosition(1, weapon2);
        myArmy.equipWarriorAtPosition(2, weapon2);
        enemyArmy.equipWarriorAtPosition(0, weapon1);
        enemyArmy.equipWarriorAtPosition(1, weapon1);

        assertTrue(Battle.straightFight(myArmy, enemyArmy));


    }

    @Test
    @DisplayName("12. Test Weapon")
    void test12() {

        var weapon1 = newKatana();
        var weapon2 = newMagicWand();

        var myArmy = new Army();

        myArmy.addUnits(Rookie::new, 3);

        var enemyArmy = new Army();

        enemyArmy.addUnits(Defender::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, weapon1);
        myArmy.equipWarriorAtPosition(1, weapon1);
        myArmy.equipWarriorAtPosition(2, weapon1);
        enemyArmy.equipWarriorAtPosition(0, weapon2);
        enemyArmy.equipWarriorAtPosition(1, weapon2);

        assertFalse(Battle.straightFight(myArmy, enemyArmy));
    }


}
