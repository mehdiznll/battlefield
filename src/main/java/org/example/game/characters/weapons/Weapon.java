package org.example.game.characters.weapons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Weapon implements Weapons{

private int attack;
private int health;
private int defense;
private int vampirism;
private int healthPower;


}

