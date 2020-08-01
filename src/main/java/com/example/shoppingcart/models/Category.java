package com.example.shoppingcart.models;

/**
 * The Category class is using for define product groups
 * each category may or may not have a parent category.
 */
public class Category {
    private String title;
    private Category parent;

    public Category(String title) {
        this.title = title;
    }

    public Category(String title, Category parent) {
        this.title = title;
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
