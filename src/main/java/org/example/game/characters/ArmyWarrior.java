package org.example.game.characters;

import org.example.game.characters.Warrior;

public interface ArmyWarrior {

    Warrior getWarriorBehind();

    Warrior next();

    boolean hasNext();

}
