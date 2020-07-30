package com.example.shoppingcart.services.category;

import com.example.shoppingcart.models.Category;

public class CategoryService implements ICategoryService {
    
    @Override
    public boolean isSubCategory(Category first, Category second) {
        return false;
    }
}
