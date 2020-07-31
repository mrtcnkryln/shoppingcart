package com.example.shoppingcart.modules;

import com.example.shoppingcart.models.Cart;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class CartManager {
    private static final CartManager instance = new CartManager();

    private Cart cart;

    private CartManager() {}

    public static CartManager getInstance() {
        return instance;
    }

    public boolean isSet() {
        return  cart != null;
    }

    public void setCart (final @NonNull Cart cart){
        this.cart = cart;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void clear() {
        this.cart = null;
    }
}
