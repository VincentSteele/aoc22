package de.vinstee.aoc07;

public abstract class Element
{
    private final String name;

    protected Element(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public abstract int getSize();
}
