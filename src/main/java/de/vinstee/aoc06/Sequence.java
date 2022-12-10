package de.vinstee.aoc06;

import java.util.ArrayList;
import java.util.List;

public class Sequence
{
    private final List<Character> characters;
    private final int maxSize;

    public Sequence(int size)
    {
        this.characters = new ArrayList<>(size);
        this.maxSize = size;
    }

    public void add(char character)
    {
        if (this.characters.size() == this.maxSize)
            this.characters.remove(0);

        this.characters.add(character);
    }

    public boolean hasNoDuplicateCharacter()
    {
        for (int i = 0; i < this.characters.size(); i++)
            for (int j = i + 1; j < this.characters.size(); j++)
                if (this.characters.get(i).equals(this.characters.get(j)))
                    return false;

        return true;
    }
}
