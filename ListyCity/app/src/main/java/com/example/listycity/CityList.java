package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 * It allows for the adding, deletion, and retrieval of cities from the list.
 * It also allows one to count the number of cities in the list along with
 * whether the list contains a city.
 *
 * @author CMPUT 301 Instructor and TAs, Rabeea Shahid
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Determines if a provided city is in the list or not
     * @param city
     * City determined if it is in the list or not
     * @return
     * Returns a boolean of whether the list has the city
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a given city if it is in the list, otherwise throw an exception
     * @param city
     * The city to be deleted from the list
     */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("City does not exist in the list.");
        }
    }

    /**
     * Counts the number of cities that are in the list.
     * @return
     * Returns the count of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }
}