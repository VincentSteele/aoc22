package de.vinstee.aoc._08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AOC8
{
    private static final  String INPUT_FILE = "./resources/aoc8/input.txt";

    public static void main(String[] args) throws IOException
    {
        String input = Files.readString(Path.of(INPUT_FILE));

        int width  = input.indexOf('\n') - 1;
        int height = (int) input.chars().filter(c -> c == '\n').count() + 1;

        Forest forest = new Forest(width, height);

        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isDigit(input.charAt(i)))
            {
                String tree = input.substring(i, i + 1);
                forest.addTree(Integer.parseInt(tree));
            }
        }

        forest.print();

        System.out.println("\nTrees visible from outside the grid : " + forest.treesVisible());
        System.out.println("Highest scenic score: " + forest.highestScore());
    }
}