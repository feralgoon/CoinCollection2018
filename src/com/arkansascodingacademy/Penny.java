package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Penny
{
    private final BigDecimal FACE_VALUE;
    private final BigDecimal VALUE_PER_YEAR;
    private final int VALUE_YEAR;

    private int yearMinted;

    public Penny(int year)
    {
        this.yearMinted = year;
        this.FACE_VALUE = new BigDecimal("0.01");
        this.VALUE_YEAR = 1945;
        this.VALUE_PER_YEAR = new BigDecimal("0.03");
    }

    public BigDecimal getFaceValue()
    {
        return FACE_VALUE;
    }

    public BigDecimal getCollectibleValue()
    {
        BigDecimal result = FACE_VALUE;
        if (yearMinted < VALUE_YEAR)
        {
            String ageModifier = "" + (VALUE_YEAR - yearMinted);
            BigDecimal modifier= new BigDecimal(ageModifier);
            BigDecimal valueAmount = VALUE_PER_YEAR.multiply(modifier);
            result = result.add(valueAmount);
        }
        return result;
    }
}
