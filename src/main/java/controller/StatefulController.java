/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import javafx.fxml.Initializable;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public abstract class StatefulController implements Initializable {
    
    protected final SelectionState selectionState;

    public StatefulController(SelectionState selectionState) {
        this.selectionState = selectionState;
    }

    public SelectionState getSelectionState() {
        return selectionState;
    }
    
    public abstract void saveTo();
    public abstract void loadFrom();

}
