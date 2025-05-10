/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.Initializable;
import model.CrustType;

/**
 *
 * @author igbin
 */
public class CrustTypePaneController extends SingleChoicePaneController implements Initializable {

    @Override
    protected Class getEnumClass() {
        return CrustType.class;
    }
    
}
