package com.example.shoppingcart;

import com.example.shoppingcart.models.*;
import com.example.shoppingcart.modules.CartManager;
import com.example.shoppingcart.services.cart.ICartService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartTest extends AbstractTestClass{

    @Autowired
    ICartService cartService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void cartServiceReturnZeroEmptyCart() {
        super.clean();
        cartService.loadCart();
        double result = cartService.getTotalAmount();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceValidTotalAmount() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        CartManager.getInstance().getCart().setEntries(entries);
        cartService.loadCart();
        double result = cartService.getTotalAmount();
        assertEquals(0, Double.compare(result, 4000));
    }

    @Test
    public void cartServiceCampaignDiscountEmptyCartReturnZero() {
        super.clean();
        double result = cartService.getCampaignDiscount();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceCampaignDiscountEmptyCampaignReturnZero() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        CartManager.getInstance().getCart().setEntries(entries);
        cartService.loadCart();
        double result = cartService.getCampaignDiscount();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceCampaignDiscountReturnValid() {
        super.clean();
        Category shoes = new Category("shoes");
        Product nike = new Product("nike air max", 500, shoes);
        Entry entry = new Entry(2, nike);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        Campaign campaign = new Campaign(shoes,20, 2, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        cartService.loadCart();
        double result = cartService.getCampaignDiscount();
        assertEquals(0, Double.compare(result, 200));
    }

    @Test
    public void cartServiceCouponDiscountEmptyCartReturnZero() {
        super.clean();
        double result = cartService.getCouponDiscount();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceCouponDiscountEmptyCouponReturnZero() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        CartManager.getInstance().getCart().setEntries(entries);
        cartService.loadCart();
        double result = cartService.getCouponDiscount();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceCouponDiscountReturnValidWithoutCampaign() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        Coupon coupon = new Coupon(10, 1000, DiscountType.Rate);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCoupon(coupon);
        cartService.loadCart();
        double result = cartService.getCouponDiscount();
        assertEquals(0, Double.compare(result, 400));
    }

    @Test
    public void cartServiceCouponDiscountReturnZeroBecauseOfCampaignDiscount() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        Campaign campaign = new Campaign(camera,80, 2, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        Coupon coupon = new Coupon(10, 1000, DiscountType.Rate);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        CartManager.getInstance().getCart().setCoupon(coupon);
        cartService.loadCart();
        double result = cartService.getCouponDiscount();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceCouponDiscountReturnValidWithCampaignDiscount() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        Campaign campaign = new Campaign(camera,10, 2, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        Coupon coupon = new Coupon(10, 1000, DiscountType.Rate);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        CartManager.getInstance().getCart().setCoupon(coupon);
        cartService.loadCart();
        double result = cartService.getCouponDiscount();
        assertEquals(0, Double.compare(result, 360));
    }

    @Test
    public void cartServiceTotalAmountAfterDiscountEmptyCartReturnZero() {
        super.clean();
        cartService.loadCart();
        double result = cartService.getTotalAmountAfterDiscounts();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceTotalAmountAfterDiscountReturnValidWithCampaignAndCouponDiscount() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(2, canon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        Campaign campaign = new Campaign(camera,10, 2, DiscountType.Rate);
        List<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign);
        Coupon coupon = new Coupon(10, 1000, DiscountType.Rate);
        CartManager.getInstance().getCart().setEntries(entries);
        CartManager.getInstance().getCart().setCampaigns(campaigns);
        CartManager.getInstance().getCart().setCoupon(coupon);
        cartService.loadCart();
        double result = cartService.getTotalAmountAfterDiscounts();
        assertEquals(0, Double.compare(result, 3240));
    }

    @Test
    public void cartServiceNumberOfDeliveriesEmptyCartReturnZero() {
        super.clean();
        cartService.loadCart();
        double result = cartService.numberOfDeliveries();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceNumberOfDeliveriesReturnValid() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Category shoes = new Category("shoes");
        Product nike = new Product("nike air max", 2000, shoes);
        Entry entryCanon = new Entry(2, canon);
        Entry entryShoes = new Entry(2, nike);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        entries.add(entryShoes);
        CartManager.getInstance().getCart().setEntries(entries);
        cartService.loadCart();
        double result = cartService.numberOfDeliveries();
        assertEquals(0, Double.compare(result, 2));
    }

    @Test
    public void cartServiceNumberOfProductsEmptyCartReturnZero() {
        super.clean();
        cartService.loadCart();
        double result = cartService.numberOfProducts();
        assertEquals(0, Double.compare(result, 0));
    }

    @Test
    public void cartServiceNumberOfProductsReturnValid() {
        super.clean();
        Category camera = new Category("camera");
        Product canon = new Product("canon", 2000, camera);
        Entry entryCanon = new Entry(4, canon);
        Product nikon = new Product("nikon", 1000, camera);
        Entry entryNikon = new Entry(3, nikon);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        entries.add(entryNikon);
        CartManager.getInstance().getCart().setEntries(entries);
        cartService.loadCart();
        double result = cartService.numberOfProducts();
        assertEquals(0, Double.compare(result, 2));
    }

}
