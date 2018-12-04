package com.porcelainfortress.data;

public class Claim
{
    public final String id;
    public final int x;
    public final int y;
    public final int width;
    public final int height;

    public Claim(String id, int x, int y, int width, int height)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
