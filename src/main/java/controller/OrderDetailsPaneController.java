/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Pizza;

/**
 *
 * @author igbin
 */
public class OrderDetailsPaneController implements Initializable {
    
    @FXML private Label pizzaDetailsLbl;
    @FXML private Label customerDetailsLbl;
    private Pizza pizza;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    public void setPizza(Pizza pizza){
        this.pizza = pizza;
    }
}
