package com.example.mirea_simulation;

public class WaterKeeper extends ProductKeeper {
    public WaterKeeper(Automat new_automat) {
        super(new_automat);
    }

    @Override
    Product createProduct() {
        return new Water();
    }
}
