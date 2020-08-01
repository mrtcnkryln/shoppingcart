package com.example.shoppingcart.services.cart;

import com.example.shoppingcart.models.Cart;
import com.example.shoppingcart.models.Entry;

import java.util.List;

public interface ICartService {

    /**
     * load cart.
     *
     */
    void loadCart();

    /**
     * get cart.
     *
     * @return  current cart
     */
    Cart getCart();

    /**
     * find entries of cart.
     *
     * @return    entry list
     */
    List<Entry> getCartEntries();

    /**
     * total amount.
     *
     * @return   amount
     */
    double getTotalAmount();

    /**
     * total amount after discounts.
     *
     * @return   amount
     */
    double getTotalAmountAfterDiscounts();

    /**
     * coupon discounts.
     *
     * @return   amount
     */
    double getCouponDiscount();

    /**
     * campaign discounts.
     *
     * @return   amount
     */
    double getCampaignDiscount();

    /**
     * delivery cost.
     * @return   amount
     */
    double getDeliveryCost();

    /**
     * number of distinct categories in cart.
     *
     * @return   quantity
     */
    int numberOfDeliveries();

    /**
     * number of different products in cart.
     *
     * @return   quantity
     */
    int numberOfProducts();

    /**
     * display the cart.
     *
     * @return   cart info
     */
    String printCart();
}
