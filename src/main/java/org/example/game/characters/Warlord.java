package org.example.game.characters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.function.Predicate.not;

public class Warlord extends Defender {

    public List<Warrior> moveUnits(Iterator<Warrior> iterator) {
        List<Warrior> warriorList = new ArrayList<>();
        while (iterator.hasNext()) {
            warriorList.add(iterator.next());
        }
        var lancers = warriorList.stream()
                .filter(Lancer.class::isInstance)
                .toList();
        var healers = warriorList.stream()
                .filter(Healer.class::isInstance)
                .toList();
        var otherWarriors = warriorList.stream()
                .filter(not(Lancer.class::isInstance))
                .filter(not(Healer.class::isInstance))
                .filter(not(Warlord.class::isInstance))
                .toList();

        List<Warrior> out = new ArrayList<>();
        out.addAll(lancers);
        out.addAll(otherWarriors);
        out.addAll(Math.min(out.size(), 1), healers);
        out.add(this);

        return out;
    }
}
