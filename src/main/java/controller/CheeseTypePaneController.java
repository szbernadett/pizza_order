/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.Initializable;
import model.CheeseType;

/**
 *
 * @author igbin
 */
public class CheeseTypePaneController extends SingleChoicePaneController implements Initializable{

    @Override
    protected Class getEnumClass() {
        return CheeseType.class;
    }
    
}
