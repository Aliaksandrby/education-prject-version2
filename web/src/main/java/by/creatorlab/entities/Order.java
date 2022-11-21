package by.creatorlab.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long carId;
}
