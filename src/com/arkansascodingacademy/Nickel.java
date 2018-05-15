package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Nickel extends Coin implements ICurrency
{
    private final BigDecimal FACE_VALUE;
    private final BigDecimal VALUE_PER_YEAR;
    private final int VALUE_YEAR;

    public Nickel(int year)
    {
        super(year);
        this.FACE_VALUE = new BigDecimal("0.05");
        this.VALUE_YEAR = 1935;
        this.VALUE_PER_YEAR = new BigDecimal("0.10");
    }

    @Override
    public BigDecimal getFaceValue()
    {
        return FACE_VALUE;
    }

    @Override
    public BigDecimal getCollectibleValue()
    {
        BigDecimal result = FACE_VALUE;
        if (getYear() < VALUE_YEAR)
        {
            String ageModifier = "" + (VALUE_YEAR - getYear());
            BigDecimal modifier= new BigDecimal(ageModifier);
            BigDecimal valueAmount = VALUE_PER_YEAR.multiply(modifier);
            result = result.add(valueAmount);
        }
        return result;
    }

    @Override
    public String getName()
    {
        return "Nickel";
    }
}
