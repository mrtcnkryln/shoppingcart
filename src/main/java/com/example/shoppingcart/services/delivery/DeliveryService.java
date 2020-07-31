package com.example.shoppingcart.services.delivery;

import com.example.shoppingcart.services.cart.ICartService;
import com.example.shoppingcart.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryService implements IDeliveryService {

    @Autowired
    ICartService cartService;

    @Override
    public double calculateFor(double costPerDelivery, double costByProduct) {
        cartService.loadCart();
        int numberOfDeliveries = cartService.numberOfDeliveries();
        int numberOfProducts = cartService.numberOfProducts();
        return (costPerDelivery * numberOfDeliveries) + (costByProduct * numberOfProducts) + AppConstants.FIXED_COST;
    }
}
