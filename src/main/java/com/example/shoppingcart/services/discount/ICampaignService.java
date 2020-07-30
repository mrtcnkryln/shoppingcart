package com.example.shoppingcart.services.discount;

import com.example.shoppingcart.models.Campaign;

import java.util.List;

public interface ICampaignService {

    /**
     * Calculate the applied campaign discount for cart.
     *
     * @param  campaigns all defined campaigns
     * @return           discount price
     */
    double campaignDiscount(List<Campaign> campaigns);
}
