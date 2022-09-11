package io.ecom.practice.Product.enums;

public enum SubCategory {
    MobilePhones(Category.Electronics),
    Watches(Category.Electronics),
    Sandals(Category.FootWears),
    Slippers(Category.FootWears);
    SubCategory(Category c) {
    }
}
