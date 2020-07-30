package com.example.shoppingcart.models;

/**
 * The Coupon class is using for define potential discount for the cart.
 * each coupon discount calculating based on amount and quantity.
 */
public class Coupon extends Discount {

    public Coupon(double amount, int quantity, DiscountType discountType) {
        super(amount, quantity, discountType);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void setAmount(double amount) {
        super.setAmount(amount);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public DiscountType getDiscountType() {
        return super.getDiscountType();
    }

    @Override
    public void setDiscountType(DiscountType discountType) {
        super.setDiscountType(discountType);
    }
}
