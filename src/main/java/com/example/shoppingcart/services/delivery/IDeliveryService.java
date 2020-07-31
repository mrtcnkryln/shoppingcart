package com.example.shoppingcart.services.delivery;

public interface IDeliveryService {

    /**
     * calculate delivery cost.
     *
     * @return   amount
     */
    double calculateFor(double costPerDelivery, double costByProduct);
}
