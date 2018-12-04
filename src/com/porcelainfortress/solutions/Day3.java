package com.porcelainfortress.solutions;

import com.porcelainfortress.data.Claim;

import java.util.List;

public class Day3
{
    private Claim[] claims;
    private int[][] fabric;

    public void PuzzleOne(List<String> inputs)
    {
        int fabricWidth = 0;
        int fabricHeight = 0;
        int squares = 0;

        claims = new Claim[inputs.size()];

        for (int i = 0; i < inputs.size(); i++)
        {
            Claim claim = ProcessClaim(inputs.get(i));
            claims[i] = claim;

            int mw = claim.x + claim.width;
            int mh = claim.y + claim.height;

            if (mw > fabricWidth)
            {
                fabricWidth = mw;
            }

            if (mh > fabricHeight)
            {
                fabricHeight = mh;
            }
        }

        fabric = new int[fabricWidth][fabricHeight];

        for (int i = 0; i < fabricWidth; i++)
        {
            for (int j = 0; j < fabricHeight; j++)
            {
                fabric[i][j] = 0;
            }
        }

        for (Claim claim : claims)
        {
            final int cw = claim.x + claim.width;
            final int cy = claim.y + claim.height;

            for (int x = claim.x; x < cw; x++)
            {
                for (int y = claim.y; y < cy; y++)
                {
                    if (fabric[x][y] == 0)
                    {
                        fabric[x][y] = 1;
                    }
                    else if (fabric[x][y] == 1)
                    {
                        fabric[x][y] = 2;
                        squares++;
                    }
                }
            }
        }

        System.out.println("Day 3.1 solution: " + squares);
    }

    public void PuzzleTwo()
    {
        for (Claim claim : claims)
        {
            final int cw = claim.x + claim.width;
            final int cy = claim.y + claim.height;
            boolean goodSquare = true;

            outerLoop:
            for (int x = claim.x; x < cw; x++)
            {
                for (int y = claim.y; y < cy; y++)
                {
                    if (fabric[x][y] > 1)
                    {
                        goodSquare = false;
                        break outerLoop;
                    }
                }
            }

            if (goodSquare)
            {
                System.out.println("Day 3.2 solution: " + claim.id);

            }
        }
    }

    private Claim ProcessClaim(String line)
    {
        line = line.trim();

        String[] split = line.split(" ");

        String id = split[0].trim();
        String pos = split[2].replace(":", "").trim();
        String size = split[3].trim();

        String[] posSplit = pos.split(",");
        String[] sizeSplit = size.split("x");

        int x = Integer.valueOf(posSplit[0]);
        int y = Integer.valueOf(posSplit[1]);

        int w = Integer.valueOf(sizeSplit[0]);
        int h = Integer.valueOf(sizeSplit[1]);

        return new Claim(id, x, y, w, h);
    }
}
