/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.fxml.Initializable;
import model.Size;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class SizePaneController extends SingleChoicePaneController implements Initializable, StatefulController {

    private SelectionState state;
    
    @Override
    protected Class getEnumClass() {
        return Size.class;
    }

    @Override
    public void saveTo(SelectionState state) {
        saveSelection();
        state.size = (Size) getSelectedValue();
    }

    @Override
    public void loadFrom(SelectionState state) {
        setSelectedValue(state.size);
    }
    
    public void setSelectionState(SelectionState state){
        this.state = state;
    }
}
