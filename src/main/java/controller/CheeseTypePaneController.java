/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.CheeseType;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class CheeseTypePaneController extends SingleChoicePaneController implements BaseController {

    public CheeseTypePaneController(SelectionState selectionState) {
        super(selectionState);
    }

    @Override
    public void updateView(){
    }
    
    @Override
    protected Class getEnumClass() {
        return CheeseType.class;
    }

    @Override
    public void saveTo() {
        selectionState.cheese = (CheeseType) getSelectedValue();
    }

    @Override
    public void loadFrom() {
        setSelectedValue(selectionState.cheese);
    }
    
}
