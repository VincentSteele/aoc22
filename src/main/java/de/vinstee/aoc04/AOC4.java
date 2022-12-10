package de.vinstee.aoc04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AOC4
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("./resources/aoc4/input.txt")); //NOSONAR
        int totalContainedRanges = 0;

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            String elf1 = line.substring(0, line.indexOf(","));
            String elf2 = line.substring(line.indexOf(",") + 1);

            Range range1 = new Range(elf1.substring(0, elf1.indexOf("-")), elf1.substring(elf1.indexOf("-") + 1));
            Range range2 = new Range(elf2.substring(0, elf2.indexOf("-")), elf2.substring(elf2.indexOf("-") + 1));

            if (range1.isContained(range2) || range2.isContained(range1))
                totalContainedRanges++;
        }

        System.out.println("Total contained ranges: " + totalContainedRanges);
        reader.close();
    }
}