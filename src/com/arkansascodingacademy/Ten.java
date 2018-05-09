package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Ten
{
    private final int SERIAL_NUMBER;
    private final int YEAR;
    private final BigDecimal COLLECTIBLE_VALUE;
    private final BigDecimal FACE_VALUE;

    public Ten(int serialNum, int year)
    {
        this.SERIAL_NUMBER = serialNum;
        this.YEAR = year;
        this.FACE_VALUE = new BigDecimal("10.00");
        if (serialNum < 1000)
        {
            this.COLLECTIBLE_VALUE = FACE_VALUE.multiply(new BigDecimal("10"));
        }
        else
        {
            this.COLLECTIBLE_VALUE = FACE_VALUE;
        }
    }

    public BigDecimal getCollectibleValue()
    {
        return COLLECTIBLE_VALUE;
    }

    public BigDecimal getFaceValue()
    {
        return FACE_VALUE;
    }

    public int getSerialNumber()
    {
        return SERIAL_NUMBER;
    }
}
