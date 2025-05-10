/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.Initializable;
import model.SauceType;

/**
 *
 * @author igbin
 */
public class SauceTypePaneController extends SingleChoicePaneController implements Initializable {

    @Override
    protected Class getEnumClass() {
        return SauceType.class;
    }
    
}
