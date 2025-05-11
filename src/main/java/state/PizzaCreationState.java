/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import controller.StateContext;
import controller.StatefulController;
import java.util.Optional;
import javafx.fxml.Initializable;

/**
 *
 * @author igbin
 */
public class PizzaCreationState extends ApplicationState {
    
    public PizzaCreationState(StateContext context) {
        super(context);
    }
    

    @Override
    public void onNext() {
        if (context.hasNextStep()) {
            if (!context.isStepInState(PizzaCreationState.class, context.getCurrentStepIndex() + 1)) {
                OrderConfirmationState ocs = new OrderConfirmationState(context);
                context.setApplicationState(ocs);
                ocs.onEnter();
            }
            context.showNextStep();
        }
    }

    @Override
    public void onBack() {
        if(!context.isStepInState(PizzaCreationState.class, context.getCurrentStepIndex() - 1)){
            context.setApplicationState(new GreetingState(context));
        }
        context.showPreviousStep();
    }
    
}
