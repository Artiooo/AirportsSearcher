package com.Test;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.lang.Class;


public class AirportParser
{
    private  static final String path = "/files/airports.csv";
    private AirportParser(){}

    public static Airport readFromConsole() throws IOException, NumberFormatException
    {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(isr))
        {
            System.out.println("Введите широту: ");
            double latitude = Double.parseDouble(bf.readLine());
            System.out.println("Введите долготу: ");
            double longitude = Double.parseDouble(bf.readLine());
            return new Airport("Searchable", latitude, longitude);
        }catch(IOException e)
        {
            throw new IOException("Ошибка ввода/вывода");
        }catch(NumberFormatException e)
        {
            throw new NumberFormatException("Неправильный формат вводимых данных: введите число");
        }
    }

    public static HashSet<String> readFromCSV() throws FileNotFoundException, NullPointerException, IOException
    {
        LocalTime lt1  = LocalTime.now();
        HashSet<String> information = new HashSet<>();

        try(InputStream input = AirportParser.class.getResourceAsStream(path);
            InputStreamReader isr = new InputStreamReader(input, "UTF-8");
            BufferedReader bf = new BufferedReader(isr);)
        {
            while(bf.ready())
            {
                information.add(bf.readLine());
            }
            LocalTime lt2  = LocalTime.now();
            Duration dur = Duration.between(lt1,lt2);
            System.out.println("Время выполнения: readFromCSV: " + dur.toMillis());
        }
        catch(FileNotFoundException e)
        {
            throw new FileNotFoundException("Файл не найден");
        }
        catch(NullPointerException e)
        {
            throw new NullPointerException("Файл пуст");
        }
        catch(IOException e)
        {
            throw new IOException("Ошибка при чтении файла");
        }
        return information;
    }
    public static TreeSet<Airport> parseAirports(HashSet<String> CSVLines)
    {
        LocalTime lt1  = LocalTime.now();


        TreeSet<Airport> ts = new TreeSet<>();

        for(String element : CSVLines)
        {
            String[] splited = element.split(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
            StringBuilder sb = new StringBuilder(splited[1]);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            splited[1] = sb.toString();
            ts.add(new Airport(splited[1], Double.parseDouble(splited[6]), Double.parseDouble(splited[7])));
        }



        LocalTime lt2  = LocalTime.now();
        Duration dur = Duration.between(lt1,lt2);
        System.out.println("Время выполнения: parseAirports: " + dur.toMillis());

        return ts;
    }




}
