package com.porcelainfortress.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTools
{
    public static List<String> GetLines(String path)
    {
        List<String> lines = new ArrayList<>();

        try
        {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return lines;
    }

    public static int[] GetLinesAsInt(String path)
    {
        List<String> lines = GetLines(path);

        int[] numbers = new int[lines.size()];

        for (int i = 0; i < lines.size(); i++)
        {
            numbers[i] = Integer.valueOf(lines.get(i).trim());
        }

        return numbers;
    }
}
