package com.example.shoppingcart.models;

/**
 * The Entry class is using for define product information in cart.
 */
public class Entry {
    private int quantity;
    private Product product;

    public Entry(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
