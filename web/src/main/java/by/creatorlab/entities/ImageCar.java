package by.creatorlab.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "t_image_car")
public class ImageCar {

    private final String NAME_SEQ = "image_car_seq";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME_SEQ)
    @SequenceGenerator(name = NAME_SEQ, allocationSize = 1)
    private Long id;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "path_to_image")
    private String pathToImage;
}
