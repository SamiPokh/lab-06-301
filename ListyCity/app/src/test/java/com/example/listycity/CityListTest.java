package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for CityList
 */
class CityListTest {

    /**
     * Creates a mock CityList with one city
     * @return A CityList with one city
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City
     * @return A City object (Edmonton, Alberta)
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Tests the add method
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Tests that adding a duplicate city throws an exception
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Tests the getCities method and sorting
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Tests the hasCity method when city is in the list
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = mockCity();

        assertTrue(cityList.hasCity(city));
    }

    /**
     * Tests the hasCity method when city is not in the list
     */
    @Test
    void testHasCityNotFound() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");

        assertFalse(cityList.hasCity(city));
    }

    /**
     * Tests the delete method successfully removes a city
     */
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = mockCity();

        assertEquals(1, cityList.countCities());
        assertTrue(cityList.hasCity(city));

        cityList.delete(city);

        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Tests that deleting a non-existent city throws an exception
     */
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Tests the countCities method
     */
    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());

        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(2, cityList.countCities());

        cityList.add(new City("Montreal", "Quebec"));
        assertEquals(3, cityList.countCities());
    }
}
