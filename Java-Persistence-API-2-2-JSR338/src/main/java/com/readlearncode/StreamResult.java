package com.readlearncode;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Stream;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class StreamResult {

    @PersistenceContext
    private EntityManager entityManager;

    public void getListOf(){
        Stream<Car> cars = entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultStream();
        cars.map(c -> c.getType() + " priced at  " + c.getPrice()).forEach(System.out::println);
    }

}