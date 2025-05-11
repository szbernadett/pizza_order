/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import model.CheeseType;
import model.CrustType;
import model.SauceType;
import model.Size;
import model.Topping;

/**
 *
 * @author igbin
 */
public class SelectionState {
    public Size size;
    public CrustType crust;
    public SauceType sauce;
    public List<Topping> toppings = new ArrayList<>();
    public CheeseType cheese;
}
