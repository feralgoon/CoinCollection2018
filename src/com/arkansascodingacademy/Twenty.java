package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Twenty implements ICurrency
{
    private final int SERIAL_NUMBER;
    private final int YEAR;
    private final BigDecimal COLLECTIBLE_VALUE;
    private final BigDecimal FACE_VALUE;

    public Twenty(int serialNum, int year)
    {
        this.SERIAL_NUMBER = serialNum;
        this.YEAR = year;
        this.FACE_VALUE = new BigDecimal("20.00");
        if (serialNum < 1000)
        {
            this.COLLECTIBLE_VALUE = FACE_VALUE.multiply(new BigDecimal("10"));
        }
        else
        {
            this.COLLECTIBLE_VALUE = FACE_VALUE;
        }
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        return COLLECTIBLE_VALUE;
    }

    @Override
    public String getName()
    {
        return "Twenty Dollar Bill";
    }

    @Override
    public BigDecimal getFaceValue()
    {
        return FACE_VALUE;
    }

    public int getSerialNumber()
    {
        return SERIAL_NUMBER;
    }
}
