package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Dime extends Coin implements ICurrency
{
    private final BigDecimal FACE_VALUE;

    public Dime(int year)
    {
        super(year);
        this.FACE_VALUE = new BigDecimal("0.10");
    }

    public BigDecimal getFaceValue()
    {
        return FACE_VALUE;
    }

    public BigDecimal getCollectibleValue()
    {
        return getFaceValue();
    }

    @Override
    public String getName()
    {
        return "Dime";
    }
}
