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
private static final SelectionState INSTANCE = new SelectionState();

    public Size size;
    public CrustType crust;
    public SauceType sauce;
    public CheeseType cheese;
    public List<Topping> toppings = new ArrayList<>();

    private SelectionState() {
        this.size = Size.LARGE; // must match what's selected by default in the FXML view
        this.crust = CrustType.CLASSIC;
        this.sauce = SauceType.TOMATO;
        this.cheese = CheeseType.MOZZARELLA;
        // toppings list starts empty
    }

    public static SelectionState getInstance() {
        return INSTANCE;
    }
    
}
