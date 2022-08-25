package com.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args) {
        try {
            Airport.initializeSearchable();
            HashSet<String> CSVLines = AirportParser.readFromCSV();
            LocalTime lt1 = LocalTime.now();
            TreeSet<Airport> airports = AirportParser.parseAirports(CSVLines);
            Iterator<Airport> it = airports.tailSet(Airport.getSearchable()).iterator();
            for(int i = 0; i < 5; i++)
            {
                if(!it.hasNext())
                    break;
                else
                {
                    System.out.println(it.next().toString());
                }
            }
            LocalTime lt2 = LocalTime.now();
            Duration duration = Duration.between(lt1, lt2);
            System.out.println("Затраченное время: " + duration.toMillis());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }
}
