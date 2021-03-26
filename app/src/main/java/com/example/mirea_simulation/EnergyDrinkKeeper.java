package com.example.mirea_simulation;

public class EnergyDrinkKeeper extends ProductKeeper {
    public EnergyDrinkKeeper(Automat new_automat) {
        super(new_automat);
    }

    @Override
    Product createProduct() {
        return new EnergyDrink();
    }
}
