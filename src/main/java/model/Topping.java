/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author igbin
 */
public enum Topping {
    PEPPERONI,
    HAM,
    BACON,
    CHICKEN,
    PEPPER,
    ONION,
    MUSHROOM,
    SWEETCORN;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
  
}
