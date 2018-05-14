package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoinCollection
{
    private List<Quarter> quarterList   = new ArrayList<>();
    private List<Dime> dimeList         = new ArrayList<>();
    private List<Nickel> nickelList     = new ArrayList<>();
    private List<Penny> pennyList       = new ArrayList<>();
    private List<One> onesList          = new ArrayList<>();
    private List<Five> fivesList        = new ArrayList<>();
    private List<Ten> tensList          = new ArrayList<>();
    private List<Twenty> twentiesList   = new ArrayList<>();
    private List<Hundred> hundredsList  = new ArrayList<>();

    private int currentYear;

    public CoinCollection(BigDecimal value)
    {
        currentYear = 2018;

        BigDecimal hundreds = value.divide(new BigDecimal("100.00"));
        value = value.remainder(new BigDecimal("100.00"));

        BigDecimal twenties = value.divide(new BigDecimal("20.00"));
        value = value.remainder(new BigDecimal("20.00"));

        BigDecimal tens = value.divide(new BigDecimal("10.00"));
        value = value.remainder(new BigDecimal("10.00"));

        BigDecimal fives = value.divide(new BigDecimal("5.00"));
        value = value.remainder(new BigDecimal("5.00"));

        BigDecimal ones = value.divide(new BigDecimal("1.00"));
        value = value.remainder(new BigDecimal("1.00"));

        BigDecimal quarters = value.divide(new BigDecimal("0.25"));
        value = value.remainder(new BigDecimal("0.25"));

        BigDecimal dimes = value.divide(new BigDecimal("0.10"));
        value = value.remainder(new BigDecimal("0.10"));

        BigDecimal nickels = value.divide(new BigDecimal("0.05"));
        value = value.remainder(new BigDecimal("0.05"));

        BigDecimal pennies = value.divide(new BigDecimal("0.01"));

        for(int i = 0; i < hundreds.intValue(); i++)
        {
            hundredsList.add(new Hundred(1000+i, 2000));
        }

        for(int i = 0; i < twenties.intValue(); i++)
        {
            twentiesList.add(new Twenty(2000+i, 2000));
        }

        for(int i = 0; i < tens.intValue(); i++)
        {
            tensList.add(new Ten(5000+i, 2000));
        }

        for(int i = 0; i < fives.intValue(); i++)
        {
            fivesList.add(new Five(10000+i, 2000));
        }

        for(int i = 0; i < ones.intValue(); i++)
        {
            onesList.add(new One(100000+i, 2000));
        }

        for(int i = 0; i < quarters.intValue(); i++)
        {
            quarterList.add(new Quarter(2000));
        }

        for(int i = 0; i < dimes.intValue(); i++)
        {
            dimeList.add(new Dime(2000));
        }

        for(int i = 0; i < nickels.intValue(); i++)
        {
            nickelList.add(new Nickel(2000));
        }

        for(int i = 0; i < pennies.intValue(); i++)
        {
            pennyList.add(new Penny(2000));
        }
    }

    public CoinCollection(int quarterCount, int dimeCount, int nickelCount, int pennyCount)
    {
        currentYear = 2018;

        for(int i = 0; i < quarterCount; i++)
        {
            quarterList.add(new Quarter(2000));
        }

        for(int i = 0; i < dimeCount; i++)
        {
            dimeList.add(new Dime(2000));
        }

        for(int i = 0; i < nickelCount; i++)
        {
            nickelList.add(new Nickel(2000));
        }

        for(int i = 0; i < pennyCount; i++)
        {
            pennyList.add(new Penny(2000));
        }
    }

    public void setCurrentYear(int year)
    {
        this.currentYear = year;
    }

    private BigDecimal checkAgeValue()
    {
        BigDecimal result = new BigDecimal("0.00");
        if (currentYear > 2018)
        {
            for(int j = 0; j < currentYear-2018; j++)
            {
                for(Quarter i : quarterList)
                {
                    result = result.add(new BigDecimal("0.01"));
                }
                for(Dime i : dimeList)
                {
                    result = result.add(new BigDecimal("0.01"));
                }
                for(Nickel i : nickelList)
                {
                    result = result.add(new BigDecimal("0.01"));
                }
                for(Penny i : pennyList)
                {
                    result = result.add(new BigDecimal("0.01"));
                }
            }
        }
        return result;
    }

    public BigDecimal getCollectibleValue()
    {
        BigDecimal result = getQuartersCollectibleValue();
        result = result.add(getDimesCollectibleValue());
        result = result.add(getNickelsCollectibleValue());
        result = result.add(getPenniesCollectibleValue());
        result = result.add(getHundredsCollectibleValue());
        result = result.add(getTwentiesCollectibleValue());
        result = result.add(getTensCollectibleValue());
        result = result.add(getFivesCollectibleValue());
        result = result.add(getOnesCollectibleValue());

        result = result.add(checkAgeValue());

        return result;
    }

    public BigDecimal getCollectibleValue(Collection<? extends ICurrency> c)
    {
        BigDecimal result = new BigDecimal("0.00");

        for(ICurrency currency : c)
        {
            result = result.add(currency.getCollectibleValue());
        }

        return result;
    }

    public BigDecimal getFaceValue()
    {
        BigDecimal result = getQuartersFaceValue();
        result = result.add(getDimesFaceValue());
        result = result.add(getNickelsFaceValue());
        result = result.add(getPenniesFaceValue());
        result = result.add(getHundredsFaceValue());
        result = result.add(getTwentiesFaceValue());
        result = result.add(getTensFaceValue());
        result = result.add(getFivesFaceValue());
        result = result.add(getOnesFaceValue());

        return result;
    }

    public BigDecimal getFaceValue(Collection<? extends ICurrency> c)
    {
        BigDecimal result = new BigDecimal("0.00");

        for(ICurrency currency : c)
        {
            result = result.add(currency.getFaceValue());
        }

        return result;
    }

    public boolean isInCollection(int serialNumber)
    {
        boolean result = false;

        for(Hundred i : hundredsList)
        {
            if(i.getSerialNumber() == serialNumber)
            {
                result = true;
            }
        }

        for(Twenty i : twentiesList)
        {
            if(i.getSerialNumber() == serialNumber)
            {
                result = true;
            }
        }

        for(Ten i : tensList)
        {
            if(i.getSerialNumber() == serialNumber)
            {
                result = true;
            }
        }

        for(Five i : fivesList)
        {
            if(i.getSerialNumber() == serialNumber)
            {
                result = true;
            }
        }

        for(One i : onesList)
        {
            if(i.getSerialNumber() == serialNumber)
            {
                result = true;
            }
        }

        return result;
    }

    public BigDecimal getHundredsCollectibleValue()
    {
        return getCollectibleValue(hundredsList);
    }

    public BigDecimal getTwentiesCollectibleValue()
    {
        return getCollectibleValue(twentiesList);
    }

    public BigDecimal getTensCollectibleValue()
    {
        return getCollectibleValue(tensList);
    }

    public BigDecimal getFivesCollectibleValue()
    {
        return getCollectibleValue(fivesList);
    }

    public BigDecimal getOnesCollectibleValue()
    {
        return getCollectibleValue(onesList);
    }

    public BigDecimal getQuartersCollectibleValue()
    {
        return getCollectibleValue(quarterList);
    }

    public BigDecimal getDimesCollectibleValue()
    {
        return getCollectibleValue(dimeList);
    }

    public BigDecimal getNickelsCollectibleValue()
    {
        return getCollectibleValue(nickelList);
    }

    public BigDecimal getPenniesCollectibleValue()
    {
        return getCollectibleValue(pennyList);
    }

    public BigDecimal getHundredsFaceValue()
    {
        return getFaceValue(hundredsList);
    }

    public BigDecimal getTwentiesFaceValue()
    {
        return getFaceValue(twentiesList);
    }

    public BigDecimal getTensFaceValue()
    {
        return getFaceValue(tensList);
    }

    public BigDecimal getFivesFaceValue()
    {
        return getFaceValue(fivesList);
    }

    public BigDecimal getOnesFaceValue()
    {
        return getFaceValue(onesList);
    }

    public BigDecimal getQuartersFaceValue()
    {
        return getFaceValue(quarterList);
    }

    public BigDecimal getDimesFaceValue()
    {
        return getFaceValue(dimeList);
    }

    public BigDecimal getNickelsFaceValue()
    {
        return getFaceValue(nickelList);
    }

    public BigDecimal getPenniesFaceValue()
    {
        return getFaceValue(pennyList);
    }

    public void addQuarter(int year)
    {
        quarterList.add(new Quarter(year));
    }

    public void addDime(int year)
    {
        dimeList.add(new Dime(year));
    }

    public void addNickel(int year)
    {
        nickelList.add(new Nickel(year));
    }

    public void addPenny(int year)
    {
        pennyList.add(new Penny(year));
    }

    public void addHundred(int serialNumber, int year)
    {
        try
        {
            if (isInCollection(serialNumber))
            {
                throw new Exception("Bill already in collection.");
            }
            hundredsList.add(new Hundred(serialNumber,year));
        }catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void addTwenty(int serialNumber, int year)
    {
        try
        {
            if (isInCollection(serialNumber))
            {
                throw new Exception("Bill already in collection.");
            }
            twentiesList.add(new Twenty(serialNumber,year));
        }catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void addTen(int serialNumber, int year)
    {
        try
        {
            if (isInCollection(serialNumber))
            {
                throw new Exception("Bill already in collection.");
            }
            tensList.add(new Ten(serialNumber,year));
        }catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void addFive(int serialNumber, int year)
    {
        try
        {
            if (isInCollection(serialNumber))
            {
                throw new Exception("Bill already in collection.");
            }
            fivesList.add(new Five(serialNumber,year));
        }catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void addOne(int serialNumber, int year)
    {
        try
        {
            if (isInCollection(serialNumber))
            {
                throw new Exception("Bill already in collection.");
            }
            onesList.add(new One(serialNumber,year));
        }catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
