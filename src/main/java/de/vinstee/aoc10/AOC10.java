package de.vinstee.aoc10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AOC10
{
    private static final  String INPUT_FILE = "./resources/aoc10.txt";

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
        CPU cpu = new CPU();
        CRT crt = new CRT();

        for (String line = reader.readLine(); line != null; line = reader.readLine())
            cpu.addCommand(line);

        int cycles = 0, sum = 0;

        while (cpu.cycle())
        {
            cycles++;

            if (cycles == 20 || (cycles - 20) % 40 == 0)
                sum += cpu.getX() * cycles;

            crt.cycle(cpu.getX());
        }

        System.out.println("Sum of signal strengths: " + sum + "\n");
        crt.print();
    }
}