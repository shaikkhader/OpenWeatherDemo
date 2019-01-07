/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.model;

/**
 *  Project           : OpenWeatherDemo
 *  File Name         : Wind
 *  Description       :
 *  Revision History  : version 1
 *  Date              : 1/5/19
 *  Original author   : Shaik Khader Basha
 *  Description       : Initial version
 *  
 */
public class Wind
{
    private String speed;

    private String deg;

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }

    public String getDeg ()
    {
        return deg;
    }

    public void setDeg (String deg)
    {
        this.deg = deg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [speed = "+speed+", deg = "+deg+"]";
    }
}
