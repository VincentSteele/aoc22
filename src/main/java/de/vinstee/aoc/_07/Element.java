package de.vinstee.aoc._07;

public abstract class Element
{
    private final String name;

    protected Element(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public abstract int getSize();
}
