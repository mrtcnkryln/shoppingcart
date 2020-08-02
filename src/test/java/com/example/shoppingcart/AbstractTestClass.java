package com.example.shoppingcart;

import com.example.shoppingcart.models.Cart;
import com.example.shoppingcart.modules.CartManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShoppingcartApplication.class)
public abstract class AbstractTestClass {

    Cart cart;

    protected void setUp() {
        cart = new Cart(new ArrayList<>(), new ArrayList<>(), null);
        CartManager.getInstance().setCart(cart);
    }
}
