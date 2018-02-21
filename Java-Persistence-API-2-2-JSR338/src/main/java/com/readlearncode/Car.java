package com.readlearncode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Basic
    private LocalDate releaseDate;

    @Basic
    private LocalDateTime manufactureDate;

    @Basic
    private String type;

    @Basic
    private Float price;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDateTime manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(releaseDate, car.releaseDate) &&
                Objects.equals(manufactureDate, car.manufactureDate) &&
                Objects.equals(type, car.type) &&
                Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, releaseDate, manufactureDate, type, price);
    }
}