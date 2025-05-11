/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import controller.StateContext;

/**
 *
 * @author igbin
 */
public abstract class ApplicationState {
    StateContext context;
    
    ApplicationState(StateContext context){
        this.context = context;
    }
        
    public abstract void onNext();
    public abstract void onBack();
    
}
