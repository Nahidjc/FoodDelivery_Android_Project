package com.example.fooddelivery.model;

import java.util.List;

public class DataController {
    public static DataController instance;
    public static DataController getInstance(){
        if(instance==null)
            instance = new DataController();

        return instance;

    }

//    public RestaurantInterface getRestaurantInterface() {
//        return restaurantInterface;
//    }
//
//    public void setRestaurantInterface(RestaurantInterface restaurantInterface) {
//        this.restaurantInterface = restaurantInterface;
//    }

    public RestaurantInterface getRestaurantInterface() {
        return restaurantInterface;
    }

    public void setRestaurantInterface(RestaurantInterface restaurantInterface) {
        this.restaurantInterface = restaurantInterface;
    }

    RestaurantInterface restaurantInterface;

    public List<MenuItem> getCurrentMenuItemList() {
        return currentMenuItemList;
    }

    public void setCurrentMenuItemList(List<MenuItem> currentMenuItemList) {
        this.currentMenuItemList = currentMenuItemList;
    }

    List<MenuItem> currentMenuItemList;
}
