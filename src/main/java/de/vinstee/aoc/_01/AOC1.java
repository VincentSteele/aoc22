package de.vinstee.aoc._01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AOC1
{
    public static void main(String[] args) throws IOException
    {
        List<Integer> elves = new ArrayList<>();
        elves.add(0);

        BufferedReader reader = new BufferedReader(new FileReader("./resources/aoc1/input.txt"));

        int currentElf = 0;

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            if (line.equals(""))
            {
                elves.add(0);
                currentElf++;
            }
            else
            {
             elves.set(currentElf, elves.get(currentElf) + Integer.parseInt(line));
            }
        }

        elves.sort(Comparator.comparingInt(i -> i));
        Collections.reverse(elves);

        elves.forEach(System.out::println);
        System.out.println("Top 3 combined: " + (elves.get(0) + elves.get(1) + elves.get(2)));

        reader.close();
    }
}