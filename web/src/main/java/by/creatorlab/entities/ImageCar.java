package by.creatorlab.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_image_car")
public class ImageCar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_car_seq")
    @SequenceGenerator(name = "image_car_seq", sequenceName = "t_image_car_seq",allocationSize = 1)
    private Integer id;

    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JoinColumn (name="car_id")
    private Car car;

    @Column(name = "path_image")
    private String pathImage;

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", car=" + car.getId() +
                ", pathImage='" + getPathImage() + '\'' +
                '}';
    }
}

