package com.example.mirea_simulation;

import java.util.ArrayList;

public abstract class ProductKeeper {
    private ArrayList<Product> products;
    Automat automat;

    public ProductKeeper(Automat new_automat) {
        products = new ArrayList<Product>();
        automat = new_automat;
    }

    public void addProducts(int amount) {
        for (int i = 0; i < amount; i++) {
            products.add(createProduct());
        }
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public int left() {
        return products.size();
    }

    Product getProduct() {
        if (!this.isEmpty()) {
            Product current_product = products.get(0);
            products.remove(0);
            automat.current_sum += current_product.price;
            return current_product;
        }
        else {
            return null;
        }
    }

    abstract Product createProduct();
}
