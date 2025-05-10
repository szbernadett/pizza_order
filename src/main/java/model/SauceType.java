/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author igbin
 */
public enum SauceType {
    TOMATO,
    BBQ;

    @Override
    public String toString() {
        return name().equals("BBQ") ? name() : name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
    
   
}
