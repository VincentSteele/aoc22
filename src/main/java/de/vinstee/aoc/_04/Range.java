package de.vinstee.aoc._04;

public class Range
{
    private int low;
    private int high;

    public Range(int low, int high)
    {
        this.low = low;
        this.high = high;
    }

    public Range(String low, String high)
    {
        this(Integer.parseInt(low), Integer.parseInt(high));
    }

    public boolean isContained(Range other)
    {
        return this.low >= other.getLow() && this.high <= other.getHigh();
    }

    public boolean isOverlapping(Range other)
    {
        return this.high >= other.getLow() && other.getHigh() >= this.low;
    }

    public int getLow()
    {
        return low;
    }
    public void setLow(int low)
    {
        this.low = low;
    }
    public int getHigh()
    {
        return high;
    }
    public void setHigh(int high)
    {
        this.high = high;
    }
}
