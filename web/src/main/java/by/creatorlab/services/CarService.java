package by.creatorlab.services;

import by.creatorlab.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final List<Car> carList;

    public CarService(){
        carList = new ArrayList<>();

        carList.add(new Car(1L,"AUDI A7",2012,"gas/3000","automatic",100,
                List.of("/img/car/1/1.jpg","/img/car/1/2.jpg","/img/car/1/3.jpg","/img/car/1/4.jpg")));
        carList.add(new Car(2L,"BMW 5 GRAN TURISMO",2012,"gas/3500","automatic",120,
                List.of("/img/car/2/1.jpg","/img/car/2/2.jpg","/img/car/2/3.jpg","/img/car/2/4.jpg","/img/car/2/5.jpg","/img/car/2/6.jpg")));
        carList.add(new Car(3L,"BMW X1",2012,"gas/2000","automatic",80,
                List.of("/img/car/3/1.jpg","/img/car/3/2.jpg","/img/car/3/3.jpg","/img/car/3/4.jpg")));
        carList.add(new Car(4L,"CITROEN C4",2012,"gas/1600","automatic",
                60,List.of("/img/car/4/1.jpg","/img/car/4/2.jpg","/img/car/4/3.jpg","/img/car/4/4.jpg")));
        carList.add(new Car(5L,"KIA VENGA",2011,"gas/1600","automatic",50,
                List.of("/img/car/5/1.jpg","/img/car/5/2.jpg","/img/car/5/3.jpg")));
        carList.add(new Car(6L,"MERCEDES BENZ E CLASS W212",2013,"gas/1800","automatic",90,
                List.of("/img/car/6/1.jpg","/img/car/6/2.jpg","/img/car/6/3.jpg","/img/car/6/4.jpg","/img/car/6/5.jpg")));
        carList.add(new Car(7L,"PEJO 308",2010,"gas/1600","automatic",40,
                List.of("/img/car/7/1.jpg","/img/car/7/2.jpg","/img/car/7/3.jpg","/img/car/7/4.jpg","/img/car/7/5.jpg")));
        carList.add(new Car(8L,"PORSHE PANAMERA GTS",2014,"gas/4800","automatic",200,
                List.of("/img/car/8/1.jpg","/img/car/8/2.jpg","/img/car/8/3.jpg","/img/car/8/4.jpg")));
        carList.add(new Car(9L,"SKODA RAPID",2016,"gas/1600","automatic",60,
                List.of("/img/car/9/1.jpg","/img/car/9/2.jpg","/img/car/9/3.jpg","/img/car/9/4.jpg")));
        carList.add(new Car(10L,"VOLKSWAGEN CARAVELLE",2010,"disel/2200","automatic",90,
                List.of("/img/car/10/1.jpg","/img/car/10/2.jpg","/img/car/10/3.jpg","/img/car/10/4.jpg","/img/car/10/5.jpg","/img/car/10/6.jpg","/img/car/10/7.jpg")));
        carList.add(new Car(11L,"VOLKSWAGEN PASSAT CC",2013,"gas/1800","automatic",110,
                List.of("/img/car/11/1.jpg","/img/car/11/2.jpg","/img/car/11/3.jpg","/img/car/11/4.jpg","/img/car/11/5.jpg","/img/car/11/6.jpg")));
        carList.add(new Car(12L,"VOLKSWAGEN POLO",2014,"gas/1600","automatic",50,
                List.of("/img/car/12/1.jpg","/img/car/12/2.jpg","/img/car/12/3.jpg","/img/car/12/4.jpg","/img/car/12/5.jpg","/img/car/12/6.jpg")));
    }

    public List<Car> getCarList() {
        return carList;
    }
}