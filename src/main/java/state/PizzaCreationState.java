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
public class PizzaCreationState extends ApplicationState {
    
    public PizzaCreationState(StateContext context, StateName stateName) {
        super(context, stateName);
    }
    

    @Override
    public void onNext() {
        if (context.hasNextStep()) {
            if (!context.isStepInState(getStateName(), context.getCurrentStepIndex() + 1)) {
                OrderConfirmationState ocs = new OrderConfirmationState(context, StateName.ORDER_CONRIMATION);
                context.setApplicationState(ocs);
                ocs.onEnter();
            }
            context.showNextStep();
        }
    }

    @Override
    public void onBack() {
        if(!context.isStepInState(getStateName(), context.getCurrentStepIndex() - 1)){
            context.setApplicationState(new GreetingState(context, StateName.GREETING));
        }
        context.showPreviousStep();
    }
    
}
