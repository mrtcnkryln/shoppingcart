package com.example.shoppingcart.services.category;

import com.example.shoppingcart.models.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Override
    public boolean isSubCategory(Category first, Category second) {
        Category parent = first.getParent();
        while (null != parent) { //check all possible parent objects
            if(second.getTitle().equals(parent.getTitle())){
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }
}
