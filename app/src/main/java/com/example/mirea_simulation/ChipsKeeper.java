package com.example.mirea_simulation;

public class ChipsKeeper extends ProductKeeper {
    public ChipsKeeper(Automat new_automat) {
        super(new_automat);
    }

    @Override
    Product createProduct() {
        return new Chips();
    }
}
