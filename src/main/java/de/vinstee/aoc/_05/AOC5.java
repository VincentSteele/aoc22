package de.vinstee.aoc._05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AOC5
{
    private final static String INPUT_FILE = "./resources/aoc5/input.txt";

    private static String inputCrates = "";
    private static String inputStacks = "";
    private static String inputMoves  = "";
    private static String topCrates   = "";

    private static final List<List<String>> crates = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        readInput();
        createLists();
        addCrates();
        doMoves();

        crates.forEach(c -> topCrates += c.get(c.size() - 1));
        System.out.println("Top crate of each stack: " + topCrates);

        crates.clear();
        createLists();
        addCrates();
        doMoves9001();

        topCrates = "";
        crates.forEach(c -> topCrates += c.get(c.size() - 1));
        System.out.println("Top crate of each stack (Model 9001): " + topCrates);
    }

    private static void readInput() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            char[] chars = line.toCharArray();

            if (chars.length == 0)
                continue;

            int i = 0;

            while (i < chars.length && Character.isWhitespace(chars[i]))
                i++;

            switch (Character.toString(chars[i]))
            {
                case "1" -> inputStacks  = line;
                case "[" -> inputCrates += line + "\n";
                case "m" -> inputMoves  += line + "\n";
            }
        }
    }

    private static void createLists()
    {
        String lastChar = inputStacks.substring(inputStacks.length() - 1);
        int stackCount = Integer.parseInt(lastChar);

        for (int i = 0; i < stackCount; i++)
            crates.add(new ArrayList<>());
    }

    private static void addCrates()
    {
        String[] lines = inputCrates.split("\n");

        for (String line : lines)
        {
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) != '[')
                    continue;

                crates.get(j/4).add(String.valueOf(line.charAt(j + 1)));
            }
        }

        crates.forEach(Collections::reverse);
    }

    private static void doMoves()
    {
        String[] lines = inputMoves.split("\n");

        for (String line : lines)
        {
            String[] strings = line.split(" ");

            int amount = Integer.parseInt(strings[1]);
            int from   = Integer.parseInt(strings[3]);
            int to     = Integer.parseInt(strings[5]);

            List<String> source = crates.get(from - 1);
            List<String> target = crates.get(to - 1);

            for (int i = 0; i < amount; i++)
                target.add(source.remove(source.size() - 1));
        }
    }

    private static void doMoves9001()
    {
        String[] lines = inputMoves.split("\n");

        for (String line : lines)
        {
            String[] strings = line.split(" ");

            int amount = Integer.parseInt(strings[1]);
            int from   = Integer.parseInt(strings[3]);
            int to     = Integer.parseInt(strings[5]);

            List<String> source = crates.get(from - 1);
            List<String> target = crates.get(to - 1);

            List<String> movedCrates = new ArrayList<>();

            for (int i = 0; i < amount; i++)
                movedCrates.add(source.remove(source.size() - 1));

            Collections.reverse(movedCrates);

            target.addAll(movedCrates);
        }
    }
}