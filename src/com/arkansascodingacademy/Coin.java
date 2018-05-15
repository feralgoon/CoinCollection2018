package com.arkansascodingacademy;

public abstract class Coin
{
    private int year;

    public Coin(int year)
    {
        this.year = year;
    }

    public final int getYear()
    {
        return year;
    }
}
