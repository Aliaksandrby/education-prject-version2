package by.creatorlab.dao;

import by.creatorlab.model.Car;

import java.util.List;

public interface Dao {
    void create(Car car);
    List<Car> readAll();
    void update(Car car);
    void delete(Car car);

    Car findById(int id);
}
