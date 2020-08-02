package com.example.shoppingcart;

import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.services.category.ICategoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CategoryTest extends AbstractTestClass {
    @Autowired
    ICategoryService categoryService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void categoryServiceIsSubCategoryReturnFalseWithNoParents(){
        Category categoryFirst = new Category("shoes");
        Category categorySecond = new Category("food");
        boolean result = categoryService.isSubCategory(categoryFirst, categorySecond);
        assertFalse(result);
    }

    @Test
    public void categoryServiceIsSubCategoryReturnFalseWithNoParentRelation(){
        Category categoryFirst = new Category("shoes");
        Category categorySecond = new Category("nike", categoryFirst);
        Category categoryThird = new Category("food");
        boolean result = categoryService.isSubCategory(categorySecond, categoryThird);
        assertFalse(result);
    }

    @Test
    public void categoryServiceIsSubCategoryReturnTrueFirstParent(){
        Category categoryFirst = new Category("shoes");
        Category categorySecond = new Category("nike", categoryFirst);
        boolean result = categoryService.isSubCategory(categorySecond, categoryFirst);
        assertTrue(result);
    }

    @Test
    public void categoryServiceIsSubCategoryReturnTrueGrandParent(){
        Category categoryFirst = new Category("shoes");
        Category categorySecond = new Category("nike", categoryFirst);
        Category categoryThird = new Category("nike running", categorySecond);
        boolean result = categoryService.isSubCategory(categoryThird, categoryFirst);
        assertTrue(result);
    }
}
