package com.example.shoppingcart;

import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.models.Entry;
import com.example.shoppingcart.models.Product;
import com.example.shoppingcart.modules.CartManager;
import com.example.shoppingcart.services.delivery.IDeliveryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeliveryTest extends AbstractTestClass {

    @Autowired
    IDeliveryService deliveryService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void deliveryServiceCalculateForReturnJustConstantValueInEmptyCart(){
        double result = deliveryService.calculateFor();
        assertEquals(0, Double.compare(result, 2.99));
    }

    @Test
    public void deliveryServiceCalculateForReturnValid() {
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
        double result = deliveryService.calculateFor();
        assertEquals(0, Double.compare(result, 10.99));

    }
}
