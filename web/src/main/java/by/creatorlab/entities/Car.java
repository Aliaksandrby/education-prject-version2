package by.creatorlab.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "t_car_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "engine_description")
    private String engineDescription;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "price")
    private int price;


    @OneToMany(fetch = FetchType.EAGER,
              mappedBy = "car",
              cascade = CascadeType.ALL)
    private List<ImageCar> imageList;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", engineDescription='" + engineDescription + '\'' +
                ", transmission='" + transmission + '\'' +
                ", price=" + price +
                ", imageList=" + imageList +
                '}';
    }
}
