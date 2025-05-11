/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
    }
    
    @Override
    protected Class getEnumClass() {
        return SauceType.class;
    }

    @Override
    public void saveTo() {
        selectionState.sauce = (SauceType) getSelectedValue();
    }

    @Override
    public void loadFrom() {
        setSelectedValue(selectionState.sauce);
    }
    
}
