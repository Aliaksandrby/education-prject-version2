package by.creatorlab.services.admin.cars;

import by.creatorlab.dao.CarDao;
import by.creatorlab.dao.ImageDao;
import by.creatorlab.model.Car;
import by.creatorlab.model.ImageCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private ImageDao imageDao;

    @Override
    @Transactional
    public Car addCar(Car car, MultipartFile[] images) throws IOException {
        carDao.create(car);
        for (MultipartFile image : images) {
            ImageCar imageCar = new ImageCar();
            imageCar.setCar(car);
            imageCar.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            imageDao.create(imageCar);
        }
        return carDao.findById(car.getId());
    }

    @Override
    @Transactional
    public void deleteCar(int id) {
        Car car = carDao.findById(id);
        carDao.delete(car);
    }

    @Override
    @Transactional
    public Car editCar(Car car, int id, MultipartFile[] images) throws IOException { // don't work correctly
        car = carDao.findById(id);
        carDao.update(car);
        //TODO: if images = {} don't delete else delete images
        for (ImageCar imageCar : car.getImageList()) imageDao.delete(imageCar);

        for (MultipartFile image : images) {
            ImageCar imageCar = new ImageCar();
            imageCar.setCar(car);
            imageCar.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            imageDao.create(imageCar);
        }
        return carDao.findById(id);
    }

    public void changeImages(Car car, MultipartFile[] images) throws IOException {
        for (MultipartFile image : images) {
            ImageCar imageCar = new ImageCar();
            imageCar.setCar(car);
            imageCar.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            imageDao.create(imageCar);
        }
    }
}
