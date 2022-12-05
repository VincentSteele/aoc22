package de.vinstee.aoc._02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class AOC2
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Integer> shapeScores = Map.of(
                /* ROCK     */ "X", 1,
                /* PAPER    */ "Y", 2,
                /* SCISSORS */ "Z", 3
        );

        Map<String, Integer> outcomeScores = Map.of(
                /* WON  */ "W", 6,
                /* DRAW */ "D", 3,
                /* LOST */ "L", 0
        );

        int totalScore = 0;

        BufferedReader reader = new BufferedReader(new FileReader("./resources/aoc2/input.txt")); //NOSONAR

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            String opponent = line.substring(0, 1);
            String shape = line.substring(2, 3);

            String outcome;

            if (opponent.equals("A")) // ROCK
            {
                outcome = switch (shape)
                {
                    case "X": yield "D"; // ROCK
                    case "Y": yield "W"; // PAPER
                    case "Z": yield "L"; // SCISSORS
                    default : throw new RuntimeException();
                };
            }
            else if (opponent.equals("B")) // PAPER
            {
                outcome = switch (shape)
                        {
                            case "X": yield "L"; // ROCK
                            case "Y": yield "D"; // PAPER
                            case "Z": yield "W"; // SCISSORS
                            default : throw new RuntimeException();
                        };
            }
            else // SCISSORS
            {
                outcome = switch (shape)
                        {
                            case "X": yield "W"; // ROCK
                            case "Y": yield "L"; // PAPER
                            case "Z": yield "D"; // SCISSORS
                            default : throw new RuntimeException();
                        };
            }

            totalScore += shapeScores.get(shape) + outcomeScores.get(outcome);
        }

        System.out.println("Total score: " + totalScore);

        reader.close();
    }
}