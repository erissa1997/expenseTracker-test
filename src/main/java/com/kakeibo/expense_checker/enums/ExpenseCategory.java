package com.kakeibo.expense_checker.enums;

public enum ExpenseCategory {
    UTILITY,
    FOOD,
    COMODITY,
    SERVICE,
    EDUCATION,
    MEDICAL,
    LEISURE_TRAVEL,
    OTHER;

    public enum CommoditySubCategory {
        COSMETICS,
        HOUSING_CLEANING,
        HOUSING_STORAGE,
        CLOTHE
    }

    public enum FoodSubCategory {
        SNACK,
        VEGETABLE,
        FISH
    }

    public enum LeisureSubCategory {
        TRAVEL_TRANSPORTATION,
        HOTEL,
        DINE_OUT
    }
}
