package de.vinstee.aoc08;

import java.util.Arrays;

public class Forest
{
    private final int[][] trees;
    private final int w, h;
    private int x, y;

    public Forest(int width, int height)
    {
        this.trees  = new int[width][height];
        this.w = width;
        this.h = height;
        this.x = 0;
        this.y = 0;
    }

    public void addTree(int size)
    {
        this.trees[this.x][this.y] = size;

        this.x++;

        if (this.x == this.w)
        {
            this.x = 0;
            this.y++;
        }
    }

    public void print()
    {
        for (int[] tree : this.trees)
            System.out.println(Arrays.toString(tree));
    }

    public int treesVisible()
    {
        int count = 0;

        for (int x = 0; x < this.w; x++)
            for (int y = 0; y < this.h; y++)
                if (this.isVisible(x, y))
                    count++;

        return count;
    }

    private boolean isVisible(int treeX, int treeY)
    {
        if (treeX == 0 || treeY == 0 || treeX == this.w - 1 || treeY == this.h - 1)
            return true;

        int thisSize = this.trees[treeX][treeY];
        int invisibleSides = 0;

        for (int side = 0; side < 4; side++)
        {
            int x = treeX;
            int y = treeY;

            while (true)
            {
                switch (side)
                {
                    case 0 -> y--;
                    case 1 -> x++;
                    case 2 -> y++;
                    case 3 -> x--;
                }

                if (x == -1 || y == -1 || x == this.h || y == this.w)
                    break;

                if (this.trees[x][y] >= thisSize)
                {
                    invisibleSides++;
                    break;
                }
            }
        }

        return invisibleSides < 4;
    }

    public int highestScore()
    {
        int maxScore = 0;

        for (int x = 0; x < this.w; x++)
            for (int y = 0; y < this.h; y++)
            {
                int score = this.scenicScore(x, y);

                if (score > maxScore)
                    maxScore = score;
            }

        return maxScore;
    }

    private int scenicScore(int treeX, int treeY)
    {
        int thisSize = this.trees[treeX][treeY];
        int score = 1;

        for (int side = 0; side < 4; side++)
        {
            int x = treeX;
            int y = treeY;
            int distance = 0;

            while (true)
            {
                switch (side)
                {
                    case 0 -> y--;
                    case 1 -> x++;
                    case 2 -> y++;
                    case 3 -> x--;
                }

                if (x == -1 || y == -1 || x == this.h || y == this.w)
                    break;

                distance++;

                if (this.trees[x][y] >= thisSize)
                    break;
            }

            score *= distance;
        }

        return score;
    }
}
