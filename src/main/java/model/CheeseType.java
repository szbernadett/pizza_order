/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author igbin
 */
public enum CheeseType {
    MOZZARELLA(0),
    VEGAN_CHEESE(1.50);

    private final double price;
    
    CheeseType(double price){
        this.price = price;
    }
    
     public double getPrice() {
        return price;
    }
     
    @Override
    public String toString() {
       String displayName = name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        String nameWithPrice = getPrice() == 0 ? displayName : displayName + "( + £" + getPrice()+ " )";
        
        return nameWithPrice;
    }
    
    
    
}
