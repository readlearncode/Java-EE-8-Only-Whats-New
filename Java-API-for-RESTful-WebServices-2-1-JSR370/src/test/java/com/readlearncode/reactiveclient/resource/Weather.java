package com.readlearncode.reactiveclient.resource;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@XmlRootElement
public class Weather {

    private ConsolidatedWeather[] consolidated_weather;
    private String time;
    private String sun_rise;
    private String sun_set;
    private String timezone_name;
    private Parent parent;
    private Source[] sources;
    private String title;
    private String location_type;
    private Integer woeid;
    private String latt_long;
    private String timezone;

    public Weather() {
    }

    public Weather(String title, double maxTemp) {
        this.title = title;
        consolidated_weather = new ConsolidatedWeather[10];
        consolidated_weather[0] = new ConsolidatedWeather(maxTemp);
    }

    public ConsolidatedWeather[] getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setConsolidated_weather(ConsolidatedWeather[] consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSun_rise() {
        return sun_rise;
    }

    public void setSun_rise(String sun_rise) {
        this.sun_rise = sun_rise;
    }

    public String getSun_set() {
        return sun_set;
    }

    public void setSun_set(String sun_set) {
        this.sun_set = sun_set;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public Integer getWoeid() {
        return woeid;
    }

    public void setWoeid(Integer woeid) {
        this.woeid = woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "consolidated_weather=" + Arrays.toString(consolidated_weather) +
                ", time='" + time + '\'' +
                ", sun_rise='" + sun_rise + '\'' +
                ", sun_set='" + sun_set + '\'' +
                ", timezone_name='" + timezone_name + '\'' +
                ", parent=" + parent +
                ", sources=" + Arrays.toString(sources) +
                ", title='" + title + '\'' +
                ", location_type='" + location_type + '\'' +
                ", woeid=" + woeid +
                ", latt_long='" + latt_long + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
