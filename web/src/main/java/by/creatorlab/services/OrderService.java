package by.creatorlab.services;

import by.creatorlab.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orderList;

    public OrderService(){
        orderList = new ArrayList<>();

        orderList.add(new Order(1L,1L,1L));
        orderList.add(new Order(2L,2L,2L));
        orderList.add(new Order(3L,3L,3L));
        orderList.add(new Order(4L,4L,4L));
        orderList.add(new Order(5L,5L,5L));
        orderList.add(new Order(6L,6L,6L));
        orderList.add(new Order(7L,7L,7L));
        orderList.add(new Order(8L,8L,8L));


    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
