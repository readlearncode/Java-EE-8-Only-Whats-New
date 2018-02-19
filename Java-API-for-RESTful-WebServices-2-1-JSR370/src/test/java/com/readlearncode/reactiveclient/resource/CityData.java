package com.readlearncode.reactiveclient.resource;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CityData {

    private Location location;
    private Weather weather;

    public CityData(Location location) {
    this.location = location;
    }

    public static CityData weather(CityData cityData, Weather weather) {
        cityData.setWeather(weather);
        return cityData;
    }

    public Weather setWeather(Weather weather){
        this.weather = weather;
        return weather;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Weather getWeather() {
        return weather;
    }



    @Override
    public String toString() {
        return "CityData{" +
                "location=" + location +
                ", weather=" + weather +
                '}';
    }
}