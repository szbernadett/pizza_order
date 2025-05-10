/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.Initializable;
import model.Size;

/**
 *
 * @author igbin
 */
public class SizePaneController extends SingleChoicePaneController implements Initializable {

    @Override
    protected Class getEnumClass() {
        return Size.class;
    }
}
