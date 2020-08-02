package com.example.shoppingcart;

import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.models.Entry;
import com.example.shoppingcart.models.Product;
import com.example.shoppingcart.modules.CartManager;
import com.example.shoppingcart.services.entry.IEntryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EntryTest extends AbstractTestClass {
    @Autowired
    IEntryService entryService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void entryServiceEntryListEmptyCartReturnEmptyList(){
        Category category = new Category("shoes");
        List<Entry> entries = entryService.entryListByCategory(category);
        assertEquals(0,entries.size());
    }

    @Test
    public void entryServiceEntryListReturnJustSelectedCategoryItems() {
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
        List<Entry> entriesResult = entryService.entryListByCategory(camera);
        assertEquals(1, entriesResult.size());
    }

    @Test
    public void entryServiceEntryListReturnSelectedCategoryItemsWithParentCategory() {
        Category electronic = new Category("electronic");
        Category camera = new Category("camera", electronic);
        Product canon = new Product("canon", 2000, camera);
        Product computer = new Product("computer", 5000, electronic);
        Entry entryCanon = new Entry(2, canon);
        Entry entryComputer = new Entry(1, computer);
        List<Entry> entries = new ArrayList<>();
        entries.add(entryCanon);
        entries.add(entryComputer);
        CartManager.getInstance().getCart().setEntries(entries);
        List<Entry> entriesResult = entryService.entryListByCategory(electronic);
        assertEquals(2, entriesResult.size());
    }
}
