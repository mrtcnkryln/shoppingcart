package com.example.shoppingcart.models;

import java.util.List;

/**
 * The Cart class is using for define active cart.
 */
public class Cart {
    private List<Entry> entries;
    private List<Campaign> campaigns;
    private Coupon coupon;

    public Cart(List<Entry> entries, List<Campaign> campaigns, Coupon coupon) {
        this.entries = entries;
        this.campaigns = campaigns;
        this.coupon = coupon;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
