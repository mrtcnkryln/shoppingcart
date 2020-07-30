package com.example.shoppingcart.models;

import java.util.List;

/**
 * The Cart class is using for define active cart.
 */
public class Cart {
    private List<Entry> entries;

    public Cart(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
