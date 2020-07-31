package com.example.shoppingcart.services.discount;

import com.example.shoppingcart.models.Coupon;

public class CouponService implements ICouponService {

    @Override
    public double couponDiscount(double amount, Coupon coupon) {
        if(amount >= coupon.getQuantity()) {
            switch (coupon.getDiscountType()) {
                case Rate:
                    return amount * (coupon.getAmount() / 100);
                case Amount:
                    return coupon.getAmount();
            }
        }
        return 0;
    }
}
