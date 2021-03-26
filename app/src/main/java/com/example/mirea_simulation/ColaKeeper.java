package com.example.mirea_simulation;

public class ColaKeeper extends ProductKeeper {
    public ColaKeeper(Automat new_automat) {
        super(new_automat);
    }

    @Override
    Product createProduct() {
        return new Cola();
    }
}
