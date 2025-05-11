/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igbin
 */

public class Pizza {
    private Size size;
    private CrustType crust;
    private SauceType sauce;
    private CheeseType cheese;
    private List<Topping> toppings = new ArrayList<>();
    private double price;
    
    // Private constructor for builder
    private Pizza() {}
    
    // Getters
    public Size getSize() { return size; }
    public CrustType getCrust() { return crust; }
    public SauceType getSauce() { return sauce; }
    public CheeseType getCheese() { return cheese; }
    public List<Topping> getToppings() { return new ArrayList<>(toppings); }
    public double getPrice() { return price; }
    
    // Builder class
    public static class Builder {
        private Pizza pizza = new Pizza();
        
        public Builder size(Size size) {
            pizza.size = size;
            updatePrice(size.getPrice());
            return this;
        }
        
        public Builder crust(CrustType crust) {
            pizza.crust = crust;
            updatePrice(crust.getPrice());
            return this;
        }
        
        public Builder sauce(SauceType sauce) {
            pizza.sauce = sauce;
            return this;
        }
        
        public Builder cheese(CheeseType cheese) {
            pizza.cheese = cheese;
            updatePrice(cheese.getPrice());
            return this;
        }
        
        public Builder toppings (List<Topping> toppings) {
            pizza.toppings = toppings;
            return this;
        }
        
        private void updatePrice(double addPrice) {
            if(addPrice > 0) pizza.price = pizza.price + addPrice;
        }
        
        public Pizza build() {
            return pizza;
        }
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size != null ? size.name().toLowerCase() : "no size");
        sb.append(", ").append(crust != null ? crust.name().toLowerCase() + " crust" : "no crust");
        sb.append(", ").append(sauce != null ? sauce.name().toLowerCase() + " sauce" : "no sauce");
        sb.append(", ").append(cheese != null ? cheese.name().toLowerCase() + " cheese" : "no cheese");

        sb.append(", toppings: ");
        if (toppings.isEmpty()) {
            sb.append("none");
        } else {
            for (Topping topping : toppings) {
                sb.append(topping.name().toLowerCase()).append(" ");
            }
        }

        sb.append(", total price: £").append(String.format("%.2f", price));

        return sb.toString().trim();
    }
}
