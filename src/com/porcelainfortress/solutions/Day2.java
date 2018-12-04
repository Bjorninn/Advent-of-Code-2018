package com.porcelainfortress.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2
{
    public void PuzzleOne(List<String> inputs)
    {
        int doubles = 0;
        int triples = 0;

        Map<Character, Integer> counts = new HashMap<>(inputs.get(0).length());

        for (String input : inputs)
        {
            char[] chars = input.toCharArray();

            for (char c : chars)
            {
                if (counts.containsKey(c))
                {
                    counts.put(c, counts.get(c) + 1);
                }
                else
                {
                    counts.put(c, 1);
                }
            }

            int possibleDoubles = 0;
            int possibleTriples = 0;

            for (char c : counts.keySet())
            {
                if (counts.get(c) == 2)
                {
                    possibleDoubles++;
                }

                if (counts.get(c) == 3)
                {
                    possibleTriples++;
                }
            }

            if (possibleDoubles > 0)
            {
                doubles++;
            }

            if (possibleTriples > 0)
            {
                triples++;
            }

            counts.clear();
        }

        int checksum = doubles * triples;

        System.out.println("Day 2.1 solution: " + checksum);
    }

    public void PuzzleTwo(List<String> inputs)
    {
        char[] idOne = null;
        char[] idTwo = null;

        outerLoop:
        for (int i = 0; i < inputs.size(); i++)
        {
            final char[] input = inputs.get(i).toCharArray();
            final int count = input.length;

            for (int j = i + 1; j < inputs.size(); j++)
            {
                final char[] comparison = inputs.get(j).toCharArray();

                if (count == comparison.length)
                {
                    int diff = 0;
                    for (int x = 0; x < count; x++)
                    {
                        if (input[x] != comparison[x])
                        {
                            diff++;

                            if (diff > 1)
                            {
                                break;
                            }
                        }
                    }

                    if (diff == 1)
                    {
                        idOne = input;
                        idTwo = comparison;
                        break outerLoop;
                    }
                }

            }
        }

        if (idOne != null)
        {
            StringBuilder output = new StringBuilder();

            for (int x = 0; x < idOne.length; x++)
            {
                if (idOne[x] == idTwo[x])
                {
                    output.append(idOne[x]);
                }
            }

            System.out.println("Day 2.2 solution: " + output.toString());
        }
    }
}
