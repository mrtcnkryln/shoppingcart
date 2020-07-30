package com.example.shoppingcart.models;

/**
 * The Coupon class is using for define base variables of discount types which are campaigns and coupons.
 */
public class Discount {
    private double amount;
    private int quantity;
    private DiscountType discountType;

    public Discount(double amount, int quantity, DiscountType discountType) {
        this.amount = amount;
        this.quantity = quantity;
        this.discountType = discountType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
