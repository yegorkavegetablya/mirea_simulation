package com.example.mirea_simulation;

public class ChocolateKeeper extends ProductKeeper {
    public ChocolateKeeper(Automat new_automat) {
        super(new_automat);
    }

    @Override
    Product createProduct() {
        return new Chocolate();
    }
}
