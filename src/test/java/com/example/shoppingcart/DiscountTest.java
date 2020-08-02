package com.example.shoppingcart;

import com.example.shoppingcart.models.*;
import com.example.shoppingcart.modules.CartManager;
import com.example.shoppingcart.services.discount.ICampaignService;
import com.example.shoppingcart.services.discount.ICouponService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DiscountTest extends AbstractTestClass {

    @Autowired
    ICampaignService campaignService;

    @Autowired
    ICouponService couponService;


    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void campaignServiceEmptyCartReturnZero(){
        Category shoes = new Category("shoes");
        Campaign campaign = new Campaign(shoes,20, 3, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        double result = campaignService.campaignDiscount(cart.getCampaigns());
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void campaignServiceEmptyCampaignsReturnZero(){
        Category shoes = new Category("shoes");
        Product nike = new Product("nike air max", 500, shoes);
        Entry entry = new Entry(2, nike);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        CartManager.getInstance().getCart().setEntries(entries);
        double result = campaignService.campaignDiscount(cart.getCampaigns());
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void campaignServiceCampaignsNotApplyBecauseOfQuantity(){
        Category shoes = new Category("shoes");
        Product nike = new Product("nike air max", 500, shoes);
        Entry entry = new Entry(2, nike);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        Campaign campaign = new Campaign(shoes,20, 3, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        double result = campaignService.campaignDiscount(campaigns);
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void campaignServiceApplyJustSelectedCategoryCampaign(){
        Category shoes = new Category("shoes");
        Product nike = new Product("nike air max", 500, shoes);
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryNike = new Entry(2, nike);
        Entry entryCanon = new Entry(1, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryNike);
        entries.add(entryCanon);
        Campaign campaign = new Campaign(shoes,100, 2, DiscountType.Amount);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        double result = campaignService.campaignDiscount(campaigns);
        assertEquals(0, Double.compare(result, 100));
    }

    @Test
    public void campaignServiceApplyParentCategoryCampaign(){
        Category electronic = new Category("electronic");
        Category camera = new Category("camera", electronic);
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        Campaign campaign = new Campaign(electronic,10, 2, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        double result = campaignService.campaignDiscount(campaigns);
        assertEquals(0, Double.compare(result, 400));
    }

    @Test
    public void campaignServiceJustGreatestCampaignsApply(){
        Category shoes = new Category("shoes");
        Product nike = new Product("nike air max", 500, shoes);
        Entry entry = new Entry(2, nike);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        Campaign campaignFirst = new Campaign(shoes,20, 2, DiscountType.Rate);
        Campaign campaignSecond = new Campaign(shoes,100, 2, DiscountType.Amount);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaignFirst);
        campaigns.add(campaignSecond);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        double result = campaignService.campaignDiscount(campaigns);
        assertEquals(0, Double.compare(result, 200));
    }

    @Test
    public void couponServiceEmptyCartReturnZero(){
        Coupon coupon = new Coupon(100,  1000, DiscountType.Amount);
        CartManager.getInstance().getCart().setCoupon(coupon);
        double result = couponService.couponDiscount(0, coupon);
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void couponServiceEmptyCouponReturnZero(){
        double result = couponService.couponDiscount(1000, null);
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void couponServiceReturnZeroBecauseOfMinAmount(){
        Coupon coupon = new Coupon(100,  1000, DiscountType.Amount);
        CartManager.getInstance().getCart().setCoupon(coupon);
        double result = couponService.couponDiscount(900, coupon);
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void couponServiceAppliedForAmount(){
        Coupon coupon = new Coupon(100,  1000, DiscountType.Amount);
        CartManager.getInstance().getCart().setCoupon(coupon);
        double result = couponService.couponDiscount(1800, coupon);
        assertEquals(0, Double.compare(result, 100));
    }

}
