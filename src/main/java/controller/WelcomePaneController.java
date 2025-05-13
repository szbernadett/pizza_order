/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleRole;
import javafx.scene.control.Label;

/**
 *
 * @author igbin
 */
public class WelcomePaneController implements Initializable, BaseController{
    
    @FXML private Label introductionLbl;
    @FXML private Label greetingsLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       updateView();
    }
 
    @Override
        public void updateView(){
             greetingsLbl.setAccessibleRole(AccessibleRole.TEXT);
        greetingsLbl.setFocusTraversable(true);
        // greetingsLbl.setAccessibleText("Welcome to the Pizza Order App!");
        greetingsLbl.setText("Welcome to the Pizza Order App!");
        introductionLbl.setAccessibleRole(AccessibleRole.TEXT);
        introductionLbl.setFocusTraversable(true);
        introductionLbl.setAccessibleText("You will be able to modify the size, crust type, sauce and cheese type and select from a range of toppings. Click on the Next button to start your order.");
        introductionLbl.setText("You will be able to modify the size, crust type, sauce and cheese type and select from a range of toppings. Click on the Next button to start your order.");
    }
}
