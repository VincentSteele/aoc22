package de.vinstee.aoc._03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AOC3
{
    public static void main(String[] args) throws IOException
    {
        int totalPriorities = 0;

        BufferedReader reader = new BufferedReader(new FileReader("./resources/aoc3/input.txt")); //NOSONAR

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            String comp1 = line.substring(0, line.length() / 2);
            String comp2 = line.substring(line.length() / 2);

            String dupLetter = getDuplicateLetter(comp1, comp2);

            if (dupLetter != null)
                totalPriorities += getPriorityValue(dupLetter);
        }

        System.out.println("Total priority: " + totalPriorities);

        reader.close();
    }

    public static String getDuplicateLetter(String compartment1, String compartment2)
    {
        for (int i = 0; i < compartment1.length(); i++)
            for (int j = 0; j < compartment2.length(); j++)
                if (compartment1.charAt(i) == compartment2.charAt(j))
                    return compartment1.substring(i, i + 1);

        return null;
    }

    public static int getPriorityValue(String character)
    {
        int code = character.charAt(0);
        int priority;

        if (code >= 65 && code <=90) // ASCII Codes for big letters
            priority = code - 64 + 26;
        else
            priority = code - 96;

        return priority;
    }

    @Deprecated(forRemoval = true)
    public static int getPriorityValueLame(String character)
    {
        return switch (character)
                {
                    case "a": yield 1;
                    case "b": yield 2;
                    case "c": yield 3;
                    case "d": yield 4;
                    case "e": yield 5;
                    case "f": yield 6;
                    case "g": yield 7;
                    case "h": yield 8;
                    case "i": yield 9;
                    case "j": yield 10;
                    case "k": yield 11;
                    case "l": yield 12;
                    case "m": yield 13;
                    case "n": yield 14;
                    case "o": yield 15;
                    case "p": yield 16;
                    case "q": yield 17;
                    case "r": yield 18;
                    case "s": yield 19;
                    case "t": yield 20;
                    case "u": yield 21;
                    case "v": yield 22;
                    case "w": yield 23;
                    case "x": yield 24;
                    case "y": yield 25;
                    case "z": yield 26;
                    case "A": yield 27;
                    case "B": yield 28;
                    case "C": yield 29;
                    case "D": yield 30;
                    case "E": yield 31;
                    case "F": yield 32;
                    case "G": yield 33;
                    case "H": yield 34;
                    case "I": yield 35;
                    case "J": yield 36;
                    case "K": yield 37;
                    case "L": yield 38;
                    case "M": yield 39;
                    case "N": yield 40;
                    case "O": yield 41;
                    case "P": yield 42;
                    case "Q": yield 43;
                    case "R": yield 44;
                    case "S": yield 45;
                    case "T": yield 46;
                    case "U": yield 47;
                    case "V": yield 48;
                    case "W": yield 49;
                    case "X": yield 50;
                    case "Y": yield 51;
                    case "Z": yield 52;
                    default : throw new RuntimeException();
                };

    }
}