/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author igbin
 */
public enum CrustType {
    REGULAR(0),
    THIN(0.50),
    DEEP_PAN(0.50);
    
    private final double price;
    
    CrustType(double price) {
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
