package com.example.listycity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCityExact() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        cityList.deleteCity(mockCity());
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
        assertEquals("City does not exist in the list.", thrown.getMessage());

        assertEquals(1, cityList.getCities().size());
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testCount() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        cityList.deleteCity(city);
        assertEquals(1, cityList.countCities());
    }
 }