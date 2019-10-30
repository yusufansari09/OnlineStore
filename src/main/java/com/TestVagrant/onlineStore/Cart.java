package com.TestVagrant.onlineStore;

import java.util.List;

public class Cart {
    private List<Item> items;
    private double cartValue;
    private boolean isPromoApplied = false;

    public Cart(List<Item> items) {
        this.items = items;
        cartValue = getCartValue();
    }
    
    public double getFinalCartValue()
    {
    	return cartValue;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setCartValue() {
        cartValue = getCartValue();
    }

    public boolean isPromoApplied() {
        return isPromoApplied;
    }

    public double getCartValue(){
        double cartValue = 0;
        for (Item item: items) {
            if(item.getQuantity()/3 >= 1) {
                cartValue = cartValue + item.getPrice() * item.getQuantity();
                item.setQuantity(item.getQuantity()+item.getQuantity()/3);
                isPromoApplied = true;
            }
            else
            	cartValue = cartValue + item.getPrice() * item.getQuantity();
        }
        return cartValue;
    }
}
