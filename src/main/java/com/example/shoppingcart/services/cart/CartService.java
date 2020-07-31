package com.example.shoppingcart.services.cart;

import com.example.shoppingcart.models.Cart;
import com.example.shoppingcart.models.Entry;
import com.example.shoppingcart.modules.CartManager;
import com.example.shoppingcart.services.delivery.IDeliveryService;
import com.example.shoppingcart.services.discount.ICampaignService;
import com.example.shoppingcart.services.discount.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CartService implements ICartService {

    private Cart cart;

    @Autowired
    ICouponService couponService;

    @Autowired
    ICampaignService campaignService;

    @Autowired
    IDeliveryService deliveryService;

    @Override
    public void loadCart() {
        this.cart = CartManager.getInstance().getCart();
    }

    @Override
    public Cart getCart() {
        return CartManager.getInstance().getCart();
    }

    @Override
    public List<Entry> getCartEntries() {
        return null == this.cart ? null : this.cart.getEntries();
    }

    @Override
    public double getTotalAmount() {
        if (null != this.cart){
            this.cart.getEntries().stream().mapToDouble(o -> o.getProduct().getPrice()).sum();
        }
        return 0;
    }

    @Override
    public double getTotalAmountAfterDiscounts() {
        if (null != this.cart){
            return getTotalAmount() - (getCampaignDiscount() + getCouponDiscount());
        }
        return 0;
    }

    @Override
    public double getCouponDiscount() {
        if (null != this.cart){
            double totalAfterCampaignDiscount = getTotalAmount() - getCampaignDiscount();
            couponService.couponDiscount(totalAfterCampaignDiscount, this.cart.getCoupon());
        }
        return 0;
    }

    @Override
    public double getCampaignDiscount() {
        if (null != this.cart){
            campaignService.campaignDiscount(this.cart.getCampaigns());
        }
        return 0;
    }

    @Override
    public double getDeliveryCost() {
        return deliveryService.calculateFor();
    }

    @Override
    public int numberOfDeliveries() {
        if (null != this.cart){
            return this.cart.getEntries().stream().collect(Collectors.groupingBy(o -> o.getProduct().getCategory().getTitle())).size();

        }
        return 0;
    }

    @Override
    public int numberOfProducts() {
        return null == this.cart ? 0 : this.cart.getEntries().size();
    }
}
