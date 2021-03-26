package com.example.mirea_simulation;

public class Drink extends Product {
    int volume;

    public Drink(int new_price, int new_volume) {
        super(new_price);

        volume = new_volume;
    }
}
