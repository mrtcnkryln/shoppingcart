package com.example.shoppingcart.services.entry;

import com.example.shoppingcart.models.Cart;
import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.models.Entry;
import com.example.shoppingcart.services.cart.ICartService;
import com.example.shoppingcart.services.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService implements IEntryService {

    @Autowired
    ICartService cartService;

    @Autowired
    ICategoryService categoryService;

    @Override
    public List<Entry> entryListByCategory(Category category) {
        Cart cart = cartService.getCart();
        //check the product own category and parents of it contains selected category
        return cart.getEntries().stream().filter(o ->
                (o.getProduct().getCategory().getTitle().equals(category.getTitle())
                || categoryService.isSubCategory(o.getProduct().getCategory(), category)))
                .collect(Collectors.toList());
    }
}
