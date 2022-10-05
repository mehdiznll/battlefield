package org.example.game.characters;

import lombok.Setter;
import org.example.game.characters.weapons.Weapon;

@Setter
public class Defender extends Warrior {

    private int defence = 2;

    public Defender() {

        super(60, 3);
    }

    public int getDefence() {
        return defence;
    }

//    public void setDefence(int defence) {
//        this.defence = defence;
//    }

    @Override
    public void receiveDamage(HasAttack damager) {
        int reducedDamage = Math.max(0, damager.getAttack() - getDefence());
        super.receiveDamage(() -> reducedDamage);

    }


    @Override
    public void equipWeapon(Weapon weaponType) {
        super.equipWeapon(weaponType);
        setDefence(getDefence() + weaponType.getDefense());
    }
}
