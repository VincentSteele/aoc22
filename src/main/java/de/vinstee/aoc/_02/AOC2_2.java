package de.vinstee.aoc._02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class AOC2_2
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Integer> shapeScores = Map.of(
                /* ROCK     */ "R", 1,
                /* PAPER    */ "P", 2,
                /* SCISSORS */ "S", 3
        );

        Map<String, Integer> outcomeScores = Map.of(
                /* WON  */ "Z", 6,
                /* DRAW */ "Y", 3,
                /* LOST */ "X", 0
        );

        int totalScore = 0;

        BufferedReader reader = new BufferedReader(new FileReader("./resources/aoc2/input.txt")); //NOSONAR

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            String opponent = line.substring(0, 1);
            String outcome = line.substring(2, 3);

            String shape;

            if (opponent.equals("A")) // ROCK
            {
                shape = switch (outcome)
                {
                    case "X": yield "S";
                    case "Y": yield "R";
                    case "Z": yield "P";
                    default : throw new RuntimeException();
                };
            }
            else if (opponent.equals("B")) // PAPER
            {
                shape = switch (outcome)
                        {
                            case "X": yield "R";
                            case "Y": yield "P";
                            case "Z": yield "S";
                            default : throw new RuntimeException();
                        };
            }
            else // SCISSORS
            {
                shape = switch (outcome)
                        {
                            case "X": yield "P";
                            case "Y": yield "S";
                            case "Z": yield "R";
                            default : throw new RuntimeException();
                        };
            }

            totalScore += shapeScores.get(shape) + outcomeScores.get(outcome);
        }

        System.out.println("Total score: " + totalScore);

        reader.close();
    }
}