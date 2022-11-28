package by.creatorlab.services;

import by.creatorlab.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private final List<Payment> paymentList;

    public PaymentService(){
        paymentList = new ArrayList<>();

        paymentList.add(new Payment(1L,"first"));
        paymentList.add(new Payment(2L,"second"));
        paymentList.add(new Payment(3L,"third"));
        paymentList.add(new Payment(4L,"fourth"));
        paymentList.add(new Payment(5L,"fifth"));
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }
}
