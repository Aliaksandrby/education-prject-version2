package by.creatorlab.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_car")
public class Car {

    private final String NAME_SEQ = "car_seq";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME_SEQ)
    @SequenceGenerator(name = NAME_SEQ, allocationSize = 1)
    private Long id;

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

    @Column(name = "path_to_image")
    private List<String> pathToImageList;



}
