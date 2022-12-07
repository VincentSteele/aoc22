package de.vinstee.aoc._06;

import java.util.ArrayList;
import java.util.List;

public class Sequence
{
    private final List<Character> characters;
    private final int maxSize;

    public Sequence(int size)
    {
        characters = new ArrayList<>(size);
        this.maxSize = size;
    }

    public void add(char character)
    {
        if (characters.size() == maxSize)
            characters.remove(0);

        characters.add(character);
    }

    public boolean hasNoDuplicateCharacter()
    {
        for (int i = 0; i < characters.size(); i++)
            for (int j = i + 1; j < characters.size(); j++)
                if (characters.get(i).equals(characters.get(j)))
                    return false;

        return true;
    }
}
