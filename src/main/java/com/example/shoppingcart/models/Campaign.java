package com.example.shoppingcart.models;

/**
 * The Campaign class is using for define campaigns of each category.
 * each campaing discount calculating based on amount and quantity.
 */
public class Campaign extends Discount {
    private Category category;

    public Campaign(Category category, double amount, int quantity, DiscountType discountType) {
        super(amount, quantity, discountType);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
