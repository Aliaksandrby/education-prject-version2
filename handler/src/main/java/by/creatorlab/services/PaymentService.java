package by.creatorlab.services;

import by.creatorlab.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private final List<Payment> paymentList;

    public PaymentService(){
        paymentList = new ArrayList<>();

        paymentList.add(new Payment(1,"first"));
        paymentList.add(new Payment(2,"second"));
        paymentList.add(new Payment(3,"third"));
        paymentList.add(new Payment(4,"fourth"));
        paymentList.add(new Payment(5,"fifth"));
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }
}
