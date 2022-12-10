package de.vinstee.aoc06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AOC6
{
    private static final String INPUT_FILE = "./resources/aoc6/input.txt";
    private static final int SEQUENCE_SIZE = 4;

    public static void main(String[] args) throws IOException
    {
        String input = Files.readString(Path.of(INPUT_FILE));
        Sequence sequence = new Sequence(SEQUENCE_SIZE);

        int i = 0;

        while (i < input.length())
        {
            sequence.add(input.charAt(i));

            if (i >= SEQUENCE_SIZE && sequence.hasNoDuplicateCharacter())
                break;

            i++;
        }

        System.out.println("Characters processed before marker: " + (i + 1));
    }
}