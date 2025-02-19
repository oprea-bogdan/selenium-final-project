package org.automation.constants;

public enum ProductDetails {

    FIRST_TITLE("Scythe"),
    SECOND_TITLE("Endurance"),
    THIRD_TITLE("The Hunger Games");

    public final String product;

    ProductDetails(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}
