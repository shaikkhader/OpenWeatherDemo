/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.model;



/**
 *  Project           : OpenWeatherDemo
 *  File Name         : Weather
 *  Description       :
 *  Revision History  : version 1
 *  Date              : 1/5/19
 *  Original author   : Shaik Khader Basha
 *  Description       : Initial version
 *  
 */
public class Weather
{
    private String message;

    private String cnt;

    private String cod;

    private Data[] list;

    private City city;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getCnt ()
    {
        return cnt;
    }

    public void setCnt (String cnt)
    {
        this.cnt = cnt;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public Data[] getData()
    {
        return list;
    }

    public void setData(Data[] data)
    {
        this.list = data;
    }

    public City getCity ()
    {
        return city;
    }

    public void setCity (City city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", cnt = "+cnt+", cod = "+cod+", data = "+ list +", city = "+city+"]";
    }
}
