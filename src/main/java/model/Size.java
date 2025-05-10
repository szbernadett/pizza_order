/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author igbin
 */

public enum Size {
    SMALL(8.99),
    MEDIUM(10.99),
    LARGE(12.99);
    
    private final double price;
    
    Size(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}
