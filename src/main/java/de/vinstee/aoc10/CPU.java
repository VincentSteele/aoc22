package de.vinstee.aoc10;

import java.util.ArrayList;
import java.util.List;

public class CPU
{
    private int x = 1;
    private int i = 0;
    private int wait = 0;
    private int valueToAdd = 0;
    private final List<String> commandList = new ArrayList<>();

    public void addCommand(String line)
    {
        commandList.add(line);
    }

    public boolean cycle()
    {
        this.wait--;

        if (this.wait > 0)
            return true;

        if (this.valueToAdd != 0)
        {
            this.x += this.valueToAdd;
            this.valueToAdd = 0;
        }

        if (this.i == this.commandList.size())
            return false;

        String[] command = this.commandList.get(this.i).split(" ");
        this.i++;

        if (command.length == 1)
        {
            this.wait = 0;
        }
        else
        {
            this.valueToAdd = Integer.parseInt(command[1]);
            this.wait = 2;
        }

        return true;
    }

    public int getX()
    {
        return x;
    }
}
