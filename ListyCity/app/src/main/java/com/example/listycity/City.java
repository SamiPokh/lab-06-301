package com.example.listycity;

/**
 * This is a class that defines a City.
 * A City consists of a city name and a province name.
 */
public class City implements Comparable<City> {

    private String city;
    private String province;

    /**
     * Constructor for City
     * @param city The name of the city
     * @param province The name of the province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return The name of the city
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name
     * @return The name of the province
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city based on city name
     * @param o The city object to compare to
     * @return 0 if equal, negative if this comes before, positive if this comes after
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Checks if two City objects are equal based on city name and province name
     * @param o The object to compare with
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City otherCity = (City) o;
        return city.equals(otherCity.city) && province.equals(otherCity.province);
    }

    /**
     * Generates a hash code for the City object based on city name and province name
     * @return The hash code
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}