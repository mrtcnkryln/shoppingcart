package com.example.shoppingcart.services.cart;

import com.example.shoppingcart.models.Entry;

import java.util.List;

public class CartService implements ICartService {

    @Override
    public List<Entry> getCartEntries() {
        return null;
    }

    @Override
    public double getTotalAmount() {
        return 0;
    }

    @Override
    public double getTotalAmountAfterDiscounts() {
        return 0;
    }

    @Override
    public double getCouponDiscount() {
        return 0;
    }

    @Override
    public double getCampaignDiscount() {
        return 0;
    }

    @Override
    public double getDeliveryCost() {
        return 0;
    }

    @Override
    public int numberOfDeliveries() {
        return 0;
    }

    @Override
    public int numberOfProducts() {
        return 0;
    }
}
