package de.vinstee.aoc10;

public class CRT
{
    private final char[][] chars = new char[40][6];
    private int x = 0, y = 0;

    public void cycle(int spriteX)
    {
        char c = (this.x == spriteX - 1 || this.x == spriteX || this.x == spriteX + 1) ? '#' : '.';
        this.chars[this.x][this.y] = c;

        this.x++;

        if (this.x == this.chars.length)
        {
            this.x = 0;
            this.y++;
        }
    }

    public void print()
    {
        for (int i = 0; i < 6; i++)
        {
            StringBuilder line = new StringBuilder();

            for (int j = 0; j < 40; j++)
                line.append(this.chars[j][i]);

            System.out.println(line);
        }
    }
}
