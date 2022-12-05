package by.creatorlab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Integer id;
    private Long userId;
    private Long carId;
}
