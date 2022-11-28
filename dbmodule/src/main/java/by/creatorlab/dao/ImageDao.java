package by.creatorlab.dao;

import by.creatorlab.model.ImageCar;

public interface ImageDao {
    void create(ImageCar imageCar);
    void delete(ImageCar imageCar);
    void update(ImageCar imageCar);
}
