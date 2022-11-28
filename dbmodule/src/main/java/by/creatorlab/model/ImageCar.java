package by.creatorlab.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn (name="car_id")
    private Car car;

    @Lob
    @Column(name = "image",columnDefinition = "MEDIUMBLOB")
    private String image;

    /*@Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", car=" + car.getId() +
                ", pathImage='" + getImage() + '\'' +
                '}';
    }*/
}

