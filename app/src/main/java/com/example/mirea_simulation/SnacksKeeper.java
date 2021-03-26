package com.example.mirea_simulation;

public class SnacksKeeper extends ProductKeeper {
    public SnacksKeeper(Automat new_automat) {
        super(new_automat);
    }

    @Override
    Product createProduct() {
        return new Snacks();
    }
}
