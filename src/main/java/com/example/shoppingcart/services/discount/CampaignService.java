package com.example.shoppingcart.services.discount;

import com.example.shoppingcart.models.Campaign;
import com.example.shoppingcart.models.Entry;
import com.example.shoppingcart.services.entry.IEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CampaignService implements ICampaignService {

    @Autowired
    IEntryService entryService;

    @Override
    public double campaignDiscount(List<Campaign> campaigns) {
        Map<String, Double> discounts = new HashMap<>();
        for (Campaign campaign : campaigns){
            List<Entry> entries = entryService.entryListByCategory(campaign.getCategory());
            int productCount = entries.stream().mapToInt(o -> o.getQuantity()).sum();
            double currentDiscount;
            if(productCount >= campaign.getQuantity()) { // check campaign is applicable
                switch (campaign.getDiscountType()) {
                    case Rate:
                        double total = entries.stream().mapToDouble(o -> o.getProduct().getPrice()).sum();
                        double discount = total * (campaign.getAmount() / 100);
                        currentDiscount = discounts.getOrDefault(campaign.getCategory().getTitle(), 0.0);
                        if(discount > currentDiscount){ //select greatest campaign for selected category
                            discounts.put(campaign.getCategory().getTitle(), discount);
                        }
                        break;
                    case Amount:
                        currentDiscount = discounts.getOrDefault(campaign.getCategory().getTitle(), 0.0);
                        if(campaign.getAmount() > currentDiscount){ //select greatest campaign for selected category
                            discounts.put(campaign.getCategory().getTitle(), campaign.getAmount());
                        }
                        break;
                }
            }
        }
        return discounts.values().stream().reduce(0.0, Double::sum);
    }
}
