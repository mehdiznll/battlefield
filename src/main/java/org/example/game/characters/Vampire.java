package org.example.game.characters;

import lombok.Data;
import org.example.game.characters.weapons.Weapon;

@Data
public class Vampire extends Warrior {
    private int vampirism = 50;

    public Vampire() {
        super(40, 4);

    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        int healthAfter = opponent.getHealth();
        int damageDealt = healthBefore - healthAfter;
        final int percents = 100;
        int healMyselfBy = damageDealt * vampirism / percents;
        setHealth(getHealth() + healMyselfBy);
    }

    @Override
    public void equipWeapon(Weapon weaponType) {
        super.equipWeapon(weaponType);
        setVampirism(getVampirism() + weaponType.getVampirism());
    }
}
