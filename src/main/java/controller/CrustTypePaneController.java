/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.CrustType;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class CrustTypePaneController extends SingleChoicePaneController implements BaseController{

    public CrustTypePaneController(SelectionState selectionState) {
        super(selectionState);
    }
    
    @Override
    public void updateView(){
    }
    
    @Override
    protected Class getEnumClass() {
        return CrustType.class;
    }

    @Override
    public void saveTo() {
        selectionState.crust = (CrustType) getSelectedValue();
    }

    @Override
    public void loadFrom() {
        setSelectedValue(selectionState.crust);
    }
    
}
