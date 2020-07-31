package com.example.shoppingcart.services.category;

import com.example.shoppingcart.models.Category;

public class CategoryService implements ICategoryService {

    @Override
    public boolean isSubCategory(Category first, Category second) {
        Category parent = first.getParent();
        while (null != parent) {
            if(first.getTitle().equals(parent.getTitle())){
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }
}
