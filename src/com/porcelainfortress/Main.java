package com.porcelainfortress;

import com.porcelainfortress.files.FileTools;
import com.porcelainfortress.solutions.Day1;
import com.porcelainfortress.solutions.Day3;
import com.porcelainfortress.solutions.Day2;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        int[] inputsDay1 = FileTools.GetLinesAsInt("./input/day_1_1.txt");
        List<String> inputsDay2 = FileTools.GetLines("./input/day_2_1.txt");
        List<String> inputsDay3 = FileTools.GetLines("./input/day_3_1.txt");

        Day1 d1 = new Day1();
        d1.PuzzleOne(inputsDay1);
        d1.PuzzleTwo(inputsDay1);

        Day2 d2 = new Day2();
        d2.PuzzleOne(inputsDay2);
        d2.PuzzleTwo(inputsDay2);

        Day3 d3 = new Day3();
        d3.PuzzleOne(inputsDay3);
        d3.PuzzleTwo();
    }
}
