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
public class GreetingState extends ApplicationState {

    public GreetingState(StateContext context, StateName stateName) {
        super(context, stateName);
    }
    


    @Override
    public void onNext() {
        context.setApplicationState(new PizzaCreationState(context, StateName.PIZZA_CREATION));
        context.showNextStep(); // Transition to pizza creation
    }

    @Override
    public void onBack() {
        // No-op: already at first step
    }

}
