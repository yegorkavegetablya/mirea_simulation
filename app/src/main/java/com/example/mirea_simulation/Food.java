package com.example.mirea_simulation;

public class Food extends Product {
    int weight;

    public Food(int new_price, int new_weight) {
        super(new_price);

        weight = new_weight;
    }
}
