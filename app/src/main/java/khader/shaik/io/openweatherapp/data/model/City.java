/*
 *  Copyright (c) $year. Philips India Ltd.
 *  All rights reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright holder.
 *
 */

package khader.shaik.io.openweatherapp.data.model;

/**
 *  Project           : OpenWeatherDemo
 *  File Name         : City
 *  Description       :
 *  Revision History  : version 1
 *  Date              : 1/5/19
 *  Original author   : Shaik Khader Basha
 *  Description       : Initial version
 *  
 */
public class City
{
    private Coord coord;

    private String id;

    private String name;

    private String population;

    private String country;

    public Coord getCoord ()
    {
        return coord;
    }

    public void setCoord (Coord coord)
    {
        this.coord = coord;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [coord = "+coord+", id = "+id+", name = "+name+", population = "+population+", country = "+country+"]";
    }
}

