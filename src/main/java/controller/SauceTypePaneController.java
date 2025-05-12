/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import model.SauceType;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class SauceTypePaneController extends SingleChoicePaneController implements BaseController {

    public SauceTypePaneController(SelectionState selectionState) {
        super(selectionState);
    }

    @Override
        public void updateView(){
             for (Node node : this.optionsBox.getChildren()) {
            RadioButton rb = (RadioButton) node;
            if ( selectionState.sauce.equals(rb.getUserData())) {
                rb.setSelected(true);
                break;
            }
        }
    }
    
    @Override
    protected Class getEnumClass() {
        return SauceType.class;
    }

    @Override
    public void saveTo() {
        saveSelectedRadioButtonValue();
        selectionState.sauce = (SauceType) getSelectedValue();
    }

    @Override
    public void loadFrom() {
        setSelectedValue(selectionState.sauce);
    }
    
}
