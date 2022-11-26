package by.creatorlab.Dao;

import by.creatorlab.entities.ImageCar;

import java.util.List;

public interface ImageDao {
    void create(ImageCar imageCar);
    void delete(ImageCar imageCar);
    void update(ImageCar imageCar);
}
