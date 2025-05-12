/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import model.Size;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class SizePaneController extends SingleChoicePaneController implements BaseController {
    

    public SizePaneController(SelectionState selectionState) {
        super(selectionState);
    }
    
    @Override
     public void updateView(){
        for (Node node : this.optionsBox.getChildren()) {
            RadioButton rb = (RadioButton) node;
            if ( selectionState.size.equals(rb.getUserData())) {
                rb.setSelected(true);
                break;
            }
        }
    }

    @Override
    protected Class getEnumClass() {
        return Size.class;
    }

    @Override
    public void saveTo() {
        saveSelectedRadioButtonValue();
        selectionState.size = (Size) getSelectedValue();
    }

    @Override
    public void loadFrom() {
        setSelectedValue(selectionState.size);
    }
    
  
}
