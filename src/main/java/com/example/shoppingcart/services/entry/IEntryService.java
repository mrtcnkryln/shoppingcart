package com.example.shoppingcart.services.entry;

import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.models.Entry;

import java.util.List;

public interface IEntryService {

    /**
     * find entries of selected category.
     *
     * @param  category  selected category
     * @return           entry list
     */
    List<Entry> entryListByCategory(Category category);
}
