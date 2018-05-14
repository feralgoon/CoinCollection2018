package com.arkansascodingacademy;

import java.math.BigDecimal;

public interface ICurrency
{
    BigDecimal getFaceValue();
    BigDecimal getCollectibleValue();
    String getName();
}
