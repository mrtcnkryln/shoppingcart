package com.example.shoppingcart.services.discount;

import com.example.shoppingcart.models.Coupon;

public interface ICouponService {

    /**
     * Calculate the applied campaign discount for cart.
     *
     * @param  amount    current amount
     * @param  coupon    defined coupon
     * @return           discount price
     */
    double couponDiscount(double amount, Coupon coupon);
}
