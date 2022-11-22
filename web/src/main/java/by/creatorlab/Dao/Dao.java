package by.creatorlab.Dao;

import by.creatorlab.entities.Car;

import java.util.List;

public interface Dao {
    void create(Car car);
    List<Car> readAll();
    void update(Car car);
    void delete(Car car);

    Car findById(int id);
}
