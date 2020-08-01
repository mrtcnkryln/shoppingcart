package com.example.shoppingcart.services.delivery;

import com.example.shoppingcart.services.cart.ICartService;
import com.example.shoppingcart.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    ICartService cartService;

    @Override
    public double calculateFor() {
        cartService.loadCart();
        int numberOfDeliveries = cartService.numberOfDeliveries();
        int numberOfProducts = cartService.numberOfProducts();
        return (AppConstants.COST_PER_DELIVERY * numberOfDeliveries) + (AppConstants.COST_PER_PRODUCT * numberOfProducts) + AppConstants.FIXED_COST;
    }
}
