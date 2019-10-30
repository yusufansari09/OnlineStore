package com.TestVagrant.onlineStore;

public class Item {

    private ItemName name;
    private double price;
    private int quantity;

    public Item(ItemName name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ItemName getName() {
        return name;
    }

    public void setName(ItemName name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
