package com.example.fooddelivery.model;

public class DataController {
    public static DataController instance;
    public static DataController getInstance(){
        if(instance==null)
            instance = new DataController();

        return instance;

    }

    public RestaurantInterface getRestaurantInterface() {
        return restaurantInterface;
    }

    public void setRestaurantInterface(RestaurantInterface restaurantInterface) {
        this.restaurantInterface = restaurantInterface;
    }

    RestaurantInterface restaurantInterface;
}
