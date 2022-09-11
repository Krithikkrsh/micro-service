package io.ecom.practice.Product.enums;

import java.util.EnumSet;

public enum Category {
    Electronics("electronics"),
    Stationary("stationary"),
    Clothes("clothes"),
    FootWears("footWears");

    private final String categoryName;


    private Category(String name){
        this.categoryName = name;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

}
