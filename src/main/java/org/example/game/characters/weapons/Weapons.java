package org.example.game.characters.weapons;

public interface Weapons {

int getAttack();

int getHealth();

int getVampirism();

int getDefense();

int getHealthPower();


    static Weapon newSword() {
        return new Weapon.WeaponBuilder().attack(2).health(5).build();
    }

    static Weapon newShield() {
        return new Weapon.WeaponBuilder().attack(-1).health(20).defense(2).build();
    }

    static Weapon newGreatAxe() {

        return new Weapon.WeaponBuilder().attack(5).health(-15).defense(-2).vampirism(10).build();
    }

    static Weapon newKatana() {
        return new Weapon.WeaponBuilder().attack(6).health(-20).defense(-5).vampirism(50).build();
    }

    static Weapon newMagicWand() {
        return new Weapon.WeaponBuilder().attack(3).health(30).healthPower(3).build();
    }

    static Weapon newSuperWeapon() {
        return new Weapon.WeaponBuilder().attack(10).health(50).defense(5).vampirism(150).healthPower(8).build();
    }



}
