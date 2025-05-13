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
    StateName stateName;
    
    ApplicationState(StateContext context, StateName stateName){
        this.context = context;
        this.stateName = stateName;
    }
        
    public abstract void onNext();
    public abstract void onBack();
    public StateName getStateName(){ return this.stateName; }
    
    public enum StateName { GREETING, PIZZA_CREATION, ORDER_CONRIMATION } 
    
}
