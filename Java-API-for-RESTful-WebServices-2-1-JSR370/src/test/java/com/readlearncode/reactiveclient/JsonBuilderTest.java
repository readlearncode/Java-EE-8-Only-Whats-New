package com.readlearncode.reactiveclient;

import com.readlearncode.reactiveclient.resource.Location;
import com.readlearncode.reactiveclient.resource.Weather;
import org.junit.Test;

import javax.json.bind.JsonbBuilder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonBuilderTest {

    @Test
    public void buildLocationJson(){

        String json = "[{\"title\":\"London\",\"location_type\":\"City\",\"woeid\":44418,\"latt_long\":\"51.506321,-0.12714\"}]";

        Location[] location = JsonbBuilder.create().fromJson(json, Location[].class);

        System.out.println(location[0].getTitle());
    }

    @Test
    public void buildWeatherJson(){

        String json = "{\"consolidated_weather\":[{\"id\":5670647220928512,\"weather_state_name\":\"Light Cloud\",\"weather_state_abbr\":\"lc\",\"wind_direction_compass\":\"SSW\",\"created\":\"2018-02-17T14:33:02.870410Z\",\"applicable_date\":\"2018-02-17\",\"min_temp\":1.895,\"max_temp\":10.676,\"the_temp\":10.545,\"wind_speed\":4.016804646820966,\"wind_direction\":212.67580341939492,\"air_pressure\":1025.655,\"humidity\":67,\"visibility\":7.7596834486598265,\"predictability\":70},{\"id\":5986953308667904,\"weather_state_name\":\"Showers\",\"weather_state_abbr\":\"s\",\"wind_direction_compass\":\"SSW\",\"created\":\"2018-02-17T14:33:02.274410Z\",\"applicable_date\":\"2018-02-18\",\"min_temp\":4.25,\"max_temp\":9.996,\"the_temp\":8.305,\"wind_speed\":6.5249224027360215,\"wind_direction\":199.40061821651307,\"air_pressure\":1026.99,\"humidity\":77,\"visibility\":9.099670424719637,\"predictability\":73},{\"id\":4961256062582784,\"weather_state_name\":\"Light Rain\",\"weather_state_abbr\":\"lr\",\"wind_direction_compass\":\"W\",\"created\":\"2018-02-17T14:33:02.505860Z\",\"applicable_date\":\"2018-02-19\",\"min_temp\":6.273999999999999,\"max_temp\":10.346,\"the_temp\":9.605,\"wind_speed\":5.365025629704923,\"wind_direction\":273.1710030810815,\"air_pressure\":1019.1949999999999,\"humidity\":92,\"visibility\":5.012290722182454,\"predictability\":75},{\"id\":5481336336809984,\"weather_state_name\":\"Heavy Cloud\",\"weather_state_abbr\":\"hc\",\"wind_direction_compass\":\"NNE\",\"created\":\"2018-02-17T14:33:03.468300Z\",\"applicable_date\":\"2018-02-20\",\"min_temp\":3.436,\"max_temp\":7.56,\"the_temp\":6.38,\"wind_speed\":9.777810675102204,\"wind_direction\":24.937545031740395,\"air_pressure\":1024.75,\"humidity\":81,\"visibility\":12.695856199793209,\"predictability\":71},{\"id\":4620640191512576,\"weather_state_name\":\"Showers\",\"weather_state_abbr\":\"s\",\"wind_direction_compass\":\"NNE\",\"created\":\"2018-02-17T14:33:03.875030Z\",\"applicable_date\":\"2018-02-21\",\"min_temp\":2.146,\"max_temp\":6.713999999999999,\"the_temp\":6.24,\"wind_speed\":8.297900101627297,\"wind_direction\":26.81999091747248,\"air_pressure\":1028.005,\"humidity\":67,\"visibility\":14.798265628728227,\"predictability\":73},{\"id\":6018442935140352,\"weather_state_name\":\"Showers\",\"weather_state_abbr\":\"s\",\"wind_direction_compass\":\"ENE\",\"created\":\"2018-02-17T14:33:05.105240Z\",\"applicable_date\":\"2018-02-22\",\"min_temp\":1.4425000000000001,\"max_temp\":6.572,\"the_temp\":6.62,\"wind_speed\":8.29136811023622,\"wind_direction\":68.86823280971304,\"air_pressure\":1021.11,\"humidity\":69,\"visibility\":9.997862483098704,\"predictability\":73}],\"time\":\"2018-02-17T15:43:08.497040Z\",\"sun_rise\":\"2018-02-17T07:10:42.308549Z\",\"sun_set\":\"2018-02-17T17:19:05.337088Z\",\"timezone_name\":\"LMT\",\"parent\":{\"title\":\"England\",\"location_type\":\"Region / State / Province\",\"woeid\":24554868,\"latt_long\":\"52.883560,-1.974060\"},\"sources\":[{\"title\":\"BBC\",\"slug\":\"bbc\",\"url\":\"http://www.bbc.co.uk/weather/\",\"crawl_rate\":180},{\"title\":\"Forecast.io\",\"slug\":\"forecast-io\",\"url\":\"http://forecast.io/\",\"crawl_rate\":480},{\"title\":\"HAMweather\",\"slug\":\"hamweather\",\"url\":\"http://www.hamweather.com/\",\"crawl_rate\":360},{\"title\":\"Met Office\",\"slug\":\"met-office\",\"url\":\"http://www.metoffice.gov.uk/\",\"crawl_rate\":180},{\"title\":\"OpenWeatherMap\",\"slug\":\"openweathermap\",\"url\":\"http://openweathermap.org/\",\"crawl_rate\":360},{\"title\":\"Weather Underground\",\"slug\":\"wunderground\",\"url\":\"https://www.wunderground.com/?apiref=fc30dc3cd224e19b\",\"crawl_rate\":720},{\"title\":\"World Weather Online\",\"slug\":\"world-weather-online\",\"url\":\"http://www.worldweatheronline.com/\",\"crawl_rate\":360},{\"title\":\"Yahoo\",\"slug\":\"yahoo\",\"url\":\"http://weather.yahoo.com/\",\"crawl_rate\":180}],\"title\":\"London\",\"location_type\":\"City\",\"woeid\":44418,\"latt_long\":\"51.506321,-0.12714\",\"timezone\":\"Europe/London\"}";

        Weather weather = JsonbBuilder.create().fromJson(json, Weather.class);

        System.out.println(weather);
    }
}