package org.example.game;

import org.example.game.characters.Knight;
import org.example.game.characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {


    @Test
    void smokeTest() {

        //Given
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        // when
        var res1 = Battle.fight(chuck, bruce);
        var res2 = Battle.fight(dave, carl);


        //then
        assertTrue(res1);
        assertFalse(res2);
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());

    }

    @Test
    @DisplayName("1. Fight")
    void test01() {
        var carl = new Warrior();
        var jim = new Knight();

        var res = Battle.fight(carl, jim);

        assertFalse(res, "Knight should have won");

    }

    @Test
    @DisplayName("2. Fight")
    void test02() {
        var ramon = new Knight();
        var slevin = new Warrior();

        var res = Battle.fight(ramon, slevin);

        assertTrue(res, "Knight won the fight");

    }

    @Test
    @DisplayName("3. Fight")
    void test03() {
        var bob = new Warrior();
        var mars = new Warrior();

        var res = Battle.fight(bob, mars);

        assertTrue(bob.isAlive());

        // assertTrue(res, "Bob won the fight");

    }

    @Test
    @DisplayName("4. Fight")
    void test04() {
        var zeus = new Knight();
        var godKiller = new Warrior();

        var res = Battle.fight(zeus, godKiller);

        assertTrue(zeus.isAlive());

        //   assertTrue(res, "The Knight won the fight");

    }

    @Test
    @DisplayName("5. Fight")
    void test05() {
        var husband = new Warrior();
        var wife = new Warrior();

        var res = Battle.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void test06() {
        var dragon = new Warrior();
        var knight = new Knight();

        var res = Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());

//        assertTrue(res, "Bob won the fight");

    }

    @Test
    @DisplayName("7. Fight")
    void test07() {
        var unit_1 = new Warrior();
        var unit_2 = new Knight();
        var unit_3 = new Warrior();

        Battle.fight(unit_1, unit_2);
        var res2 = Battle.fight(unit_2, unit_3);

        assertFalse(res2);

    }


    @ParameterizedTest
    @MethodSource("checkFightResults")
    void checkFight(Warrior warrior1, Warrior warrior2, boolean expected) {
        var res = Battle.fight(warrior1, warrior2);
        assertEquals(expected, res);

    }


    static Stream<Arguments> checkFightResults() {
        return Stream.of(
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Knight(), new Knight(), true),
                Arguments.of(new Warrior(), new Knight(), false)
        );

    }

}

