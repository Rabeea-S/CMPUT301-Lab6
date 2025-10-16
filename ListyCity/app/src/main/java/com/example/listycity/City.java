package com.example.listycity;

/**
 * This is a class that defines a City which requires the city name
 * and province which is stored in each City object. It allows for
 * the retrieval of the city's name and province.
 *
 * @author CMPUT 301 Instructor and TAs
 */
public class City implements Comparable<Object> {
    private String city;
    private String province;

    /**
     * Constructor that creates a City instance.
     * @param city
     * Name of city
     * @param province
     * Name of province the city belongs in
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the city's name
     * @return
     * Returns the city's name
     */
    public String getCityName(){
        return this.city;
    }

    /**
     * Returns the city's province name
     * @return
     * Returns the city's province name
     */
    public String getProvinceName(){
        return this.province;
    }

    /**
     * Compares the provided object with the City object to determine if
     * they are the same name or not.
     * @param o
     * Provide an object that the City can be compared to
     * @return
     * Returns an integer value of the comparison
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Determines if a city object is equal to this instance based on the
     * same city and province names
     * @param o
     * The object being compared to
     * @return
     * Returns a boolean for if they objects match
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city_o = (City) o;
        return city.equals(city_o.getCityName()) && province.equals(city_o.getProvinceName());
    }

    /**
     * Custom hashcode generation of a city object that is made up
     * of the city and province names
     * @return
     * Integer that represents the hashcode of the city object.
     */
    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}
