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

/**
 *
 * @author igbin
 */
public class WelcomePaneController implements Initializable, BaseController{
    
    @FXML private Label greetingsLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        greetingsLbl.setText("You will be able to modify the size, crust type, sauce and cheese type and select from a range of toppings. Clickon the Next button to start your order.");
    }
 
    @Override
        public void updateView(){
    }
}
