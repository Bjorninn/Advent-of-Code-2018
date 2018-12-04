package com.porcelainfortress.solutions;

import java.util.HashSet;

public class Day1
{
    public void PuzzleOne(int[] inputs)
    {
        int sum = 0;

        for (int input : inputs)
        {
            sum += input;
        }

        System.out.println("Day 1.1 solution: " + sum);
    }

    public void PuzzleTwo(int[] inputs)
    {
        HashSet<Integer> duplicates = new HashSet<>();

        final int length = inputs.length;
        int count = 0;
        int currentFrequency = 0;

        while (true)
        {
            if (duplicates.contains(currentFrequency))
            {
                System.out.println("Day 1.2 solution: " + currentFrequency);
                return;
            }
            duplicates.add(currentFrequency);

            if (count >= length)
            {
                count = 0;
            }

            currentFrequency += inputs[count];
            count++;
        }
    }
}
