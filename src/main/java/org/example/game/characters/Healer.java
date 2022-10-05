package org.example.game.characters;

import lombok.Data;
import org.example.game.characters.weapons.Weapon;

@Data
public class Healer extends Warrior {

    private int healing = 2;

    public Healer() {
        super(60, 0);
    }

    public void heal(Warrior injuredWarrior) {

        injuredWarrior.setHealth(injuredWarrior.getHealth() + healing);

    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        // healer dont have attack skills
    }

    @Override
    public void equipWeapon(Weapon weaponType) {
        super.equipWeapon(weaponType);
        setHealth(getHealth() + weaponType.getHealth());
        setHealing(getHealing() + weaponType.getHealthPower());
    }
}
