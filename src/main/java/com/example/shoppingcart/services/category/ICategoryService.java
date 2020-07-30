package com.example.shoppingcart.services.category;

import com.example.shoppingcart.models.Category;

public interface ICategoryService {

    /**
     * check is fist parent category of second.
     *
     * @param  first  parent category
     * @param  second child category
     * @return        is parent
     */
    boolean isSubCategory(Category first, Category second);
}
