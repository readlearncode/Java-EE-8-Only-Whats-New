package com.readlearncode.reactiveclient.resource;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Parent {

    private String title;
    private String location_type;
    private Integer woeid;
    private String latt_long;

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

    @Override
    public String toString() {
        return "Parent{" +
                "title='" + title + '\'' +
                ", location_type='" + location_type + '\'' +
                ", woeid=" + woeid +
                ", latt_long='" + latt_long + '\'' +
                '}';
    }
}