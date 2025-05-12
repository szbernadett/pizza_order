/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import controller.BaseController;
import controller.OrderDetailsPaneController;
import controller.StateContext;
import java.util.Optional;
import javafx.fxml.Initializable;
import model.Pizza;
import util.SelectionState;

/**
 *
 * @author igbin
 */
public class OrderConfirmationState extends ApplicationState {
    
    public OrderConfirmationState(StateContext context) {
        super(context);
    }

    
    public void onEnter() {
        Optional<BaseController> controller = context.getControllerForState(OrderConfirmationState.class);
        OrderDetailsPaneController odpController;
        if(controller.isPresent()){
            odpController = (OrderDetailsPaneController)  controller.get();
        
            SelectionState selState = context.getSelectionState();
            Pizza pizza =  new Pizza.Builder()
                    .size(selState.size)
                    .crust(selState.crust)
                    .sauce(selState.sauce) 
                    .toppings(selState.toppings)
                    .cheese(selState.cheese)
                    .build();
            odpController.setPizza(pizza);
            context.showCurrentStep();
        }
    }

    @Override
    public void onNext() {
        // Finalize order
    }

    @Override
    public void onBack() {
        context.setApplicationState(new PizzaCreationState(context));
        context.showPreviousStep();
    }
    
}
