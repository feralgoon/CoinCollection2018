package com.arkansascodingacademy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CoinCollectionTest
{
    private static final BigDecimal THREE_SEVENTEEN = new BigDecimal("3.17");

    private CoinCollection coinCollection;

    @BeforeEach
    void setUp()
    {
        coinCollection = new CoinCollection(10, 5, 3, 2);
    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void addPenny()
    {
        coinCollection.addPenny(1900);
        coinCollection.addPenny(1940);
    }

    @Test
    void addNickel()
    {
        coinCollection.addNickel(1903);
        coinCollection.addNickel(1993);
    }

    @Test
    void addDime()
    {
        coinCollection.addDime(1905);
        coinCollection.addDime(1978);
    }

    @Test
    void addQuarter()
    {
        coinCollection.addQuarter(1908);
        coinCollection.addQuarter(2008);
    }

    @Test
    void getPenniesFaceValue()
    {
        coinCollection.addPenny(1900);
        coinCollection.addPenny(1940);

        assertEquals(new BigDecimal("0.04"), coinCollection.getPenniesFaceValue());
    }

    @Test
    void getPenniesCollectibleValue()
    {
        coinCollection.addPenny(1900);  //1.36
        coinCollection.addPenny(1940);  //0.16

        assertEquals(new BigDecimal("1.54"), coinCollection.getPenniesCollectibleValue());
    }

    @Test
    void getNickelsFaceValue()
    {
        coinCollection.addNickel(1903);
        coinCollection.addNickel(1993);

        assertEquals(new BigDecimal("0.25"), coinCollection.getNickelsFaceValue());

    }

    @Test
    void getNickelsCollectibleValue()
    {
        coinCollection.addNickel(1903); //3.25
        coinCollection.addNickel(1993); //0.05

        assertEquals(new BigDecimal("3.45"), coinCollection.getNickelsCollectibleValue());
    }

    @Test
    void getDimesFaceValue()
    {
        coinCollection.addDime(1905);
        coinCollection.addDime(1978);

        assertEquals(new BigDecimal("0.70"), coinCollection.getDimesFaceValue());

    }

    @Test
    void getDimesCollectibleValue()
    {
        coinCollection.addDime(1905);
        coinCollection.addDime(1978);

        assertEquals(new BigDecimal("0.70"), coinCollection.getDimesCollectibleValue());
    }

    @Test
    void getQuartersFaceValue()
    {
        coinCollection.addQuarter(1908);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("3.00"), coinCollection.getQuartersFaceValue());

    }

    @Test
    void getQuartersCollectibleValue()
    {
        coinCollection.addQuarter(1908); //3.55
        coinCollection.addQuarter(2008); //0.25

        assertEquals(new BigDecimal("6.30"), coinCollection.getQuartersCollectibleValue());
    }

    @Test
    void getFaceValue()
    {
        assertEquals(THREE_SEVENTEEN, coinCollection.getFaceValue());

        coinCollection.addPenny(1900);
        coinCollection.addNickel(1903);
        coinCollection.addDime(1905);
        coinCollection.addQuarter(1908);

        coinCollection.addPenny(1940);
        coinCollection.addNickel(1993);
        coinCollection.addDime(1978);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("3.99"), coinCollection.getFaceValue());


    }

    @Test
    void getCollectibleValue()
    {

        assertEquals(THREE_SEVENTEEN, coinCollection.getCollectibleValue());

        coinCollection.addPenny(1900);
        coinCollection.addNickel(1903);
        coinCollection.addDime(1905);
        coinCollection.addQuarter(1908);

        coinCollection.addPenny(1940);
        coinCollection.addNickel(1993);
        coinCollection.addDime(1978);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("11.99"), coinCollection.getCollectibleValue());

    }


    @Test
    void isInCollection()
    {
        coinCollection.addHundred(34556,2015);
        coinCollection.addTwenty(2,2000);
        coinCollection.addOne(4555,2014);

        assertTrue(coinCollection.isInCollection(2));
        assertTrue(coinCollection.isInCollection(4555));
        assertFalse(coinCollection.isInCollection(32323));
    }

    @Test
    void addHundred()
    {
        coinCollection.addHundred(34451,2013);
        coinCollection.addHundred(423, 1967);
    }

    @Test
    void addTwenty()
    {
        coinCollection.addTwenty(45454, 2018);
        coinCollection.addTwenty(997,1989);
    }

    @Test
    void addTen()
    {
        coinCollection.addTen(43323,2017);
        coinCollection.addTen(132,1934);
    }

    @Test
    void addFive()
    {
        coinCollection.addFive(34456,2015);
        coinCollection.addFive(235,1991);
    }

    @Test
    void addOne()
    {
        coinCollection.addOne(13445,2005);
        coinCollection.addOne(34490,2018);
    }

    @Test
    void getHundredsCollectibleValue()
    {
        coinCollection.addHundred(350,1954);
        coinCollection.addHundred(3445,2003);

        assertEquals(new BigDecimal("1100.00"),coinCollection.getHundredsCollectibleValue());
    }

    @Test
    void getTwentiesCollectibleValue()
    {
        coinCollection.addTwenty(350,1954);
        coinCollection.addTwenty(44,2003);
        coinCollection.addTwenty(344444,2018);

        assertEquals(new BigDecimal("420.00"),coinCollection.getTwentiesCollectibleValue());
    }

    @Test
    void getTensCollectibleValue()
    {
        coinCollection.addTen(5667,1993);
        coinCollection.addTen(999,1943);

        assertEquals(new BigDecimal("110.00"),coinCollection.getTensCollectibleValue());

    }

    @Test
    void getFivesCollectibleValue()
    {
        coinCollection.addFive(456,1954);
        coinCollection.addFive(321,2003);
        coinCollection.addFive(43334,2017);

        assertEquals(new BigDecimal("105.00"),coinCollection.getFivesCollectibleValue());
    }

    @Test
    void getOnesCollectibleValue()
    {
        coinCollection.addOne(1001,2009);
        coinCollection.addOne(567,1923);

        assertEquals(new BigDecimal("11.00"),coinCollection.getOnesCollectibleValue());
    }

    @Test
    void getHundredsFaceValue()
    {
        coinCollection.addHundred(342,1954);
        coinCollection.addHundred(43223,2004);
        coinCollection.addHundred(322222,2018);

        assertEquals(new BigDecimal("300.00"),coinCollection.getHundredsFaceValue());
    }

    @Test
    void getTwentiesFaceValue()
    {
        coinCollection.addTwenty(34554,1913);
        coinCollection.addTwenty(32,2009);
        coinCollection.addTwenty(345,1940);


        assertEquals(new BigDecimal("60.00"),coinCollection.getTwentiesFaceValue());
    }

    @Test
    void getTensFaceValue()
    {
        coinCollection.addTen(61,1912);
        coinCollection.addTen(34465,2010);

        assertEquals(new BigDecimal("20.00"),coinCollection.getTensFaceValue());
    }

    @Test
    void getFivesFaceValue()
    {
        coinCollection.addFive(34554,1913);
        coinCollection.addFive(32,2009);
        coinCollection.addFive(345,2018);

        assertEquals(new BigDecimal("15.00"),coinCollection.getFivesFaceValue());
    }

    @Test
    void getOnesFaceValue()
    {
        coinCollection.addOne(34554,1913);
        coinCollection.addOne(32,2009);

        assertEquals(new BigDecimal("2.00"),coinCollection.getOnesFaceValue());
    }

    @Test
    void CoinCollection()
    {
        CoinCollection coinCollection2 = new CoinCollection(new BigDecimal("277.99"));

        assertEquals(new BigDecimal("277.99"),coinCollection2.getCollectibleValue());
    }

    @Test
    void setCurrentYear()
    {
        coinCollection.setCurrentYear(2054);
        coinCollection.setCurrentYear(1956);
    }

    @Test
    void getCollectibleValueIn2028()
    {

        assertEquals(THREE_SEVENTEEN, coinCollection.getCollectibleValue());

        coinCollection.setCurrentYear(2028);

        coinCollection.addPenny(1900);
        coinCollection.addNickel(1903);
        coinCollection.addDime(1905);
        coinCollection.addQuarter(1908);

        coinCollection.addPenny(1940);
        coinCollection.addNickel(1993);
        coinCollection.addDime(1978);
        coinCollection.addQuarter(2008);

        assertEquals(new BigDecimal("14.79"), coinCollection.getCollectibleValue());

    }
}