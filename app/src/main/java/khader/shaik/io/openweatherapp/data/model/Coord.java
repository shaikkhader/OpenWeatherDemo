/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.model;

/**
 *  Project           : OpenWeatherDemo
 *  File Name         : Coord
 *  Description       :
 *  Revision History  : version 1
 *  Date              : 1/5/19
 *  Original author   : Shaik Khader Basha
 *  Description       : Initial version
 *  
 */
public class Coord
{
    private String lon;

    private String lat;

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lon = "+lon+", lat = "+lat+"]";
    }
}
